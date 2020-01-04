package com.bjsxt.web.controller;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.service.ContentService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @RequestMapping("/query/list")
    private EasyUIDataGridResult selectContentList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer rows, Long categoryId){
       return contentService.getContentList(page, rows, categoryId);
    }

    @ResponseBody
    @RequestMapping("/save")
    private DataResult addContent(TbContent tbContent){
        return contentService.addContent(tbContent);
    }
    @ResponseBody
    @RequestMapping("/delete")
    public DataResult delContent(String ids){
        return this.contentService.delContent(ids);
    }

    @ResponseBody
    @RequestMapping("/edit")
    public DataResult updateContent(TbContent tbContent){
        return contentService.updateContent(tbContent);
    }


}
