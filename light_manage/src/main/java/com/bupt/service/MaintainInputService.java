package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.MaintainInput;
import com.bupt.repository.MaintainInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CJ on 2017/9/21.
 */
@Service
public class MaintainInputService extends BasePageService<MaintainInput,String> {
    @Autowired
    MaintainInputRepository maintainInputRepository;

    public void save(MaintainInput maintainInput){
        maintainInputRepository.save(maintainInput);
    }

    public MaintainInput findById(String id){
       return maintainInputRepository.findOne(id);
    }
    public void delete(String id){
        maintainInputRepository.delete(id);
    }

}
