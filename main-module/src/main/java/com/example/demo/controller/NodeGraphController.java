package com.example.demo.controller;

import com.example.demo.dto.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * https://github.com/exaco/nodegraph-api-plugin
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/graph", produces = MediaType.APPLICATION_JSON_VALUE)
public class NodeGraphController {

    @GetMapping("/fields")
    public ResponseEntity<GrafanaFieldsOutputDto> getFields(@RequestParam(value = "query", required = false) String query) {
        List<GrafanaFieldDto> nodeFields = GrafanaFieldDto.nodeFieldsBuilder()
                .withTitle()
                .withMainStat()
                .withSecondaryStat()
                .withColor()
                .withDescription().build();

        List<GrafanaFieldDto> edgeFields = GrafanaFieldDto.edgeFieldsBuilder().withMainStat().build();
        return ResponseEntity.ok(new GrafanaFieldsOutputDto(nodeFields, edgeFields));
    }

    @GetMapping("/data")
    public GrafanaOutput fetchgraph(@RequestParam(value = "query", required = false, defaultValue = "") String query) {

        var node1 = new GrafanaNode("1", "node1", "node_subtitle", "main", 10,  0.5, 0.5, "load");
        var node2 = new GrafanaNode("2", "node2", "node_subtitle", 0.2, 0.8);
        var node3 = new GrafanaNode("3", "node3", "node_subtitle", 0, 1);
        var node4 = new GrafanaNode("4", "node4", "node_subtitle", 0, 1);
        var node5 = new GrafanaNode("5", "node5", "node_subtitle", 0.4, 0.6);
        var node6 = new GrafanaNode("6", "node6", "node_subtitle", 0.9, 0.1);
        var node7 = new GrafanaNode("7", "node7", "node_subtitle", 0, 1);
        var node8 = new GrafanaNode("8", "node8", "node_subtitle", 0, 1);
        var node9 = new GrafanaNode("9", "node9", "node_subtitle", 0, 1);
        var node10 = new GrafanaNode("10", "node10", "node_subtitle", 0.9, 0.1);
        var node11 = new GrafanaNode("11", "node11", "node_subtitle", 0.9, 0.1);
        var node12 = new GrafanaNode("12", "node12", "node_subtitle", 1, 0);
        var node13 = new GrafanaNode("13", "node13", "node_subtitle", 1, 0);
        var node14 = new GrafanaNode("14", "node14", "node_subtitle", 0.89, 0.11);
        var node15 = new GrafanaNode("15", "node15", "node_subtitle", 0.73, 0.27);
        var nodes = Arrays.asList(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12,
                node13, node14, node15);

        var edge1 = new GrafanaEdge("edge1", "53/s", "1", "2");
        var edge2 = new GrafanaEdge("edge2", "100/s", 10, "1", "3");
        var edge3 = new GrafanaEdge("edge3", "2", "4");
        var edge4 = new GrafanaEdge("edge4", "2", "5");
        var edge5 = new GrafanaEdge("edge5", "3", "6");
        var edge6 = new GrafanaEdge("edge6", "3", "7");
        var edge7 = new GrafanaEdge("edge7", "4", "8");
        var edge8 = new GrafanaEdge("edge8", "4", "9");
        var edge9 = new GrafanaEdge("edge9", "5", "10");
        var edge10 = new GrafanaEdge("edge10", "5", "11");
        var edge11 = new GrafanaEdge("edge11", "8", "4");
        var edge12 = new GrafanaEdge("edge12", "9", "4");
        var edge13 = new GrafanaEdge("edge13", "7", "12");
        var edge14 = new GrafanaEdge("edge14", "7", "13");
        var edge15 = new GrafanaEdge("edge15", "6", "14");
        var edge16 = new GrafanaEdge("edge16", "6", "15");
        var edges = Arrays.asList(edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12,
                edge13, edge14, edge15, edge16);

        return new GrafanaOutput(nodes, edges);
    }
}
