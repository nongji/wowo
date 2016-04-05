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

/**
 * @author fangwentong
 * @title H2DataSourceTest
 * @desc TODO
 * @date 2016-04-05 10:17
 */

public class H2DataSourceTest extends DaoTestBase {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testH2DS() {
        long count = namedParameterJdbcTemplate.query("select count(*) from cdb.user;", new ResultSetExtractor<Long>() {
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
    }
}
