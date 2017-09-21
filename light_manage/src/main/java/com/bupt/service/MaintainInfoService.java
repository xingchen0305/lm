package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.MaintainInfo;
import com.bupt.repository.MaintainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CJ on 2017/9/21.
 */
@Service
public class MaintainInfoService extends BasePageService<MaintainInfo,String> {
    @Autowired
    MaintainInfoRepository maintainInfoRepository;

    public void save(MaintainInfo maintainInfo){
        maintainInfoRepository.save(maintainInfo);
    }

    public MaintainInfo findById(String id){
       return maintainInfoRepository.findOne(id);
    }
    public void delete(String id){
        maintainInfoRepository.delete(id);
    }

}
