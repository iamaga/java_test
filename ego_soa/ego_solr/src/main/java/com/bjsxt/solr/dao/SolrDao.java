package com.bjsxt.solr.dao;

import org.apache.solr.client.solrj.SolrQuery;

import java.util.Map;

public interface SolrDao {
    Map<String,Object> search(SolrQuery solrQuery)throws Exception;
}
