package com.example.baremetalschedular;

import org.quartz.impl.jdbcjobstore.oracle.OracleDelegate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Custom Quartz OracleDelegate that binds booleans as "1"/"0" strings
 * to match Quartz's VARCHAR2(1) columns with ojdbc11 23+.
 */
public class OracleQuartzDelegate extends OracleDelegate {

    @Override
    protected void setBoolean(PreparedStatement ps, int index, boolean val) throws SQLException {
        ps.setString(index, val ? "1" : "0");
    }
}

