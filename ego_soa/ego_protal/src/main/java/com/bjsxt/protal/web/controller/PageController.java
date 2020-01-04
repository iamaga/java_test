package com.bjsxt.protal.web.controller;

import com.bjsxt.protal.service.IndexContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private IndexContentService indexContentService;
    @RequestMapping({"/index","/","/default"})
    public String   showIndex(Model model){
        model.addAttribute("ad1",indexContentService.getContentAD());
        return "index";
    }
}
