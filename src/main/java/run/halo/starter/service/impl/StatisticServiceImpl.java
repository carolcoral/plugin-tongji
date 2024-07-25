package run.halo.starter.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.ReactiveSettingFetcher;
import run.halo.starter.service.StatisticService;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final ReactiveSettingFetcher settingFetcher;

    private final String BAIDU = "baidu";
    private final String LA = "51la";

    // 创建webClient
    private WebClient webClient;

    public StatisticServiceImpl(ReactiveSettingFetcher settingFetcher) {
        this.settingFetcher = settingFetcher;
    }

    /**
     * 获取token
     *
     * @return token对象
     */
    @Override
    public Mono<JsonNode> get51LaAuthToken() {
        return this.settingFetcher.get(LA).flatMap(base -> {
            String username = base.get("username").asText();
            String password = base.get("password").asText();
            String url = "/api/user/login";
            Map<String, Object> params = new HashMap<>();
            params.put("account", username);
            params.put("password", password);
            params.put("source", "v6");
            params.put("redirect", "");
            params.put("register", 2);
            params.put("src", "");

            this.webClient = WebClient.builder().baseUrl("https://user.51.la").build();

            return webClient.post().uri(url).contentType(MediaType.APPLICATION_JSON)  // JSON数据类型
                .body(BodyInserters.fromValue(params))  // JSON字符串数据
                .retrieve() // 获取响应体
                .bodyToMono(JsonNode.class);
        });
    }

    /**
     * 获取百度统计数据
     * @return 百度统计数据
     */
    @Override
    public Mono<JsonNode> baiduStatistic() {
        return null;
    }

    /**
     * 获取51LA统计数据
     * @return 51LA统计数据
     */
    @Override
    public Mono<JsonNode> laStatistic() {
        Mono<JsonNode> authToken = get51LaAuthToken();
        return authToken.flatMap(res -> {
            var token = res.get("data").get("auth_token").textValue();

            String url = "/api/site/list";
            String cookie = "auth_token=".concat(token);
            this.webClient = WebClient.builder().baseUrl("https://v6.51.la").build();

            return webClient.get().uri(url).header("Cookie", cookie)
                .retrieve() // 获取响应体
                .bodyToMono(JsonNode.class);
        });
    }

}
