package com.bjsxt.provider.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.pojo.TbContentCategory;

public interface ContentCategoryServiceAPI {
    DataResult getContentCategory(long pid);
    DataResult addContentCategory(TbContentCategory tbContentCategory);
    DataResult updateContentCategory(TbContentCategory tbContentCategory);

    DataResult deleteContentCategory(Long id);
}
