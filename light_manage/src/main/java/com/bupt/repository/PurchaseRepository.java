package com.bupt.repository;

import com.bupt.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface PurchaseRepository extends JpaRepository<Purchase,String> {
}
