package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GrafanaEdge(String id, String mainStat, int secondaryStat, String source, String target) {

    public GrafanaEdge(String id, String source, String target) {
        this(id, null, 0, source, target);
    }

    public GrafanaEdge(String id, String mainStat, String source, String target) {
        this(id, mainStat, 0, source, target);
    }
}
