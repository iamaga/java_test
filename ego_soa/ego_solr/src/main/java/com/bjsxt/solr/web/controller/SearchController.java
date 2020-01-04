package com.bjsxt.solr.web.controller;

import com.bjsxt.solr.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 搜索服务Controller
 */
@Controller
public class SearchController {

    @Autowired
    private SolrService solrService;
    /**
     * 处理搜索请求
     * @return
     */
    @RequestMapping("/search")
    private String search(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "30")Integer rows, String q, Model model){
        //q为前台通过get传过来的参数会产生中文乱码，过滤器只能解决post乱码
        try {
            String query = new String(q.getBytes("iso-8859-1"),"utf-8");
            Map<String,Object> map = solrService.search(page, rows, query);
            model.addAllAttributes(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "search";
    }
}
