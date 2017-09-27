package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Install_log;
import com.bupt.repository.Install_logRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class Install_logService extends BasePageService<Install_log,String> {
    @Autowired
    private Install_logRepository install_logRepository;

    public void save(Install_log entity){
        install_logRepository.save(entity);
    }

    public Install_log findById(String id){
        return install_logRepository.findOne(id);
    }

    public void deleteById(String id){ install_logRepository.delete(id); }

    public void  pageByHql(PageEntity<Install_log> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Install_log where 1=1 ");
        if (paramaMap.containsKey("installNumber")){
            sql.append(" and installNumber =:installNumber ");
        }
        if (paramaMap.containsKey("installerName")){
            sql.append(" and installerName =:installerName ");
        }
        if (paramaMap.containsKey("inputName")){
            sql.append(" and inputName =:inputName ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
}
