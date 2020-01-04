package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.ItemCatResult;
import com.bjsxt.common.pojo.JsonUtils;
import com.bjsxt.jedis.dao.JedisDao;
import com.bjsxt.mapper.TbItemCatMapper;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.pojo.TbItemCatExample;
import com.bjsxt.pojo.TbItemExample;
import com.bjsxt.provider.service.ItemCatServiceAPI;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemCatServiceImpl implements ItemCatServiceAPI {


        @Autowired
        private JedisDao jedisDao;
    //首页内容
    @Value("${PORTAL_CONTENT_KEY}")
    private String PORTAL_CONTENT_KEY;
    //首页itemcat
    @Value("${PORTAL_CONTENT_ITEM_KEY}")
    private String PORTAL_CONTENT_ITEM_KEY;
    //首页itemcat 开始id
    @Value("${PORTAL_CONTENT_ITEMCAY_PARENTID_KEY}")
    private Long PORTAL_CONTENT_ITEMCAY_PARENTID_KEY;
    /**
     * 根据父节点id查询子节点
     * @param id
     * @return
     */
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public DataResult getItemCat(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        if (list!=null&&list.size()>0){
            return DataResult.ok(list);
        }

        return DataResult.error();
    }

    /**
     * eoo_item调用  首页item分类
     * @return
     */
    @Override
    public Map<String, Object> getItemCatPortal() {
        Map<String,Object> map = new HashMap<>();

        try {
            String str = jedisDao.hget(PORTAL_CONTENT_KEY, PORTAL_CONTENT_ITEM_KEY);
            System.out.println(str);
            if (!StringUtils.isBlank(str)){
                List<ItemCatResult> list = JsonUtils.jsonToList(str, ItemCatResult.class);
                map.put("data",list);
                System.out.println("itemcat 从缓存读取内容！！！！！！！！！！！！！！！！");
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        List<ItemCatResult> list = getItemCatPotal(PORTAL_CONTENT_ITEMCAY_PARENTID_KEY);

        try {
            String json = JsonUtils.objectToJson(list);
            jedisDao.hset(PORTAL_CONTENT_KEY,PORTAL_CONTENT_ITEM_KEY,json);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("data",list);

        return map;
    }

    public List<ItemCatResult> getItemCatPotal(long parentId){
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
        List result = new ArrayList<>();
        int count = 0;
        for (TbItemCat cat:tbItemCats){

            if (cat.getIsParent()){
                ItemCatResult itemCatResult = new ItemCatResult();
                //根节点
                if (cat.getParentId()==0){
                    itemCatResult.setName("<a href='/products/"+cat.getId()+".html'>"+cat.getName()+"</a>");
                }else {
                    itemCatResult.setName(cat.getName());
                }
                count++;
                //u : "/products/1.html"
                itemCatResult.setUrl("/products/"+cat.getId()+".html");
                itemCatResult.setItem(getItemCatPotal(cat.getId()));
                result.add(itemCatResult);
                if (count==14){
                    break;
                }
            }else{
                //[0] : "/products/3.html|电子书"
                result.add("/products/"+cat.getId()+".html|"+cat.getName());
            }
        }

        return result;
    }
}
