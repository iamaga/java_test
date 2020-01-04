package com.bjsxt.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContent;

import java.util.List;

public interface ContentService {
    EasyUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId);
    DataResult addContent(TbContent content);

    DataResult delContent(String ids);

    DataResult updateContent(TbContent tbContent);
}
