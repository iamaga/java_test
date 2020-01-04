package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.mapper.TbContentCategoryMapper;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.pojo.TbContentCategoryExample;
import com.bjsxt.provider.service.ContentCategoryServiceAPI;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class ContentCategorySercviceImpl implements ContentCategoryServiceAPI {
   @Autowired
   private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public DataResult getContentCategory(long pid) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(example);
        return DataResult.ok(tbContentCategories);
    }

    @Override
    public DataResult addContentCategory(TbContentCategory tbContentCategory) {
        int insert = contentCategoryMapper.insert(tbContentCategory);
        Long id = tbContentCategory.getId();
        System.out.println(id);
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
        if (!parent.getIsParent()){
            parent.setIsParent(true);
            parent.setUpdated(new Date());
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        return DataResult.ok(id);
    }

    @Override
    public DataResult updateContentCategory(TbContentCategory tbContentCategory) {
        contentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        return DataResult.ok();
    }

    @Override
    public DataResult deleteContentCategory(Long id) {

        //先根据id去查要删的节点
        TbContentCategory category1 = contentCategoryMapper.selectByPrimaryKey(id);
        Long parentId = category1.getParentId();
        if (category1.getIsParent()) {
            //删除的是子节点
            contentCategoryMapper.deleteByPrimaryKey(id);

        }else {
            //删除的是父节点
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            contentCategoryMapper.deleteByExample(example);
        }
        //判断兄弟节点
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> categoryList = contentCategoryMapper.selectByExample(example);
        if (categoryList.size() == 0) {
            //删除了只有一个节点的父节点，改变父节点的isparent()
            TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(parentId);
            category.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKey(category);
        }
        return DataResult.ok();
    }
}
