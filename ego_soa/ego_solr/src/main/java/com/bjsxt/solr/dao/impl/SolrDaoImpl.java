package com.bjsxt.solr.dao.impl;

import com.bjsxt.solr.dao.SolrDao;
import com.bjsxt.solr.pojo.ItemSearch;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class SolrDaoImpl implements SolrDao {
    @Autowired
    private HttpSolrClient httpSolrClient;
    @Override
    public Map<String, Object> search(SolrQuery solrQuery) throws Exception {
        Map<String,Object> map = new HashMap<>();
        QueryResponse response =this.httpSolrClient.query(solrQuery);

        SolrDocumentList list = response.getResults();
        //获取总条数
        map.put("totalNum",list.getNumFound());

        //取高亮
        Map<String,Map<String, List<String>>> hi = response.getHighlighting();
        //存放搜索返回数据
        List<ItemSearch> result = new ArrayList<>();
        //获取结果集
        for(SolrDocument documents:list){
            ItemSearch itemSearch = new ItemSearch();
            itemSearch.setId(Long.parseLong(documents.get("id").toString()));
            itemSearch.setCategoryName(documents.get("item_category_name").toString());
            itemSearch.setImage(documents.get("item_image").toString());
            itemSearch.setPrice(Long.parseLong(documents.get("item_price").toString()));
            itemSearch.setSellPoint((String)documents.get("item_sell_point"));

            List<String> temp =  hi.get(itemSearch.getId()+"").get("item_title");
            String title= null;
            if(temp != null && temp.size() > 0){
                title = temp.get(0);
            }else{
                title=documents.get("item_title").toString();
            }
            itemSearch.setTitle(title);
            result.add(itemSearch);
        }
        //将结果集添加到Map中
        map.put("itemList",result);
        return map;
    }
}
