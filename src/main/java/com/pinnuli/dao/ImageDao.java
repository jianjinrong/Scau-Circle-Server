package com.pinnuli.dao;

import com.pinnuli.model.image.SquareImage;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */
public interface ImageDao {

    Integer saveSquareImage(SquareImage squareImage);

    Integer saveUserImage(SquareImage squareImage);

}
