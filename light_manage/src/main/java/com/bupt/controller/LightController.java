package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Light;
import com.bupt.service.LightService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@RestController
@RequestMapping("/light")
public class LightController extends BaseCommonController {
    @Autowired
    private LightService lightService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Light entity) {
        lightService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Light entity) {
        if (StringUtils.isNotBlank(entity.getId())){
            Light light = lightService.findById(entity.getId());
            BeanUtills.copyProperties(entity,light);
            lightService.save(light);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        Light light = lightService.findById(id);
        return sendMessage("true","",light,DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(Light entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<Light> pageEntity = new PageEntity<>(start, size,page);
        lightService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Light entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getLightNumber())){
            parameterMap.put("lightNumber", entity.getLightNumber());
        }
        if (StringUtils.isNotBlank(entity.getLightName())){
            parameterMap.put("lightName", entity.getLightName());
        }
        if (StringUtils.isNotBlank(entity.getLocation())){
            parameterMap.put("location", entity.getLocation());
        }
        if (StringUtils.isNotBlank(entity.getSwitchNumber())){
            parameterMap.put("switchNumber", entity.getSwitchNumber());
        }
        if (StringUtils.isNotBlank(entity.getState())){
            parameterMap.put("state", entity.getState());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        lightService.deleteById(id);
        return sendSuccessMessage();
    }
}
