package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.mapper.TbItemDescMapper;
import com.bjsxt.mapper.TbItemMapper;
import com.bjsxt.mapper.TbItemParamItemMapper;
import com.bjsxt.mapper.TbItemParamMapper;
import com.bjsxt.pojo.*;
import com.bjsxt.provider.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;


    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

        //设置分页查询数量
        PageHelper.startPage(page,rows);
        //创建查询条件
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //将查询结果给
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(list.size());
        //使用自定义的实体接收
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(list);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        return easyUIDataGridResult;
    }

    @Override
    public List<Integer> updataItemShelf(String[] ids) {
        List<Integer> temp = new ArrayList<>();
        for (String str:ids){
            TbItem tbItem = new TbItem();
            tbItem.setId(Long.parseLong(str));
            tbItem.setStatus(Byte.parseByte("1"));
            int i = itemMapper.updateByPrimaryKeySelective(tbItem);
            temp.add(i);
        }
        return temp;
    }

    @Override
    public List<Integer> updataItemInstock(String[] ids) {
        List<Integer> temp = new ArrayList<>();
        for (String str:ids){
            TbItem tbItem = new TbItem();
            tbItem.setId(Long.parseLong(str));
            tbItem.setStatus(Byte.parseByte("2"));
            int i = itemMapper.updateByPrimaryKeySelective(tbItem);
            temp.add(i);
        }
        return temp;
    }

    @Override
    public List<Integer> updataItemDelete(String[] ids) {
        List<Integer> temp = new ArrayList<>();
        for (String str:ids){
            TbItem tbItem = new TbItem();
            tbItem.setId(Long.parseLong(str));
            tbItem.setStatus(Byte.parseByte("3"));
            int i = itemMapper.updateByPrimaryKeySelective(tbItem);
            temp.add(i);
        }
        return temp;
    }

    @Override
    public DataResult insertTbitem(TbItem tbItem, TbItemDesc desc, TbItemParamItem itemParamItem) {
        itemMapper.insert(tbItem);
        itemDescMapper.insert(desc);
        itemParamItemMapper.insert(itemParamItem);
        return DataResult.ok();
    }

    @Override
    public DataResult getItemDesc(Long id) {
        TbItemDesc tbItemDesc = itemDescMapper.selectByPrimaryKey(id);
        System.out.println(tbItemDesc);
        return DataResult.ok(tbItemDesc);
    }

    @Override
    public DataResult updataTbitemAndTbitemdesc(TbItem tbItem, TbItemDesc desc) {
        int i = itemMapper.updateByPrimaryKeySelective(tbItem);
        int i1 = itemDescMapper.updateByPrimaryKeySelective(desc);
        if (i>0&&i1>0){
            return DataResult.ok();
        }
        return DataResult.error();
    }

    @Override
    public EasyUIDataGridResult selectItemParamList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<TbItemParamList> list = itemParamMapper.selectItemParamList();
        //将查询结果给
        PageInfo pageInfo = new PageInfo(list);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(list);
        return easyUIDataGridResult;
    }
}
