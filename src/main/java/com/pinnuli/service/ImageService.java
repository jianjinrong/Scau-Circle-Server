package com.pinnuli.service;

import com.pinnuli.model.image.SquareImage;
import com.pinnuli.model.image.UserImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */
public interface ImageService {

    SquareImage createSquareImage(String imageDirPath, String appRootDir, MultipartFile image);

    UserImage createUserImage(String imageDirPath, String appRootDir, MultipartFile image);
}
