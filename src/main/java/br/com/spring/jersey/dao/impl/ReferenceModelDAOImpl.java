package br.com.spring.jersey.dao.impl;

import br.com.spring.jersey.dao.ReferenceModelDAO;
import br.com.spring.jersey.dao.metadata.Tables;
import br.com.spring.jersey.dto.KnowledgeArea;
import br.com.spring.jersey.dto.ReferenceModel;
import br.com.spring.jersey.util.Constants;
import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ReferenceModelDAOImpl implements ReferenceModelDAO {

    private final DSLContext dslContext;
    private static final Gson GSON = new Gson();

    @Autowired
    public ReferenceModelDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public Collection<ReferenceModel> list() {
        return this.dslContext
                .selectFrom(Tables.REFERENCE_MODEL)
                .fetch()
                .map(this::template);
    }


    @Override
    public ReferenceModel get(Integer idReferenceModel) {
        return this.dslContext
                .selectFrom(Tables.REFERENCE_MODEL)
                .where(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL.eq(idReferenceModel))
                .fetchOne()
                .map(this::template);
    }

    @Override
    public Integer register(ReferenceModel referenceModel) {
        return this.dslContext
                .insertInto(Tables.REFERENCE_MODEL)
                .set(Tables.REFERENCE_MODEL.NAME, referenceModel.getName())
                .set(Tables.REFERENCE_MODEL.JSON_REFERENCE_MODEL, GSON.toJsonTree(referenceModel.getKnowledgeAreas()))
                .returning(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL)
                .fetchOne().getIdReferenceModel();
    }

    private ReferenceModel template(Record referenceModelRecord) {
        Collection<KnowledgeArea> knowledgeAreas = GSON.fromJson(String.valueOf(referenceModelRecord.get(Tables.REFERENCE_MODEL.JSON_REFERENCE_MODEL)), Constants.KNOWLEDGE_AREA_LIST_TYPE);
        return new ReferenceModel()
                .setIdReferenceModel(referenceModelRecord.get(Tables.REFERENCE_MODEL.ID_REFERENCE_MODEL))
                .setName(referenceModelRecord.get(Tables.REFERENCE_MODEL.NAME))
                .setKnowledgeAreas(knowledgeAreas);
    }
}