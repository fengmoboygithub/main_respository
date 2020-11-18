package otc.tech.storage;

/**
 * 单元格小组
 * 
 * @author roma
 * 
 */
public class CellGroup {
	private String id;
	private String parentId;
	private String name;
	private String conceptName;
	private String groupType;
	private String action;
	public static final String ACTION_DELETE = "delete";
	public static final String ACTION_SAVE = "save";
	public static final String GROUP_TUPLE = "tuple";
	public static final String GROUP_FOR = "for";

	public CellGroup() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * Excel单元格名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 对应tuple或其他元素名QName
	 * 
	 * @return
	 */
	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	/**
	 * 当前group类型
	 * 
	 * @return
	 */
	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 拷贝
	 * 
	 * @return
	 */
	public CellGroup copyCellGroup() {
		CellGroup group = new CellGroup();
		group.setName(this.name);
		group.setAction(this.action);
		group.setGroupType(this.groupType);
		group.setConceptName(this.conceptName);
		group.setId(this.id);
		return group;
	}

}
