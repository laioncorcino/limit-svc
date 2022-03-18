package com.corcino.limitsvc.repository;

import com.corcino.limitsvc.model.DailyLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyLimitRepository extends JpaRepository<DailyLimit, Long> {

    DailyLimit findByAgencyCodeAndAccountCode(Long agencyCode, Long accountCode);

}
