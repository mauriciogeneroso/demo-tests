package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GrafanaNode(String id,
                          String title,
                          String subTitle,
                          String mainStat,
                          int secondaryStat,
                          @JsonProperty("arc__failed")
                          double arcFailed,
                          @JsonProperty("arc__passed")
                          double arcPassed,
                          @JsonProperty("detail__zone")
                          String detailZone) {
    public GrafanaNode(String id, String title, String subTitle, double arcFailed, double arcPassed) {
        this(id, title, subTitle, null, arcFailed, arcPassed);
    }

    public GrafanaNode(String id, String title, String subTitle, String mainStat, double arcFailed, double arcPassed) {
        this(id, title, subTitle, mainStat, 0, arcFailed, arcPassed, null);
    }
}
