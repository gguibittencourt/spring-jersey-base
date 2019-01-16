/*
 * This file is generated by jOOQ.
*/
package br.com.spring.jersey.dao.metadata.tables.records;


import br.com.spring.jersey.dao.metadata.tables.ReProcessKnowledgeArea;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReProcessKnowledgeAreaRecord extends UpdatableRecordImpl<ReProcessKnowledgeAreaRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -2085986553;

    /**
     * Setter for <code>app.re_process_knowledge_area.id_process</code>.
     */
    public void setIdProcess(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>app.re_process_knowledge_area.id_process</code>.
     */
    public Integer getIdProcess() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>app.re_process_knowledge_area.id_knowledge_area</code>.
     */
    public void setIdKnowledgeArea(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>app.re_process_knowledge_area.id_knowledge_area</code>.
     */
    public Integer getIdKnowledgeArea() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ReProcessKnowledgeArea.RE_PROCESS_KNOWLEDGE_AREA.ID_PROCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ReProcessKnowledgeArea.RE_PROCESS_KNOWLEDGE_AREA.ID_KNOWLEDGE_AREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdProcess();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdKnowledgeArea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReProcessKnowledgeAreaRecord value1(Integer value) {
        setIdProcess(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReProcessKnowledgeAreaRecord value2(Integer value) {
        setIdKnowledgeArea(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReProcessKnowledgeAreaRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReProcessKnowledgeAreaRecord
     */
    public ReProcessKnowledgeAreaRecord() {
        super(ReProcessKnowledgeArea.RE_PROCESS_KNOWLEDGE_AREA);
    }

    /**
     * Create a detached, initialised ReProcessKnowledgeAreaRecord
     */
    public ReProcessKnowledgeAreaRecord(Integer idProcess, Integer idKnowledgeArea) {
        super(ReProcessKnowledgeArea.RE_PROCESS_KNOWLEDGE_AREA);

        set(0, idProcess);
        set(1, idKnowledgeArea);
    }
}