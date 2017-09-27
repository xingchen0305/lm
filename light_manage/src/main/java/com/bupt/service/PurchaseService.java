package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Purchase;
import com.bupt.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Service
@Transactional
public class PurchaseService extends BasePageService<Purchase,String> {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase findOne(String id) {
        return purchaseRepository.findOne(id);
    }

    public void save(Purchase entity) {
        purchaseRepository.save(entity);
    }

    public void deleteById(String id) {
        purchaseRepository.delete(id);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public void pageByHql(PageEntity<Purchase> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Purchase where 1=1 ");
        if (paramaMap.containsKey("type")) {
            sql.append(" and type =:type ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }


}
