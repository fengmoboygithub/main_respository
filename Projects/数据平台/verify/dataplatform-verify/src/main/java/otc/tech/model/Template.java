package otc.tech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table(name = "TAB_TEMPLATE")
public class Template {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;// 主键

	private String tTemplateType;// 模板编号
	
	private String tElementName;// 业务字段名称
	
	private String tElementId;// xbrl元素名称

	private String tValidateRules;// "业务校验规则编号，例如：""ABS_0003,ABS_0004"",如有多个用中文逗号分隔

	private String dField;// 数据库字段名称

	private String dFieldType;// 数据库字段类型，例如： varchar2(200)|number(12.8)

	private String dTableName;// 对应数据库表名

	private Integer status;// 字段状态，0|有效、1|删除

	private String remark;// 备注

	private String dTupleUpName;// 上级tuple数据库字段名称

	private Integer tControlType;// 控件类型0|普通元素、1|Tuple子项元素、2|多附件、3|单附件、4|Tuple父元素（虚元素）
	@Transient
	private Integer dIsTuple;// 是否Tuple，0|否、1|是
	@Transient
	private Template parent; // 父节点
	@Transient
	private List<Template> children = new ArrayList<>(); // 子元素集合
	@Transient
	private String dDict;// 数据字典
	@Transient
	private String dTupleUpXbrlName;// 上级tuple xbrl元素名称
	@Transient
	private Boolean isAbstract = false; // 是否抽象元素（Tuple父节点，没有对应的数据库表字段）
	// private ReportTypes reportType;

	// public ReportTypes getReportType() {
	// return reportType;
	// }
	//
	// public void setReportType(ReportTypes reportType) {
	// this.reportType = reportType;
	// }

	public Boolean getIsAbstract() {
		return isAbstract;
	}

	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public Template getParent() {
		return parent;
	}

	public void setParent(Template parent) {
		this.parent = parent;
	}

	public List<Template> getChildren() {
		return children;
	}

	public void setChildren(List<Template> children) {
		this.children = children;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.t_template_type
	 *
	 * @return the value of TAB_TEMPLATE.t_template_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String gettTemplateType() {
		return tTemplateType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.t_template_type
	 *
	 * @param tTemplateType
	 *            the value for TAB_TEMPLATE.t_template_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void settTemplateType(String tTemplateType) {
		this.tTemplateType = tTemplateType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.t_element_id
	 *
	 * @return the value of TAB_TEMPLATE.t_element_id
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String gettElementId() {
		return tElementId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.t_element_id
	 *
	 * @param tElementId
	 *            the value for TAB_TEMPLATE.t_element_id
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void settElementId(String tElementId) {
		this.tElementId = tElementId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.t_element_name
	 *
	 * @return the value of TAB_TEMPLATE.t_element_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String gettElementName() {
		return tElementName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.t_element_name
	 *
	 * @param tElementName
	 *            the value for TAB_TEMPLATE.t_element_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void settElementName(String tElementName) {
		this.tElementName = tElementName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.t_validate_rules
	 *
	 * @return the value of TAB_TEMPLATE.t_validate_rules
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String gettValidateRules() {
		return tValidateRules;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.t_validate_rules
	 *
	 * @param tValidateRules
	 *            the value for TAB_TEMPLATE.t_validate_rules
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void settValidateRules(String tValidateRules) {
		this.tValidateRules = tValidateRules;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_field
	 *
	 * @return the value of TAB_TEMPLATE.d_field
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdField() {
		return dField;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_field
	 *
	 * @param dField
	 *            the value for TAB_TEMPLATE.d_field
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdField(String dField) {
		this.dField = dField;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_field_type
	 *
	 * @return the value of TAB_TEMPLATE.d_field_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdFieldType() {
		return dFieldType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_field_type
	 *
	 * @param dFieldType
	 *            the value for TAB_TEMPLATE.d_field_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdFieldType(String dFieldType) {
		this.dFieldType = dFieldType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_table_name
	 *
	 * @return the value of TAB_TEMPLATE.d_table_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdTableName() {
		return dTableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_table_name
	 *
	 * @param dTableName
	 *            the value for TAB_TEMPLATE.d_table_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdTableName(String dTableName) {
		this.dTableName = dTableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_is_tuple
	 *
	 * @return the value of TAB_TEMPLATE.d_is_tuple
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public Integer getdIsTuple() {
		return dIsTuple;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_is_tuple
	 *
	 * @param dIsTuple
	 *            the value for TAB_TEMPLATE.d_is_tuple
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdIsTuple(Integer dIsTuple) {
		this.dIsTuple = dIsTuple;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.status
	 *
	 * @return the value of TAB_TEMPLATE.status
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.status
	 *
	 * @param status
	 *            the value for TAB_TEMPLATE.status
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_dict
	 *
	 * @return the value of TAB_TEMPLATE.d_dict
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdDict() {
		return dDict;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_dict
	 *
	 * @param dDict
	 *            the value for TAB_TEMPLATE.d_dict
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdDict(String dDict) {
		this.dDict = dDict;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.remark
	 *
	 * @return the value of TAB_TEMPLATE.remark
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.remark
	 *
	 * @param remark
	 *            the value for TAB_TEMPLATE.remark
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_tuple_up_name
	 *
	 * @return the value of TAB_TEMPLATE.d_tuple_up_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdTupleUpName() {
		return dTupleUpName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_tuple_up_name
	 *
	 * @param dTupleUpName
	 *            the value for TAB_TEMPLATE.d_tuple_up_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdTupleUpName(String dTupleUpName) {
		this.dTupleUpName = dTupleUpName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.t_control_type
	 *
	 * @return the value of TAB_TEMPLATE.t_control_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public Integer gettControlType() {
		return tControlType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.t_control_type
	 *
	 * @param tControlType
	 *            the value for TAB_TEMPLATE.t_control_type
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void settControlType(Integer tControlType) {
		this.tControlType = tControlType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column TAB_TEMPLATE.d_tuple_up_xbrl_name
	 *
	 * @return the value of TAB_TEMPLATE.d_tuple_up_xbrl_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public String getdTupleUpXbrlName() {
		return dTupleUpXbrlName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column TAB_TEMPLATE.d_tuple_up_xbrl_name
	 *
	 * @param dTupleUpXbrlName
	 *            the value for TAB_TEMPLATE.d_tuple_up_xbrl_name
	 *
	 * @mbg.generated Tue Aug 27 17:00:08 CST 2019
	 */
	public void setdTupleUpXbrlName(String dTupleUpXbrlName) {
		this.dTupleUpXbrlName = dTupleUpXbrlName;
	}
}