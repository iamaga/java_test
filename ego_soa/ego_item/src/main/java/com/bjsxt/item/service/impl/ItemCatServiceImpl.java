package com.bjsxt.item.service.impl;


import com.bjsxt.item.service.ItemCatService;
import com.bjsxt.provider.service.ItemCatServiceAPI;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Reference
    private ItemCatServiceAPI itemCatServiceAPI;

    @Override
    public Map<String, Object> getItemCat() {
        return itemCatServiceAPI.getItemCatPortal();
    }
}
