package com.bupt.controller;

import com.bupt.domain.CheckInfo;
import com.bupt.service.CheckInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bupt.common.utils.MessageUtil.sendFailMessage;
import static com.bupt.common.utils.MessageUtil.sendSuccessMessage;


/**
 * Created by CJ on 2017/9/21.
 */
@RestController
@RequestMapping("/checkInfo")
public class CheckInfoController {
    @Autowired
    CheckInfoService checkInfoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody CheckInfo entity) {
        checkInfoService.save(entity);
        return sendSuccessMessage();
    }
    //查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findByCode(@PathVariable(value = "id") String id) {
        CheckInfo checkInfo=checkInfoService.findById(id);
        return sendSuccessMessage(checkInfo);
    }
    //删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            checkInfoService.delete(ids);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }
}
