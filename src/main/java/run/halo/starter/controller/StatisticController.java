package run.halo.starter.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.ApiVersion;
import run.halo.starter.service.StatisticService;

@ApiVersion("v1alpha1")
@RequestMapping("/tongji")
@RestController
@Slf4j
public class StatisticController {


    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/statistic/auth/la")
    public Mono<JsonNode> authLa() {
        return statisticService.get51LaAuthToken();
    }


    @GetMapping("/statistic/baidu")
    public Mono<JsonNode> baiduStatistic() {
        return statisticService.baiduStatistic();
    }

    @GetMapping("/statistic/51la")
    public Mono<JsonNode> laStatistic() {
        return statisticService.laStatistic();
    }


}
