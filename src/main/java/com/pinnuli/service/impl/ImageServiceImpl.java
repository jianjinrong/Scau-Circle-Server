package com.pinnuli.service.impl;

import com.pinnuli.controller.ImageController;
import com.pinnuli.model.Image;
import com.pinnuli.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import static com.pinnuli.utils.DateTimeUtil.getDate;
import static com.pinnuli.utils.DateTimeUtil.getTime;
import static com.pinnuli.utils.DateTimeUtil.newDate;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */

@Service
public class ImageServiceImpl implements ImageService {

    private static Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public Image create(String imageDirPath, String appRootDir, MultipartFile image) {
        Image newImage = new Image();
        //获取图片拓展名
        String fileName = image.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        Date date = newDate();
        //设置新的文件名
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        //根据日期生成子目录
        String childDir = File.separatorChar + getDate(date) + File.separatorChar;
        //设置图片保存的真实路径
        String realPath = imageDirPath + childDir;
        //设置web获取图片路径
        String webPath = appRootDir + childDir +  uploadFileName;
        //文件目录是否存在
        File fileDir = new File(realPath);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(realPath,uploadFileName);
        try {
            image.transferTo(targetFile);
            newImage.setRealPath(realPath);
            newImage.setWebPath(webPath);
            //文件已经上传成功了
            return newImage;
        } catch (IOException e) {
            log.error("上传文件异常",e);
        }
        return null;
    }
}
