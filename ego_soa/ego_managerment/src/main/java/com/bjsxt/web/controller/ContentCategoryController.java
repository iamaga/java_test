package com.bjsxt.web.controller;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.service.ContentCategoryService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    private List<EasyUITreeResult> getTree(@RequestParam(defaultValue = "0") Long id){
        return contentCategoryService.getContentCategory(id);
    }
    @RequestMapping("/create")
    private DataResult createContentCategory(TbContentCategory tbContentCategory){
        return contentCategoryService.addContentCategory(tbContentCategory);
    }
    @RequestMapping("/update")
    private DataResult updateContentCategory(TbContentCategory tbContentCategory){
        return  contentCategoryService.updateContentCategory(tbContentCategory);
    }
    @RequestMapping("/delete")
    private void deleteContentCategory(Long id){
        System.out.println(id);
        contentCategoryService.deleteContentCategory( id);
    }
}
