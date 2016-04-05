package cn.edu.hit.nongji.util;

import org.apache.solr.common.SolrInputDocument;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author fangwentong
 * @title SolrInputDocumentBuilderTest
 * @date 2016-03-31 17:40
 */

public class SolrInputDocumentBuilderTest {
    @Test
    public void testGetBuilder() {
        Assert.assertTrue(SolrInputDocumentBuilder.newBuilder() instanceof SolrInputDocumentBuilder);
        Assert.assertTrue(SolrInputDocumentBuilder.newBuilder("id", 12321L).build() instanceof SolrInputDocument);
        try {
            SolrInputDocumentBuilder.newBuilder(null, "Hello").build();
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
        try {
            SolrInputDocumentBuilder.newBuilder("id", null);
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
        try {
            SolrInputDocumentBuilder.newBuilder().build();
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
        try {
            SolrInputDocumentBuilder.newBuilder().setUnique("id", null);
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }

    @Test
    public void testBuild() {
        Assert.assertTrue(SolrInputDocumentBuilder.newBuilder()
                .setUnique("id", 1234L)
                .set("number", 12345678L)
                .set("last_login_time", new Date())
                .add("phone", "18511001234")
                .remove("phone", "18506190101")
                .removeRegex("record_ids", "D*")
                .inc("count", 1)
                .build() instanceof SolrInputDocument);

        Assert.assertTrue(SolrInputDocumentBuilder.newBuilder("id", 1055L)
                .set("number", 661010L)
                .set("last_login_time", new Date())
                .build() instanceof SolrInputDocument);
    }
}
