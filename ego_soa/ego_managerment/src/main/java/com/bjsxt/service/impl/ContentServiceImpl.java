package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.EasyUIDataGridResult;
import com.bjsxt.common.pojo.EasyUITreeResult;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.provider.service.ContentServiceAPI;
import com.bjsxt.service.ContentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Reference
    private ContentServiceAPI contentServiceAPI;
    @Override
    public EasyUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId) {
        DataResult dataResult = contentServiceAPI.getContentList(page, rows, categoryId);
        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        if (dataResult.getStatus()==200){

            Map<String,Object> map = (Map<String, Object>) dataResult.getData();
            gridResult.setRows((List<TbContent>)map.get("list"));
            gridResult.setTotal((long)map.get("total"));
        }
        return  gridResult;
    }

    @Override
    public DataResult addContent(TbContent content) {
        Date date = new Date();
        content.setUpdated(date);
        content.setCreated(date);
        return contentServiceAPI.addContent(content);
    }

    @Override
    public DataResult delContent(String ids) {
        String[] strings = ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String str:strings){
            list.add(Long.parseLong(str));
        }
        return contentServiceAPI.deleteContent(list);
    }

    @Override
    public DataResult updateContent(TbContent tbContent) {
        tbContent.setUpdated(new Date());
        return contentServiceAPI.updateContent(tbContent);
    }
}
