package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Null 값은 제외
@Getter
@Setter
@NoArgsConstructor
public class YearMonthCountDto {

    @JsonProperty("yearMonth")
    private String yearMonth;

    @JsonProperty("totCnt")
    private Integer totCnt;
}
