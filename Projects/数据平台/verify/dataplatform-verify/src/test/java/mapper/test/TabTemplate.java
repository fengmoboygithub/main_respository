package mapper.test;

import java.io.Serializable;

public class TabTemplate implements Serializable {
    private Integer id;

    private String tTemplateType;

    private String tElementId;

    private String tElementName;

    private String tValidateRules;

    private String dField;

    private String dFieldType;

    private String dTableName;

    private String dIsTuple;

    private String status;

    private String dDict;

    private String remark;

    private String dTupleUpName;

    private String tControlType;

    private String reporttypeTypeId;

    private String dTupleUpXbrlName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettTemplateType() {
        return tTemplateType;
    }

    public void settTemplateType(String tTemplateType) {
        this.tTemplateType = tTemplateType;
    }

    public String gettElementId() {
        return tElementId;
    }

    public void settElementId(String tElementId) {
        this.tElementId = tElementId;
    }

    public String gettElementName() {
        return tElementName;
    }

    public void settElementName(String tElementName) {
        this.tElementName = tElementName;
    }

    public String gettValidateRules() {
        return tValidateRules;
    }

    public void settValidateRules(String tValidateRules) {
        this.tValidateRules = tValidateRules;
    }

    public String getdField() {
        return dField;
    }

    public void setdField(String dField) {
        this.dField = dField;
    }

    public String getdFieldType() {
        return dFieldType;
    }

    public void setdFieldType(String dFieldType) {
        this.dFieldType = dFieldType;
    }

    public String getdTableName() {
        return dTableName;
    }

    public void setdTableName(String dTableName) {
        this.dTableName = dTableName;
    }

    public String getdIsTuple() {
        return dIsTuple;
    }

    public void setdIsTuple(String dIsTuple) {
        this.dIsTuple = dIsTuple;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getdDict() {
        return dDict;
    }

    public void setdDict(String dDict) {
        this.dDict = dDict;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getdTupleUpName() {
        return dTupleUpName;
    }

    public void setdTupleUpName(String dTupleUpName) {
        this.dTupleUpName = dTupleUpName;
    }

    public String gettControlType() {
        return tControlType;
    }

    public void settControlType(String tControlType) {
        this.tControlType = tControlType;
    }

    public String getReporttypeTypeId() {
        return reporttypeTypeId;
    }

    public void setReporttypeTypeId(String reporttypeTypeId) {
        this.reporttypeTypeId = reporttypeTypeId;
    }

    public String getdTupleUpXbrlName() {
        return dTupleUpXbrlName;
    }

    public void setdTupleUpXbrlName(String dTupleUpXbrlName) {
        this.dTupleUpXbrlName = dTupleUpXbrlName;
    }
}