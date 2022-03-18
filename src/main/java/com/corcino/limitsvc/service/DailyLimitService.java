package com.corcino.limitsvc.service;

import com.corcino.limitsvc.json.DailyLimitResponse;
import com.corcino.limitsvc.model.DailyLimit;
import com.corcino.limitsvc.repository.DailyLimitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DailyLimitService {

    private DailyLimitRepository dailyLimitRepository;

    public DailyLimitResponse getDailyLimitById(Long dailyLimitId) {
        DailyLimit dailyLimit = getDailyLimit(dailyLimitId);
        return new DailyLimitResponse(dailyLimit);
    }

    private DailyLimit getDailyLimit(Long dailyLimitId) {
        log.info("Buscando transação de id {}", dailyLimitId);
        Optional<DailyLimit> transaction = dailyLimitRepository.findById(dailyLimitId);

        return transaction.orElseThrow(() -> {
            log.error("Transação de id {} nao encontrado", dailyLimitId);
            return new RuntimeException("Transaction not found");
        });
    }

}
