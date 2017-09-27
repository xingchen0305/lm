package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Switch;
import com.bupt.repository.SwitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class SwitchService extends BasePageService<Switch,String> {
    @Autowired
    private SwitchRepository switchRepository;

    public void save(Switch entity){
        switchRepository.save(entity);
    }

    public Switch findById(String id){
        return switchRepository.findOne(id);
    }

    public void deleteById(String id){ switchRepository.delete(id); }

    public void  pageByHql(PageEntity<Switch> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Switch where 1=1 ");
        if (paramaMap.containsKey("switchNumber")){
            sql.append(" and switchNumber =:switchNumber ");
        }
        if (paramaMap.containsKey("switchName")){
            sql.append(" and switchName =:switchName ");
        }
        if (paramaMap.containsKey("location")){
            sql.append(" and location =:location ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }


}
