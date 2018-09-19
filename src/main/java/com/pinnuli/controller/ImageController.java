package com.pinnuli.controller;

import com.pinnuli.commons.ConfigConsts;
import com.pinnuli.commons.Result;
import com.pinnuli.model.image.SquareImage;
import com.pinnuli.model.image.UserImage;
import com.pinnuli.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/square/create", method = RequestMethod.POST)
    public Result createSquareImage(MultipartFile image, HttpServletRequest request) {
        //图片保存路径
        String imageDirPath = request.getSession().getServletContext().getRealPath(ConfigConsts.USER_IMAGE_DIRECTORY);
        //项目根目录
        String appRootDir = request.getServletContext().getContextPath();
        SquareImage squareImage = imageService.createSquareImage(imageDirPath, appRootDir, image);
        if(squareImage == null) {
            return Result.createByErrorMessage("上传失败");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("image", squareImage);
        return Result.createBySuccess(data);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Result createUserImage(MultipartFile image, HttpServletRequest request) {
        //图片保存路径
        String imageDirPath = request.getSession().getServletContext().getRealPath(ConfigConsts.USER_IMAGE_DIRECTORY);
        //项目根目录
        String appRootDir = request.getServletContext().getContextPath();
        UserImage userImage = imageService.createUserImage(imageDirPath, appRootDir, image);
        if(userImage == null) {
            return Result.createByErrorMessage("上传失败");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("image", userImage);
        return Result.createBySuccess(data);
    }



}
