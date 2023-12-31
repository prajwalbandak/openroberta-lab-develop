package de.fhg.iais.roberta.persistence.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.iais.roberta.util.dbc.Assert;

public class DbExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(DbExecutor.class);

    private final Session session;

    public static DbExecutor make(Session session) {
        return new DbExecutor(session);
    }

    private DbExecutor(Session session) {
        this.session = session;
    }

    public void sqlFile(InputStream sqlStmtFileStream) {
        int count = 0;
        try {
            Reader reader = new InputStreamReader(sqlStmtFileStream, "UTF-8");
            BufferedReader in = new BufferedReader(reader);
            String sqlStmt;
            while ( (sqlStmt = readSqlStmtLinesUntilSemicolon(in)) != null ) {
                count++;
                sqlStmt(sqlStmt);
                this.session.flush();
            }
            sqlStmtFileStream.close();
            LOG.info(count + " SQL-statements executed");
        } catch ( Exception e ) {
            LOG.error("Exception in sql stmt: " + count, e);
        } finally {
            if ( sqlStmtFileStream != null ) {
                try {
                    sqlStmtFileStream.close();
                } catch ( Throwable t ) {
                    // ok here
                }
            }
        }
    }

    /**
     * read from a buffered reader sql statements line by line. The stmt is terminated by a semicolon ';'.
     * Comments and empty lines are ignored. Null indicates, that no stmt could be read.
     *
     * @param reader the source of the sql stmts
     * @return the sql stmt; return null, if the user types 'BYE' in a single line or the reader is exhausted
     */
    public String readSqlStmtLinesUntilSemicolon(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ( (line = reader.readLine()) != null ) {
                line = line.trim();
                if ( line.equals("BYE") ) {
                    return null;
                } else if ( line.startsWith("--") || line.equals("") ) {
                    // next line
                } else if ( line.endsWith(";") ) {
                    line = line.substring(0, line.length() - 1);
                    sb.append(line);
                    String sqlStmt = sb.toString().trim();
                    if ( sqlStmt.equals("") ) {
                        return null; // signals end of stmts
                    } else {
                        return sqlStmt;
                    }
                } else {
                    sb.append(line);
                    sb.append(" \n");
                }
            }
        } catch ( IOException e ) {
            // is no error, stop processing only
        }
        return null; // signals end of stmts
    }

    public void sqlStmt(String sqlStmt) {
        if ( DbExecutor.isSelect(sqlStmt) ) {
            LOG.debug("SQL: " + sqlStmt);
            select(sqlStmt);
        } else if ( DbExecutor.isChange(sqlStmt) ) {
            LOG.debug("UPD: " + sqlStmt);
            update(sqlStmt);
        } else if ( DbExecutor.isDDL(sqlStmt) ) {
            LOG.debug("DDL: " + sqlStmt);
            ddl(sqlStmt);
        } else {
            LOG.error("Ignored: " + sqlStmt);
        }
    }

    @SuppressWarnings("rawtypes")
    public List select(String sqlStmt) {
        List resultSet = this.session.createSQLQuery(sqlStmt).list();
        LOG.debug("got " + resultSet.size() + " rows");
        for ( Object result : resultSet ) {
            if ( result instanceof Object[] ) {
                LOG.debug("  " + Arrays.toString((Object[]) result));
            } else {
                LOG.debug("  " + result);
            }
        }
        return resultSet;
    }

    public Object oneValueSelect(String sqlStmt) {
        @SuppressWarnings("rawtypes") List resultSet = this.session.createSQLQuery(sqlStmt).list();
        Assert.isTrue(resultSet.size() == 1, "result set should contain 1 row, but contains " + resultSet.size() + " rows");
        Object result = resultSet.get(0);
        LOG.debug(result == null ? "null" : result.toString());
        return result;
    }

    public int update(String sqlStmt) {
        int result = this.session.createSQLQuery(sqlStmt).executeUpdate();
        LOG.debug("rows affected: " + result);
        return result;
    }

    public int ddl(String sqlStmt) {
        int result = this.session.createSQLQuery(sqlStmt).executeUpdate();
        LOG.debug("rows affected (probably 0): " + result);
        return result;
    }

    public static boolean isSelect(String sqlStmt) {
        return DbExecutor.sW(sqlStmt, "select ");
    }

    public static boolean isChange(String sqlStmt) {
        return DbExecutor.sW(sqlStmt, "insert ")
            || DbExecutor.sW(sqlStmt, "update ")
            || DbExecutor.sW(sqlStmt, "delete ")
            || sqlStmt.trim().equals("commit");
    }

    public static boolean isDDL(String sqlStmt) {
        return DbExecutor.sW(sqlStmt, "drop ")
            || DbExecutor.sW(sqlStmt, "create ")
            || DbExecutor.sW(sqlStmt, "alter ")
            || DbExecutor.sW(sqlStmt, "backup ")
            || DbExecutor.sW(sqlStmt, "set ");
    }

    private static boolean sW(String testString, String expected) {
        if ( testString.length() < expected.length() ) {
            return false;
        }
        return testString.substring(0, expected.length()).equalsIgnoreCase(expected);
    }
}