package com.pinnuli.controller;

import com.pinnuli.commons.ConfigConsts;
import com.pinnuli.commons.Result;
import com.pinnuli.model.PayloadInfo;
import com.pinnuli.model.image.Image;
import com.pinnuli.model.image.SquareImage;
import com.pinnuli.model.image.UserImage;
import com.pinnuli.service.ImageService;
import com.pinnuli.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/square/create", method = RequestMethod.POST)
    public Result createSquareImage(MultipartFile image, HttpServletRequest request) {
        //图片保存路径
        String imageDirPath = request.getSession().getServletContext().getRealPath(ConfigConsts.SQUARE_IMAGE_DIRECTORY);
        //项目根目录
        String appRootDir = request.getServletContext().getContextPath();
        Image squareImage = new SquareImage();
        squareImage = imageService.createSquareOrUserImage(imageDirPath, appRootDir, image, squareImage);
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
        //获取用户信息，并设置图片的uid
        PayloadInfo payloadInfo = userService.getPayloadInfo(request);
        Image userImage = new UserImage(payloadInfo.getUserId());
        userImage = imageService.createSquareOrUserImage(imageDirPath, appRootDir, image, userImage);
        if(userImage == null) {
            return Result.createByErrorMessage("上传失败");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("image", userImage);
        return Result.createBySuccess(data);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public Result deleteUserImage(@RequestParam int userImageId) {
        int deleteResult = imageService.deleteUserImage(userImageId);
        if(deleteResult > 0) {
            return Result.createBySuccess();
        } else {
            return Result.createByError();
        }
    }

    @RequestMapping(value = "/square/delete", method = RequestMethod.DELETE)
    public Result deleteSquareImage(@RequestParam int squareImageId) {
        int deleteResult = imageService.deleteSquareImage(squareImageId);
        if(deleteResult > 0) {
            return Result.createBySuccess();
        } else {
            return Result.createByError();
        }
    }
}
