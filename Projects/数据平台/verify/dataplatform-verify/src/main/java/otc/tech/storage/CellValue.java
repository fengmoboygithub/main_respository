package otc.tech.storage;

import org.apache.commons.lang3.StringUtils;

/**
 * 每一个单元格都划入一个组CellGroup。
 * <p>
 * 当单元格引用其他单元格内容时，先在当前组查找，如果当前组没有，到父级组查找。
 * 
 * @author roma
 * 
 */
public class CellValue {
	private String name;
	private String value;
	private String groupId;
	private String text;
	private String FieldType;
	private String ElementName;
	
	public String getFieldType() {
		return FieldType;
	}

	public void setFieldType(String fieldType) {
		FieldType = fieldType;
	}

	public String getElementName() {
		return ElementName;
	}

	public void setElementName(String elementName) {
		ElementName = elementName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	final String ENCODEING = "UTF-8";

	public String getText() {
		if (StringUtils.isEmpty(text) || "null".equals(text))
			return this.value;
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private boolean isEncoding(String value, final String encodeing) {
		try {
			return java.nio.charset.Charset.forName(encodeing).newEncoder()
					.canEncode(value);
		} catch (Exception e) {
			return false;
		}
	}

}
