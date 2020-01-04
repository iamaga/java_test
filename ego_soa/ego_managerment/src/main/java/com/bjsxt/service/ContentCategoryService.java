package com.bjsxt.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContentCategory;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeResult> getContentCategory(Long parentid);

    DataResult addContentCategory(TbContentCategory tbContentCategory);

    DataResult updateContentCategory(TbContentCategory tbContentCategory);

    DataResult deleteContentCategory(Long id);
}
