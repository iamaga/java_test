package com.bjsxt.solr.service;

import java.util.Map;

public interface SolrService {
   Map<String,Object> search(Integer page,Integer rows,String q)throws Exception;
}
