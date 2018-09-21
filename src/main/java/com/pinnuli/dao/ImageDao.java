package com.pinnuli.dao;

import com.pinnuli.model.image.Image;
import com.pinnuli.model.image.SquareImage;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */
public interface ImageDao {

    Integer saveSquareImage(Image squareImage);

    Integer saveUserImage(Image userImage);

    Integer setSquareImageMessageId(Integer imageId, Integer messageId);

}
