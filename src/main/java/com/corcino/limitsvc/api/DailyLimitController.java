package com.corcino.limitsvc.api;

import com.corcino.limitsvc.json.DailyLimitResponse;
import com.corcino.limitsvc.service.DailyLimitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/daily-limit")
@Tag(name = "/daily-limit", description = "API's group for manipulation financial transactions")
@AllArgsConstructor
public class DailyLimitController {

    private DailyLimitService dailyLimitService;

    @Operation(description = "API to find daily-limit by dailyLimitId")
    @Parameters(value = {
            @Parameter(name = "dailyLimitId", in = ParameterIn.PATH)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "daily limit ok return"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "404", description = "Daily limit not found"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    @GetMapping(value = "/{dailyLimitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyLimitResponse> getDailyLimit(@PathVariable Long dailyLimitId) {
        DailyLimitResponse dailyLimitResponse = dailyLimitService.getDailyLimitById(dailyLimitId);
        return ResponseEntity.ok(dailyLimitResponse);
    }

}



























