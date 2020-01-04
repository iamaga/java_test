package com.bjsxt.provider.service;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.pojo.TbItemParam;

public interface ItemParamServiceAPI {
    DataResult selectItemParamByid(Long cid);

    DataResult insertItemParan(TbItemParam itemParam);
}
