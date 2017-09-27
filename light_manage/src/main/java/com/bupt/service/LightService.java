package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Light;
import com.bupt.repository.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class LightService extends BasePageService<Light,String> {
    @Autowired
    private LightRepository lightRepository;

    public void save(Light entity){
        lightRepository.save(entity);
    }

    public Light findById(String id){
        return lightRepository.findOne(id);
    }

    public void deleteById(String id){ lightRepository.delete(id); }

    public void  pageByHql(PageEntity<Light> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Light where 1=1 ");
        if (paramaMap.containsKey("lightNumber")){
            sql.append(" and lightNumber =:lightNumber ");
        }
        if (paramaMap.containsKey("lightName")){
            sql.append(" and lightName =:lightName ");
        }
        if (paramaMap.containsKey("location")){
            sql.append(" and location =:location ");
        }
        if (paramaMap.containsKey("switchNumber")){
            sql.append(" and switchNumber =:switchNumber ");
        }
        if (paramaMap.containsKey("state")){
            sql.append(" and state =:state ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
}
