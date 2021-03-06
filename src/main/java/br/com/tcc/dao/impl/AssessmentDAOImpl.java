package br.com.tcc.dao.impl;

import br.com.tcc.dao.AssessmentDAO;
import br.com.tcc.dao.metadata.Tables;
import br.com.tcc.dao.metadata.enums.AssessmentStatus;
import br.com.tcc.dto.Assessment;
import br.com.tcc.dto.JsonAssessment;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.SelectSelectStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class AssessmentDAOImpl implements AssessmentDAO {

    private final DSLContext dslContext;
    private static final Gson GSON = new Gson();

    @Autowired
    public AssessmentDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<Assessment> list(Integer idUser) {
        return this.getSelect()
                .from(Tables.ASSESSMENT)
                .where(Tables.ASSESSMENT.ID_USER.eq(idUser))
                .orderBy(Tables.ASSESSMENT.DATE.desc())
                .fetch()
                .map(this::template);
    }

    @Override
    public Collection<Assessment> list() {
        return this.getSelect()
                .from(Tables.ASSESSMENT)
                .fetch()
                .map(this::template);
    }


    @Override
    public Assessment get(Integer idAssessment) {
        return this.getSelect()
                .from(Tables.ASSESSMENT)
                .where(Tables.ASSESSMENT.ID_ASSESSMENT.eq(idAssessment))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(Assessment assessment) {
        return this.dslContext
                .insertInto(Tables.ASSESSMENT)
                .set(Tables.ASSESSMENT.ID_USER, assessment.getIdUser())
                .set(Tables.ASSESSMENT.STATUS, assessment.getStatus())
                .set(Tables.ASSESSMENT.DATE, assessment.getDate())
                .set(Tables.ASSESSMENT.JSON_ASSESSMENT, GSON.toJson(assessment.getJsonAssessment()))
                .returning(Tables.ASSESSMENT.ID_ASSESSMENT)
                .fetchOne().getIdAssessment();
    }

    @Override
    public Integer update(Integer idAssessment, Assessment assessment) {
        return this.dslContext
                .update(Tables.ASSESSMENT)
                .set(Tables.ASSESSMENT.ID_USER, assessment.getIdUser())
                .set(Tables.ASSESSMENT.STATUS, assessment.getStatus())
                .set(Tables.ASSESSMENT.DATE, assessment.getDate())
                .set(Tables.ASSESSMENT.JSON_ASSESSMENT, GSON.toJson(assessment.getJsonAssessment()))
                .where(Tables.ASSESSMENT.ID_ASSESSMENT.eq(idAssessment))
                .execute();
    }

    @Override
    public Integer delete(Integer idAssessment) {
        return this.dslContext
                .deleteFrom(Tables.ASSESSMENT)
                .where(Tables.ASSESSMENT.ID_ASSESSMENT.eq(idAssessment))
                .execute();
    }

    private SelectSelectStep<Record5<Integer, Integer, AssessmentStatus, LocalDateTime, String>> getSelect() {
        return this.dslContext
                .select(
                        Tables.ASSESSMENT.ID_ASSESSMENT,
                        Tables.ASSESSMENT.ID_USER,
                        Tables.ASSESSMENT.STATUS,
                        Tables.ASSESSMENT.DATE,
                        DSL.field(
                                "cast({0} as CHAR CHARACTER SET utf8) COLLATE utf8_unicode_ci",
                                String.class,
                                Tables.ASSESSMENT.JSON_ASSESSMENT
                        ).as(Tables.ASSESSMENT.JSON_ASSESSMENT));
    }

    private Assessment template(Record measurementFrameworkRecord) {
        JsonAssessment jsonAssessment = GSON.fromJson(String.valueOf(measurementFrameworkRecord.get(Tables.ASSESSMENT.JSON_ASSESSMENT)), JsonAssessment.class);
        return new Assessment()
                .setIdAssessment(measurementFrameworkRecord.get(Tables.ASSESSMENT.ID_ASSESSMENT))
                .setIdUser(measurementFrameworkRecord.get(Tables.ASSESSMENT.ID_USER))
                .setStatus(measurementFrameworkRecord.get(Tables.ASSESSMENT.STATUS))
                .setDate(measurementFrameworkRecord.get(Tables.ASSESSMENT.DATE))
                .setJsonAssessment(jsonAssessment);
    }
}