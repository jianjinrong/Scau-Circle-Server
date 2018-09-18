package com.pinnuli.controller;

import com.pinnuli.commons.ConfigConsts;
import com.pinnuli.commons.Result;
import com.pinnuli.model.Image;
import com.pinnuli.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createImage(MultipartFile image, HttpServletRequest request) {
        //图片保存路径
        String imageDirPath = request.getSession().getServletContext().getRealPath(ConfigConsts.DEFAULT_IMAGE_DIRECTORY);
        //项目根目录
        String appRootDir = request.getServletContext().getContextPath();
        Image newImage = imageService.create(imageDirPath, appRootDir, image);
    }

}
