package run.halo.starter.service;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Mono;

public interface StatisticService {

    /**
     * 获取token
     *
     * @return token对象
     */
    Mono<JsonNode> get51LaAuthToken();

    Mono<JsonNode> baiduStatistic();

    Mono<JsonNode> laStatistic();

}
