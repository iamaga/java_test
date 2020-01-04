package com.bjsxt.provider.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.pojo.TbContent;

import java.util.List;

public interface ContentServiceAPI {
    DataResult getContentList(Integer page,Integer rows,Long categoryId);

    DataResult addContent(TbContent content);

    DataResult deleteContent(List<Long> ids);
    DataResult updateContent(TbContent tbContent);
}
