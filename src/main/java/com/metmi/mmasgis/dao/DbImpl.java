package com.metmi.mmasgis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.metmi.mmasgis.model.Db;

@Service
public class DbImpl implements DbDAO {
	Connection conn;
	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	@Override
	public ArrayList<Db> getDatabases() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		final ArrayList<Db> DbList = new ArrayList<Db>();
		select.query("show databases", new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				Db db = new Db(arg0.getString("Database"));
				DbList.add(db);

			}

		});
		return DbList;

	}

}

class RowReader implements RowCallbackHandler {

	@Override
	public void processRow(ResultSet arg0) throws SQLException {

	}
}