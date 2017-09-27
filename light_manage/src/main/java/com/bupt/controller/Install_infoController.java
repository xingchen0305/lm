package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Install_info;
import com.bupt.service.Install_infoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@RestController
@RequestMapping("/install_info")
public class Install_infoController extends BaseCommonController {
    @Autowired
    private Install_infoService install_infoService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Install_info entity) {
        install_infoService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Install_info entity) {
        if (StringUtils.isNotBlank(entity.getId())){
            Install_info install_info = install_infoService.findById(entity.getId());
            BeanUtills.copyProperties(entity,install_info);
            install_infoService.save(install_info);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        Install_info install_info = install_infoService.findById(id);
        return sendMessage("true","",install_info, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(Install_info entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<Install_info> pageEntity = new PageEntity<>(start, size,page);
        install_infoService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Install_info entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getInstallNumber())){
            parameterMap.put("installNumber", entity.getInstallNumber());
        }
        if (StringUtils.isNotBlank(entity.getDecisionMakerName())){
            parameterMap.put("decisionMakerName", entity.getDecisionMakerName());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        install_infoService.deleteById(id);
        return sendSuccessMessage();
    }
}
