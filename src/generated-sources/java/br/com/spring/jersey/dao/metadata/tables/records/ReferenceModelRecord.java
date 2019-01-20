/*
 * This file is generated by jOOQ.
*/
package br.com.spring.jersey.dao.metadata.tables.records;


import br.com.spring.jersey.dao.metadata.tables.ReferenceModel;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class ReferenceModelRecord extends UpdatableRecordImpl<ReferenceModelRecord> implements Record3<Integer, String, Object> {

    private static final long serialVersionUID = -467608013;

    /**
     * Setter for <code>app.reference_model.id_reference_model</code>.
     */
    public void setIdReferenceModel(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>app.reference_model.id_reference_model</code>.
     */
    public Integer getIdReferenceModel() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>app.reference_model.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>app.reference_model.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>app.reference_model.knowledge_areas</code>.
     */
    public void setKnowledgeAreas(Object value) {
        set(2, value);
    }

    /**
     * Getter for <code>app.reference_model.knowledge_areas</code>.
     */
    public Object getKnowledgeAreas() {
        return (Object) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Object> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Object> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ReferenceModel.REFERENCE_MODEL.ID_REFERENCE_MODEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return ReferenceModel.REFERENCE_MODEL.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Object> field3() {
        return ReferenceModel.REFERENCE_MODEL.KNOWLEDGE_AREAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdReferenceModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object value3() {
        return getKnowledgeAreas();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferenceModelRecord value1(Integer value) {
        setIdReferenceModel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferenceModelRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferenceModelRecord value3(Object value) {
        setKnowledgeAreas(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferenceModelRecord values(Integer value1, String value2, Object value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReferenceModelRecord
     */
    public ReferenceModelRecord() {
        super(ReferenceModel.REFERENCE_MODEL);
    }

    /**
     * Create a detached, initialised ReferenceModelRecord
     */
    public ReferenceModelRecord(Integer idReferenceModel, String name, Object knowledgeAreas) {
        super(ReferenceModel.REFERENCE_MODEL);

        set(0, idReferenceModel);
        set(1, name);
        set(2, knowledgeAreas);
    }
}
