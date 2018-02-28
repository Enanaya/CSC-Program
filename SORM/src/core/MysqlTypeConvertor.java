package core;

/**
 * mysql数据类型和java类型的转换
 * @author 非洲
 *
 */
public class MysqlTypeConvertor implements TypeConvertor{

	@Override
	public String databaseType2JavaType(String columnType) {
		// TODO Auto-generated method stub
		//varchar-->string
		if ("varchar".equalsIgnoreCase(columnType)||"char".equalsIgnoreCase(columnType)) {
			return "String";
		}
		else if ("int".equalsIgnoreCase(columnType)||"tinyint".equalsIgnoreCase(columnType)
				||"integer".equalsIgnoreCase(columnType)
				||"smallint".equalsIgnoreCase(columnType)) {
			return "Integer";
		}
		else if ("bigint".equalsIgnoreCase(columnType)){
			return "Loing";
		}else if ("Double".equalsIgnoreCase(columnType)||"float".equalsIgnoreCase(columnType)) {
			return "Double";
		}else if ("clob".equalsIgnoreCase(columnType)) {
			return "java.sql.Clob";
		}else if ("Blob".equalsIgnoreCase(columnType)) {
			return "java.sql.Blob";
		}else if ("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		}else if ("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Time";
		}else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		}
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
