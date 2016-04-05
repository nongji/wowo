package cn.edu.hit.nongji.util;

import org.apache.solr.common.SolrInputDocument;

import java.util.Collections;

/**
 * @author fangwentong
 * @title SolrInputDocumentBuilder
 * @desc 构建SolrInputDocument的工具类, 用于局部更新Solr文档的值
 * @date 2016-03-31 16:33
 */

public class SolrInputDocumentBuilder {
    private SolrInputDocument doc;
    private String uniqueKeyName;

    private SolrInputDocumentBuilder() {
        this(null, null);
    }

    private SolrInputDocumentBuilder(String uniqueKeyName, Object uniqueKeyValue) {
        doc = new SolrInputDocument();
        if (uniqueKeyName != null) {
            if (uniqueKeyValue == null) {
                throw new NullPointerException("Unique key value can not be null.");
            } else {
                this.uniqueKeyName = uniqueKeyName;
                doc.setField(uniqueKeyName, uniqueKeyValue);
            }
        }
    }

    public static SolrInputDocumentBuilder newBuilder() {
        return new SolrInputDocumentBuilder();
    }

    /**
     * Solr does not support update by query condition, you must specify value for unique key.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param uniqueKeyName  UniqueKey's Name
     * @param uniqueKeyValue UniqueKey's Value
     * @return
     */
    public static SolrInputDocumentBuilder newBuilder(String uniqueKeyName, Object uniqueKeyValue) {
        return new SolrInputDocumentBuilder(uniqueKeyName, uniqueKeyValue);
    }

    public SolrInputDocument build() {
        if (this.uniqueKeyName == null || !this.doc.containsKey(this.uniqueKeyName)) {
            throw new NullPointerException("Unique key or unique value can not be null , please use \"setUnique\" method.");
        } else {
            return this.doc;
        }
    }

    /**
     * Solr does not support update by query condition, you must specify value for unique key.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field UniqueKey Name
     * @param value UniqueKey Value
     * @return
     */
    public SolrInputDocumentBuilder setUnique(String field, Object value) {
        if (field == null || value == null) {
            throw new NullPointerException("field or value can not be null");
        }
        this.uniqueKeyName = field;
        this.doc.addField(field, value);
        return this;
    }

    /**
     * Set or replace the field value(s) with the specified value(s), or remove the values if 'null' or empty list is specified as the new value.
     * May be specified as a single value, or as a list for multivalued fields
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field
     * @param value
     * @return
     */
    public SolrInputDocumentBuilder set(String field, Object value) {
        this.doc.addField(field, Collections.singletonMap("set", value));
        return this;
    }

    /**
     * Adds the specified values to a **multivalued field.**
     * May be specified as a single value, or as a list.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field
     * @param value
     * @return
     */
    public SolrInputDocumentBuilder add(String field, Object value) {
        this.doc.addField(field, Collections.singletonMap("add", value));
        return this;
    }

    /**
     * Removes (all occurrences of) the specified values from a multivalued field.
     * May be specified as a single value, or as a list.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field
     * @param value
     * @return
     */
    public SolrInputDocumentBuilder remove(String field, Object value) {
        this.doc.addField(field, Collections.singletonMap("remove", value));
        return this;
    }

    /**
     * Removes all occurrences of the specified regex from a multiValued field.
     * May be specified as a single value, or as a list.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field
     * @param value
     * @return
     */
    public SolrInputDocumentBuilder removeRegex(String field, Object value) {
        this.doc.addField(field, Collections.singletonMap("removeregex", value));
        return this;
    }

    /**
     * Increments a numeric value by a specific amount.
     * Must be specified as a single numeric value.
     * Reference [Updating Parts of Documents](https://cwiki.apache.org/confluence/display/solr/Updating+Parts+of+Documents)
     *
     * @param field
     * @param value
     * @return
     */
    public SolrInputDocumentBuilder inc(String field, Number value) {
        this.doc.addField(field, Collections.singletonMap("inc", value));
        return this;
    }
}
