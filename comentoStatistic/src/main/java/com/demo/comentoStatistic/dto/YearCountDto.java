package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Null 값은 제외
@Getter
@Setter

public class YearCountDto {
    @JsonProperty("year")
    private String year;

    @JsonProperty("count")
    private int count;

    // Getter 및 Setter
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}