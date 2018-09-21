package com.pinnuli.service.impl;

import com.pinnuli.commons.ConfigConsts;
import com.pinnuli.dao.ImageDao;
import com.pinnuli.model.image.Image;
import com.pinnuli.model.image.SquareImage;
import com.pinnuli.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import static com.pinnuli.utils.DateTimeUtil.getDate;
import static com.pinnuli.utils.DateTimeUtil.newDate;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */

@Service
public class ImageServiceImpl implements ImageService {

    private static Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageDao imageDao;

    @Override
    public Image createSquareOrUserImage(String imageDirPath, String appRootDir, MultipartFile image, Image newImage) {
        //设置新文件名
        String uploadFileName = generateUploadFileName(image);
        //设置子目录
        String childDir = generateChildDir(uploadFileName);
        //设置web获取图片路径
        String webPath = generateWebPath(newImage, appRootDir, childDir, uploadFileName);
        //设置图片保存的真实路径
        String realPath = generateRealPath(imageDirPath, childDir);

        File targetFile = new File(realPath,uploadFileName);
        try {
            image.transferTo(targetFile);
        } catch (IOException e) {
            log.error("上传文件异常",e);
            return null;
        }

        //文件已经上传成功了，保存到数据库，并返回新插入的记录id到newImage
        newImage.setRealPath(realPath);
        newImage.setWebPath(webPath);
        int saveResult;
        if (newImage instanceof SquareImage) {
            saveResult= imageDao.saveSquareImage(newImage);
        } else {
            saveResult= imageDao.saveUserImage(newImage);
        }
        if(saveResult == 0) {
            return null;
        }
        //真实路径设为null
        newImage.setRealPath(null);
        return newImage;
    }

    @Override
    public Integer setSquareImageMessageId(Integer imageId, Integer mid) {
        return imageDao.setSquareImageMessageId(imageId, mid);
    }


    /**
     * @param imageDirPath 图片保存主目录
     * @return 返回图片保存的真实路径
     */
    private String generateRealPath(String imageDirPath, String childDir) {
        String realPath = imageDirPath + childDir;
        //判断文件目录是否存在，不存在则创建
        File fileDir = new File(realPath);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        return realPath;
    }

    /**
     * @param newImage 要插入的图片
     * @param appRootDir 项目根目录
     * @param childDir 子目录
     * @param uploadFileName 文件名
     * @return 返回web获取图片路径
     */
    private String generateWebPath(Image newImage, String appRootDir, String childDir, String uploadFileName) {
        String webPath;
        if(newImage instanceof SquareImage) {
            webPath = appRootDir + ConfigConsts.SQUARE_IMAGE_DIRECTORY + childDir +  uploadFileName;
        } else {
            webPath = appRootDir + ConfigConsts.USER_IMAGE_DIRECTORY + childDir +  uploadFileName;
        }
        return webPath;
    }

    /**
     * @param uploadFileName 文件名
     * @return 返回根据日期生成子目录
     */
    private String generateChildDir(String uploadFileName) {
        Date date = newDate();
        String childDir = File.separatorChar + getDate(date) + File.separatorChar + uploadFileName;
        return childDir;
    }

    /**
     * @param image 上传的图片数据
     * @return 返回生成文件名
     */
    private String generateUploadFileName(MultipartFile image) {
        //获取图片拓展名
        String fileName = image.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //设置新的文件名
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        return uploadFileName;
    }

}
