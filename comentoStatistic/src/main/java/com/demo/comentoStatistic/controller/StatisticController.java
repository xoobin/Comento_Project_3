package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller -> @RestController로 변경
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){
        // 서비스에서 연도별 로그인 데이터를 가져옵니다.
        YearCountDto yearCountDto = statisticService.getYearLogins(year);
        return ResponseEntity.ok(yearCountDto);  // 200 OK와 함께 반환
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    public ResponseEntity<YearMonthCountDto> getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){
        // 서비스에서 연도/월별 로그인 데이터를 가져옵니다.
        YearMonthCountDto yearMonthCountDto = statisticService.getYearMonthLogins(year, month);
        return ResponseEntity.ok(yearMonthCountDto);  // 200 OK와 함께 반환
    }
}
