package com.bjsxt.service;

import com.bjsxt.common.pojo.DataResult;

import javax.xml.crypto.Data;

public interface ItemParamService {
    DataResult selectItemParamByid(Long cid);
    DataResult  insertItemParam(Long itemCid,String paramData);
}
