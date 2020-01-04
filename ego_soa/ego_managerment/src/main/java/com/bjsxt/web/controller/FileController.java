package com.bjsxt.web.controller;

import com.bjsxt.common.pojo.DataResult;
import com.bjsxt.common.pojo.IDUtils;
import com.bjsxt.common.pojo.PictureResult;
import com.bjsxt.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传控制器. 专门处理图片相关操作
 */
@RestController
@RequestMapping("/pic")
public class FileController {

    @Autowired
    private PicService picService;
    /**
     * 上传图片到FTP服务器.
     * @return
     */
    @RequestMapping("/upload")
    private PictureResult fileUploac(MultipartFile uploadFile){

        return picService.fileUploac(uploadFile);
    }
}
