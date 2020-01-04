package com.bjsxt.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemDesc;

import javax.xml.crypto.Data;

public interface ItemService {
    //根据page，rows获取所有商品列表
    EasyUIDataGridResult getItemList(Integer page,Integer rows);
    //根据itemid数组下架所有商品（商品状态改为2）
    DataResult updataItemInstock(String[] ids);
    //根据itemid数组上架所有商品（商品状态改为1）
    DataResult updataItemreShelf(String[] ids);
    //根据itemid数组删除所有商品（删除非物理删除，将状态改为3）
    DataResult updataItemDelete(String[] strings);
    //添加商品  保存到两张表 item 和 desc
    DataResult insertTbitem(TbItem tbItem, String desc,String itemParams);
    //根据商品id返回商品描述
    DataResult getItemDesc(Long id );
    //更新item 和 itemdesc
    DataResult upDataItemAndItemDesc(TbItem tbItem,String desc);
    //根据page,rows获取规格参数列表
    EasyUIDataGridResult getItemParamList(Integer page,Integer rows);
}
