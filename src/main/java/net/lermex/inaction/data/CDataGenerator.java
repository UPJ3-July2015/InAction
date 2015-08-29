package net.lermex.inaction.data;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import org.h2.tools.RunScript;

public class CDataGenerator {
	
	public static void generateData() throws SQLException {
		Locale.setDefault(Locale.ENGLISH);
		org.h2.jdbcx.JdbcDataSource ds = new org.h2.jdbcx.JdbcDataSource();
		ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		try (Connection conn = ds.getConnection()) {
			InputStream in = new CDataGenerator().getClass().getResourceAsStream("/script.sql"); //ansi
			RunScript.execute(conn, new InputStreamReader(in));
		}
	}

}
