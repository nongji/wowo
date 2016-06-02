package cn.edu.hit.nongji.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fangwentong
 * @title H2DataSourceTest
 * @desc H2 database test
 * @date 2016-04-05 10:17
 */

public class H2DataSourceTest extends DaoTestBase {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testH2Count() {
        long count = namedParameterJdbcTemplate.query("select count(*) from wowo.user;", new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return (Long) JdbcUtils.getResultSetValue(rs, 1);
                } else {
                    return 0L;
                }
            }
        });
        Assert.assertTrue(count > 0);
        logger.info("cdb.user cloumns count: {}", count);
    }

    @Test
    public void testH2Select() {
        List<String> userNames = new ArrayList<>();
        namedParameterJdbcTemplate.query("select name from wowo.user limit 10;", new ResultSetExtractor<Void>() {
            @Override
            public Void extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    userNames.add((String) JdbcUtils.getResultSetValue(rs, 1));
                }
                return null;
            }
        });
        logger.info("User Names: {}", userNames);
    }

    @Test
    public void testShowCreateTable() {
        namedParameterJdbcTemplate.update("insert into wowo.assets (base_path, path) VALUES ('a', 'b')", Collections.emptyMap());
        namedParameterJdbcTemplate.query("select * from wowo.assets;", new ResultSetExtractor<Void>() {
            @Override
            public Void extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    System.out.println("\n\n\n");
                    System.out.println(rs.getString(1));
                }
                return null;
            }
        });
    }
}
