package com.example.demo.dto;

import java.util.List;

public record GrafanaOutput(List<GrafanaNode> nodes, List<GrafanaEdge> edges) {}
