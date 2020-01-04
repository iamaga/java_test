package com.bjsxt.solr.service.impl;

import com.bjsxt.solr.dao.SolrDao;
import com.bjsxt.solr.service.SolrService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SolrServiceImpl implements SolrService {
    @Autowired
    private SolrDao solrDao;

    @Override
    public Map<String, Object> search(Integer page, Integer rows, String q) throws Exception {

            //创建搜索参数
            SolrQuery param = new SolrQuery();
            //搜索条件
            param.setQuery(q);
            //设置默认搜索域
            param.set("df","item_keywords");
            //设置分页
            param.setStart((page-1)*rows);
            param.setRows(rows);
            //设置高亮
            param.setHighlight(true);
            param.addHighlightField("item_title");
            param.setHighlightSimplePre("<span style='color:red'>");
            param.setHighlightSimplePost("</span>");

            //dao查询 //该map只含有 插叙到的结果集list以及总条数
            Map<String,Object> map = this.solrDao.search(param);
            //补齐页面的查询条件
            map.put("query",q);
            //补齐当前页
            map.put("page",page);
            //总页数
            long totalNum = (long)map.get("totalNum");
            map.put("totalPages",totalNum % rows == 0 ? totalNum / rows:totalNum /rows +1);
            return map;

    }
}
