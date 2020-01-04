package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.provider.service.ItemCatServiceAPI;
import com.bjsxt.service.ItemCatService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Reference
    private ItemCatServiceAPI itemCatServiceAPI;
    @Override
    public List<EasyUITreeResult> getCatList(Long id) {

        List<EasyUITreeResult> tree = new ArrayList<EasyUITreeResult>();
        DataResult dataResult = itemCatServiceAPI.getItemCat(id);
        if (dataResult.getStatus()==200){
            //200表示获取数据成功
            List<TbItemCat> data = (List<TbItemCat>)dataResult.getData();
            for (TbItemCat tbItemCat:data){
            EasyUITreeResult result=new EasyUITreeResult();
            result.setId(tbItemCat.getId());
            result.setState(tbItemCat.getIsParent()?"closed":"open");
            result.setText(tbItemCat.getName());
            tree.add(result);
            }
        }

        return tree;
    }
}
