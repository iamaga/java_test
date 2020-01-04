package com.bjsxt.provider.service.impl;

import com.bjsxt.common.pojo.JsonUtils;
import com.bjsxt.jedis.dao.JedisDao;
import com.bjsxt.mapper.TbContentMapper;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.pojo.TbContentExample;
import com.bjsxt.provider.service.IndexContentADServiceAPI;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class IndexContentADServiceImpl implements IndexContentADServiceAPI {
    @Autowired
    private TbContentMapper contentMapper;

    @Value("${PORTAL_CONTENT_KEY}")
    private String PORTAL_CONTENT_KEY;

    @Value("${PORTAL_CONTENT_AD_KEY}")
    private Long PORTAL_CONTENT_AD_KEY;

    @Autowired
    private JedisDao jedisDao;
    @Override
    public List<TbContent> selectIndexContentAD() {

        try {

            String str = jedisDao.hget(PORTAL_CONTENT_KEY, PORTAL_CONTENT_AD_KEY + "");
            if (!StringUtils.isBlank(str)){
                List<TbContent> list = JsonUtils.jsonToList(str,TbContent.class);
                System.out.println("查询从redis缓存获取！！！！！！！！！！！！！！！！！！");
                return list;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(PORTAL_CONTENT_AD_KEY);
        System.out.println(PORTAL_CONTENT_AD_KEY);
        List<TbContent> tbContents = contentMapper.selectByExample(example);
        try {
            String json = JsonUtils.objectToJson(tbContents);
            jedisDao.hset(PORTAL_CONTENT_KEY,PORTAL_CONTENT_AD_KEY+"",json);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tbContents;
    }
}
