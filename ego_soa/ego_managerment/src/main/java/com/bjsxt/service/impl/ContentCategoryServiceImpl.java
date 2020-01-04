package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.provider.service.ContentCategoryServiceAPI;
import com.bjsxt.service.ContentCategoryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

   @Reference
   private ContentCategoryServiceAPI contentCategoryServiceAPI;

    @Override
    public List<EasyUITreeResult> getContentCategory(Long parentid) {
        DataResult result = contentCategoryServiceAPI.getContentCategory(parentid);
        List<EasyUITreeResult>  treeResultList = new ArrayList<>();
        if (result.getStatus()==200){
            List<TbContentCategory> categoryList = (List<TbContentCategory>)result.getData();
        for (TbContentCategory category:categoryList){
            EasyUITreeResult treeResult = new EasyUITreeResult();
            treeResult.setText(category.getName());
            treeResult.setId(category.getId());
            treeResult.setState(category.getIsParent()?"closed":"open");
            treeResultList.add(treeResult);
        }
        }
        return treeResultList;
    }

    @Override
    public DataResult addContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setIsParent(false);
        tbContentCategory.setStatus(1);
        tbContentCategory.setSortOrder(1);
        Date date = new Date();
        tbContentCategory.setCreated(date);
        tbContentCategory.setUpdated(date);
        return contentCategoryServiceAPI.addContentCategory(tbContentCategory);
    }

    @Override
    public DataResult updateContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setUpdated(new Date());
        return contentCategoryServiceAPI.updateContentCategory(tbContentCategory);
    }

    @Override
    public DataResult deleteContentCategory(Long id) {
        return contentCategoryServiceAPI.deleteContentCategory( id);
    }
}
