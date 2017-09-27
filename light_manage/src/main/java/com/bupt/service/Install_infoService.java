package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Install_info;
import com.bupt.repository.Install_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class Install_infoService extends BasePageService<Install_info,String> {
    @Autowired
    private Install_infoRepository install_infoRepository;

    public void save(Install_info entity){
        install_infoRepository.save(entity);
    }

    public Install_info findById(String id){
        return install_infoRepository.findOne(id);
    }

    public void deleteById(String id){ install_infoRepository.delete(id); }

    public void  pageByHql(PageEntity<Install_info> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Install_info where 1=1 ");
        if (paramaMap.containsKey("installNumber")){
            sql.append(" and installNumber =:installNumber ");
        }
        if (paramaMap.containsKey("decisionMakerName")){
            sql.append(" and decisionMakerName =:decisionMakerName ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
}
