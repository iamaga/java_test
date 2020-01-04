package com.bjsxt.protal.service.impl;

import com.bjsxt.common.pojo.JsonUtils;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.protal.service.IndexContentService;
import com.bjsxt.provider.service.IndexContentADServiceAPI;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexContentServiceImpl implements IndexContentService {

    @Reference
    private IndexContentADServiceAPI indexContentADServiceAPI;
    @Override
    public String getContentAD() {
        /**
         * 前台需要的格式为
         * [
         *     {
         *     "alt":"鼠标悬停显示的文本",
         *     "href":"点击触发的连接路径",
         *
         *     "height": 主图片高度,
         *     "width": 主图片宽度,
         *     "src":"主图片路径地址",
         *
         *     "srcB":"副图片路径地址",
         *     "widthB":副图片宽度,
         *     "heightB":副图片高度},
         *     {
         *     "srcB":"http://image.ego.com/images/2015/03/03/2015030304353109508500.jpg",
         *     "height":240,"alt":"","width":670,
         *     "src":"https://img1.360buyimg.com/da/jfs/t7543/278/2124152966/202576/e3b5a884/59a8b5d2Ncd5670db.jpg",
         */

        List<TbContent> tbContents = indexContentADServiceAPI.selectIndexContentAD();
        List<Map<String,Object>> temp = new ArrayList<>();
        for (TbContent content:tbContents){
            Map<String,Object> map = new HashMap<>();
            map.put("alt",content.getTitleDesc());
            map.put("href",content.getUrl());
            map.put("height",240);
            map.put("width",670);
            map.put("src",content.getPic());
            map.put("srcB",content.getPic2());
            map.put("widthB",550);
            map.put("heightB",240);
            temp.add(map);
        }
        return JsonUtils.objectToJson(temp);
    }
}
