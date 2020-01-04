package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.mapper.TbContentMapper;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.pojo.TbContentExample;
import com.bjsxt.provider.service.ContentServiceAPI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import sun.applet.Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentServiceAPI {


    @Autowired
    private TbContentMapper tbContentMapper;
    @Override
    public DataResult getContentList(Integer page, Integer rows, Long categoryId) {
        PageHelper.startPage(page,rows);
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<TbContent> tbContents = tbContentMapper.selectByExampleWithBLOBs(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("list",pageInfo.getList());
        return DataResult.ok(map);
    }

    @Override
    public DataResult addContent(TbContent content) {
        tbContentMapper.insert(content);
        return DataResult.ok();
    }

    @Override
    public DataResult deleteContent(List<Long> ids) {
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        tbContentMapper.deleteByExample(example);
        return DataResult.ok();
    }

    @Override
    public DataResult updateContent(TbContent tbContent) {
        tbContentMapper.updateByPrimaryKeyWithBLOBs(tbContent);
        return DataResult.ok();
    }
}
