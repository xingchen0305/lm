package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Purchase;
import com.bupt.service.PurchaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/purchase")
public class PurchaseController extends BaseCommonController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Purchase entity){
        purchaseService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody Purchase entity){
        if((StringUtils.isNotBlank(entity.getId()))){
            Purchase purchase=purchaseService.findOne(entity.getId());
            BeanUtills.copyProperties(entity, purchase);
            purchaseService.save(purchase);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        Purchase entity= purchaseService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        purchaseService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page( Purchase entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<Purchase> pageEntity = new PageEntity<>(start,size,page);
        purchaseService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(Purchase entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (entity.getId()!=null){
            parameterMap.put("type", entity.getType());
        }
        return parameterMap;
    }
}

