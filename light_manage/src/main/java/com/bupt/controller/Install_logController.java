package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Install_log;
import com.bupt.domain.Switch;
import com.bupt.service.Install_logService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@RestController
@RequestMapping("/install_log")
public class Install_logController extends BaseCommonController {
    @Autowired
    private Install_logService install_logService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Install_log entity) {
        install_logService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Install_log entity) {
        if (StringUtils.isNotBlank(entity.getId())){
            Install_log install_log = install_logService.findById(entity.getId());
            BeanUtills.copyProperties(entity,install_log);
            install_logService.save(install_log);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        Install_log install_log = install_logService.findById(id);
        return sendMessage("true","",install_log, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(Install_log entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<Install_log> pageEntity = new PageEntity<>(start, size,page);
        install_logService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Install_log entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getInstallNumber())){
            parameterMap.put("installNumber", entity.getInstallNumber());
        }
        if (StringUtils.isNotBlank(entity.getInstallerName())){
            parameterMap.put("installerName", entity.getInstallerName());
        }
        if (StringUtils.isNotBlank(entity.getInputName())){
            parameterMap.put("inputName", entity.getInputName());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        install_logService.deleteById(id);
        return sendSuccessMessage();
    }
}
