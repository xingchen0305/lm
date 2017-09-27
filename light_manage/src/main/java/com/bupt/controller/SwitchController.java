package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Switch;
import com.bupt.service.SwitchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@RestController
@RequestMapping("/switch")
public class SwitchController extends BaseCommonController {
    @Autowired
    private SwitchService switchService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Switch entity) {
        switchService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Switch entity) {
        if (StringUtils.isNotBlank(entity.getId())){
            Switch s = switchService.findById(entity.getId());
            BeanUtills.copyProperties(entity,s);
            switchService.save(s);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        Switch s = switchService.findById(id);
        return sendMessage("true","",s, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(Switch entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<Switch> pageEntity = new PageEntity<>(start, size,page);
        switchService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Switch entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getSwitchNumber())){
            parameterMap.put("switchNumber", entity.getSwitchNumber());
        }
        if (StringUtils.isNotBlank(entity.getSwitchName())){
            parameterMap.put("switchName", entity.getSwitchName());
        }
        if (StringUtils.isNotBlank(entity.getLocation())){
            parameterMap.put("location", entity.getLocation());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        switchService.deleteById(id);
        return sendSuccessMessage();
    }
}
