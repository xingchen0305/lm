package com.bupt.controller;

import com.bupt.domain.MaintainInfo;
import com.bupt.service.MaintainInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bupt.common.utils.MessageUtil.sendFailMessage;
import static com.bupt.common.utils.MessageUtil.sendSuccessMessage;


/**
 * Created by CJ on 2017/9/21.
 */
@RestController
@RequestMapping("/maintainInfo")
public class MaintainInfoController {
    @Autowired
    MaintainInfoService maintainInfoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody MaintainInfo entity) {
        maintainInfoService.save(entity);
        return sendSuccessMessage();
    }
    //查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findByCode(@PathVariable(value = "id") String id) {
        MaintainInfo maintainInfo=maintainInfoService.findById(id);
        return sendSuccessMessage(maintainInfo);
    }
    //删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            maintainInfoService.delete(ids);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }
}
