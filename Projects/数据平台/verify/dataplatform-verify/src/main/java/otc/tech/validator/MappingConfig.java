package otc.tech.validator;

import java.sql.Types;

import com.fasterxml.jackson.annotation.JsonIgnore;

import otc.tech.model.Template;
import otc.tech.storage.CellValue;


/**
 * 数据库要素映射配置信息
 * 
 */
public class MappingConfig {

	private String fieldName; // 表字段名称
	private String conceptID; // 元素ID
	private String columnName; // 中文标签
	private String dataType; // 数据类型
	private int varcharLength; // 字符串长度
	private int numLength; // 数字长度

	public String getConceptID() {
		return conceptID;
	}

	public void setConceptID(String conceptID) {
		this.conceptID = conceptID;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getVarcharLength() {
		if (this.varcharLength == 0 && this.dataType.startsWith("VARCHAR")) {
			int start = this.dataType.indexOf('(');
			int end = this.dataType.indexOf(')');
			if (start > -1 && end > start) {
				String len = this.dataType.substring(start + 1, end);
				this.varcharLength = Integer.valueOf(len);
			}
		}
		return this.varcharLength;
	}

	public int getNumberLength() {
		if (this.numLength == 0 && this.dataType.startsWith("NUMBER")) {
			int start = this.dataType.indexOf('(');
			int end = this.dataType.indexOf(')');
			if (start > -1 && end > start) {
				String len = this.dataType.substring(start + 1, end);
				this.numLength = Integer.valueOf(len);
			}
		}
		return this.numLength;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataType() {
		return dataType;
	}

	private int _typeInt = Integer.MAX_VALUE;

	private int getType() {
		if (_typeInt == Integer.MAX_VALUE) {
			_typeInt = java.sql.Types.VARCHAR;
			if (this.getDataType().startsWith("NUMBER")) {
				_typeInt = java.sql.Types.DECIMAL;
			} else if (this.getDataType().startsWith("DATE")) {
				_typeInt = java.sql.Types.DATE;
			} else if (this.getDataType().startsWith("CLOB")) {
				_typeInt = java.sql.Types.CLOB;
			} else if (this.getDataType().startsWith("BLOB")) {
				_typeInt = java.sql.Types.BLOB;
			} else if (this.getDataType().startsWith("LONG")) {
				_typeInt = java.sql.Types.LONGVARCHAR;
			}
		}
		return _typeInt;
	}

	public boolean isVarchar() {
		return this.getType() == Types.VARCHAR;
	}

	public boolean isLong() {
		return this.getType() == Types.LONGVARCHAR;
	}

	public boolean isDecimal() {
		return this.getType() == Types.DECIMAL;
	}

	@JsonIgnore
	public boolean isClob() {
		return this.getType() == Types.CLOB;
	}

	public boolean isDate() {
		return this.getType() == Types.DATE;
	}

	@JsonIgnore
	public boolean isBlob() {
		return this.getType() == Types.BLOB;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public static MappingConfig adaptive(CellValue cv) {
		if (cv == null) {
			return null;
		}
		MappingConfig mc = new MappingConfig();
		//mc.setConceptID(templateElement.gettElementId());
		mc.setFieldName(cv.getName());
		mc.setDataType(cv.getFieldType());
		mc.setColumnName(cv.getElementName());
		return mc;
	}
}
