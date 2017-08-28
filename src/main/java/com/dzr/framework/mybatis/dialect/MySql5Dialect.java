package com.dzr.framework.mybatis.dialect;


public class MySql5Dialect extends Dialect {
	protected static final String SQL_END_DELIMITER = ";";
	

	public String getLimitString(String sql, boolean hasOffset) {
		return MySql5PageHepler.getLimitString(sql, -1, -1);
	}

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.getLimitString(sql, offset, limit);
	}

	public boolean supportsLimit() {
		return true;
	}

	@Override
	public String addLog(String sql) {
		// TODO Auto-generated method stub
		return sql;
	}

}