package com.metmi.mmasgis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbImpl implements DbDAO {

	@Override
	public List<DbDAO> getDatabases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * @param jdbcTemplateObject
	 *            the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

}
