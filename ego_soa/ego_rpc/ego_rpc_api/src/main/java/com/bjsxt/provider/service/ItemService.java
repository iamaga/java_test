package com.bjsxt.provider.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemDesc;
import com.bjsxt.pojo.TbItemParamItem;

import java.util.List;

public interface ItemService {
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
    List<Integer> updataItemInstock(String[] ids);

    List<Integer> updataItemShelf(String[] ids);

    List<Integer> updataItemDelete(String[] ids);
    DataResult insertTbitem(TbItem tbItem, TbItemDesc desc, TbItemParamItem itemParamItem);

    DataResult getItemDesc(Long id);

    DataResult updataTbitemAndTbitemdesc(TbItem tbItem,TbItemDesc desc);

    EasyUIDataGridResult selectItemParamList(Integer page, Integer rows);
}
