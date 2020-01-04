package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.mapper.TbItemParamMapper;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.pojo.TbItemParamExample;
import com.bjsxt.provider.service.ItemParamServiceAPI;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamServiceAPI {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public DataResult selectItemParamByid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams.size()!=1){
            return DataResult.error();
        }

        return DataResult.ok(tbItemParams.get(0));
    }

    @Override
    public DataResult insertItemParan(TbItemParam itemParam) {
        int insert = tbItemParamMapper.insert(itemParam);
        if (insert>0){
            return  DataResult.ok();
        }
        return DataResult.error();
    }
}
