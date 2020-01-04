package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.common.pojo.IDUtils;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemDesc;
import com.bjsxt.pojo.TbItemParamItem;
import com.bjsxt.service.ItemService;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Reference
    private com.bjsxt.provider.service.ItemService itemService;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

        return  itemService.getItemList(page,rows);
    }

    @Override
    public DataResult updataItemInstock(String[] ids) {
        List<Integer> result = itemService.updataItemInstock(ids);
        if(result!=null&&result.size()>0){
            return DataResult.ok();
        }
        return DataResult.error();
    }

    @Override
    public DataResult updataItemreShelf(String[] ids) {
        List<Integer> result = itemService.updataItemShelf(ids);
        if(result!=null&&result.size()>0){
            return DataResult.ok();
        }
        return DataResult.error();
    }

    @Override
    public DataResult updataItemDelete(String[] ids) {
        List<Integer> result = itemService.updataItemDelete(ids);
        if(result!=null&&result.size()>0){
            return DataResult.ok();
        }
        return DataResult.error();
    }

    @Override
    public DataResult insertTbitem(TbItem tbItem, String desc,String itemParams) {
        long itemId = IDUtils.genItemId();
        Date current = new Date();
        tbItem.setId(itemId);
        tbItem.setUpdated(current);
        tbItem.setCreated(current);
        tbItem.setStatus((byte)1);

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(current);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(current);

        TbItemParamItem itemParamItem = new TbItemParamItem();

        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setUpdated(current);
        itemParamItem.setCreated(current);
        return itemService.insertTbitem(tbItem,itemDesc,itemParamItem);
    }

    @Override
    public DataResult getItemDesc(Long id) {

        return  itemService.getItemDesc(id);
    }

    @Override
    public DataResult upDataItemAndItemDesc(TbItem tbItem, String desc) {
        Long itemId = tbItem.getId();
        Date date = new Date();
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setUpdated(date);


        return itemService.updataTbitemAndTbitemdesc(tbItem,tbItemDesc);
    }

    @Override
    public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
        return itemService.selectItemParamList(page, rows);
    }
}
