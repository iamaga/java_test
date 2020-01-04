package com.bjsxt.service;

import com.bjsxt.common.pojo.EasyUITreeResult;

import java.util.List;

public interface ItemCatService {
    List<EasyUITreeResult> getCatList(Long id);
}
