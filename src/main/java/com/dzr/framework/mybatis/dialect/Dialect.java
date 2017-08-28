package com.dzr.framework.mybatis.dialect;

/**
 * 数据库方言。
 */
public abstract class Dialect {

	public static enum Type {
		MYSQL, ORACLE, MSSQL;
	}

	public abstract String getLimitString(String sql, int skipResults, int maxResults);
	
	public abstract String addLog(String sql);

}