package com.bjsxt.web.controller;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemDesc;
import com.bjsxt.service.ItemCatService;
import com.bjsxt.service.ItemParamService;
import com.bjsxt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCatService itemCatService;

    @Autowired
    private ItemParamService itemParamService;
    @RequestMapping("/list")
    @ResponseBody
    private EasyUIDataGridResult itemList(@RequestParam (defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows){
        System.out.println("请求list");
        return itemService.getItemList(page,rows);
    }

    /**
     *
     * 从前台接收到的为多个下架id数组转成的字符串
     * listitem.jsp 下架商品
     * @return
     */
    @ResponseBody
    @RequestMapping("/instock")
    private DataResult instockItem(String ids){
        String[] strings = ids.split(",");
        return itemService.updataItemInstock(strings);
    }

    @ResponseBody
    @RequestMapping("/reshelf")
    private DataResult reshelfItem(String ids){
        String[] strings = ids.split(",");
        return itemService.updataItemreShelf(strings);
    }

    @ResponseBody
    @RequestMapping("/delete")
    private DataResult deleteItem(String ids){
        String[] strings = ids.split(",");
        return itemService.updataItemDelete(strings);
    }

    @ResponseBody
    @RequestMapping("/cat/list")
    private List<EasyUITreeResult> tree(@RequestParam(defaultValue = "1") Long id){
       return itemCatService.getCatList(id);
    }

    @ResponseBody
    @RequestMapping("/save")
    private DataResult itemSave(TbItem tbItem,String desc,String itemParams){
        return itemService.insertTbitem(tbItem,desc,itemParams);
    }

    @ResponseBody
    @RequestMapping("/desc/{id}")
    private DataResult itemDesc( @PathVariable Long id){
        System.out.println(id);
        return itemService.getItemDesc(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    private DataResult itemUpdate(TbItem tbItem,String desc){
        System.out.println(tbItem);
        System.out.println(desc);


        return itemService.upDataItemAndItemDesc(tbItem, desc);
    }


    @ResponseBody
    @RequestMapping("/param/list")
    private EasyUIDataGridResult itemParaList(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "30")Integer rows){
        return  itemService.getItemParamList(page,rows);
    }

    @ResponseBody
    @RequestMapping("/param/query/itemcatid/{cid}")
    private DataResult selecctItemcatidByCid(@PathVariable Long cid){
        return itemParamService.selectItemParamByid(cid) ;
    }

    @ResponseBody
    @RequestMapping("/param/save/{cid}")
    private DataResult insertItemParam(@PathVariable Long cid,String paramData){
        return itemParamService.insertItemParam(cid,paramData);
    }

}
