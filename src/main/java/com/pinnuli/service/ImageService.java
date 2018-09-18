package com.pinnuli.service;

import com.pinnuli.model.Image;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */
public interface ImageService {

    Image create(String imageDirPath, String appRootDir, MultipartFile image);
}
