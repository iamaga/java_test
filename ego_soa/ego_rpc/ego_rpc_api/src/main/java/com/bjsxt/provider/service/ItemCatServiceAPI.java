package com.bjsxt.provider.service;

import com.bjsxt.common.pojo.DataResult;

import java.util.Map;

public interface ItemCatServiceAPI {
    DataResult getItemCat(Long id);
    Map<String,Object> getItemCatPortal();
}
