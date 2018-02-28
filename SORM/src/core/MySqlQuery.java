package core;

import java.awt.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ColumnInfo;
import bean.TableInfo;
import utils.JDBCUtils;
import utils.ReflectUtils;
import utils.StringUtils;

/**
 * 负责针对mysql数据库查询(对外提供服务的核心类)
 * 
 * @author 非洲
 *
 */
public class MySqlQuery extends Query {
	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
