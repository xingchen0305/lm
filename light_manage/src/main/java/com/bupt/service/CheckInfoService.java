package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.CheckInfo;
import com.bupt.repository.CheckInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CJ on 2017/9/21.
 */
@Service
public class CheckInfoService extends BasePageService<CheckInfo,String> {
    @Autowired
    CheckInfoRepository checkInfoRepository;

    public void save(CheckInfo checkInfo){
        checkInfoRepository.save(checkInfo);
    }

    public CheckInfo findById(String id){
       return checkInfoRepository.findOne(id);
    }
    public void delete(String id){
        checkInfoRepository.delete(id);
    }

}
