package com.pinnuli.service;

import com.pinnuli.model.LostAndFind;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-21
 */
public interface LostAndFindService {

    Integer save(LostAndFind lostAndFind);
}
