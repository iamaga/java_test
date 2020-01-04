package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.FastDFSClient;
import com.bjsxt.common.pojo.IDUtils;
import com.bjsxt.common.pojo.PictureResult;
import com.bjsxt.service.PicService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PicServiceImpl implements PicService {
    @Value("${IMG_SERVER_ADD}")
    private String IMG_SERVER_ADD;

    @Value("${IMG_SERVER_PORT}")
    private String IMG_SERVER_PORT;

    @Override
    public PictureResult fileUploac(MultipartFile uploadFile) {
        String filename = uploadFile.getOriginalFilename();
        // 生成一个唯一id+（.jpg）
        String newFileNmae = IDUtils.genImageName().toString()+filename.substring(filename.lastIndexOf("."));
        PictureResult pr = null;
        try{
            String[] arr = FastDFSClient.uploadFile(uploadFile.getInputStream(), newFileNmae);
            String url = IMG_SERVER_ADD+":"+IMG_SERVER_PORT+"/"+arr[0]+"/"+arr[1];
            System.out.println(url);
            pr = new PictureResult(0,url);
        }catch (Exception e){
            e.printStackTrace();
            pr = new PictureResult(1,"上传失败！");
        }

        return pr;
    }
}
