package com.pinnuli.service;

import com.pinnuli.model.image.Image;
import com.pinnuli.model.image.UserImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */
public interface ImageService {

    Image createSquareOrUserImage(String imageDirPath, String appRootDir, MultipartFile image, Image newImage);

    Integer setSquareImageMessageId(Integer imageId, Integer mid);
}
