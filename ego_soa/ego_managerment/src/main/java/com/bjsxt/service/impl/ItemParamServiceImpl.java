package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.provider.service.ItemParamServiceAPI;
import com.bjsxt.service.ItemParamService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Reference
    private ItemParamServiceAPI itemParamServiceAPI;

    @Override
    public DataResult selectItemParamByid(Long cid) {
        return itemParamServiceAPI.selectItemParamByid(cid);
    }

    @Override
    public DataResult insertItemParam(Long itemCid, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        Date current = new Date();
        itemParam.setItemCatId(itemCid);
        itemParam.setCreated(current);
        itemParam.setUpdated(current);
        itemParam.setParamData(paramData);
        return itemParamServiceAPI.insertItemParan(itemParam);
    }
}
