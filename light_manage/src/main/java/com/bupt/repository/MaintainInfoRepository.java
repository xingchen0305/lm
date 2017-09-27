package com.bupt.repository;

import com.bupt.domain.MaintainInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by CJ on 2017/9/21.
 */
@Repository
public interface MaintainInfoRepository extends JpaRepository<MaintainInfo,String>{
}
