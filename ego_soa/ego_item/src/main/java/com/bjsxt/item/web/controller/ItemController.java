package com.bjsxt.item.web.controller;

import com.bjsxt.item.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/cat")
    @ResponseBody
    @CrossOrigin
    private Object getItemCat(){
        return itemCatService.getItemCat();
    }
}
