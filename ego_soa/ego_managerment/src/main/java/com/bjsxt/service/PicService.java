package com.bjsxt.service;

import com.bjsxt.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

public interface PicService {
    PictureResult fileUploac(MultipartFile uploadFile);
}
