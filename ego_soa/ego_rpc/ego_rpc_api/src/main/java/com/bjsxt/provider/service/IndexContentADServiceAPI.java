package com.bjsxt.provider.service;

import com.bjsxt.pojo.TbContent;

import java.util.List;

public interface IndexContentADServiceAPI {
    //查询首页大广告位内容 id在provider中指定
    List<TbContent> selectIndexContentAD();
}
