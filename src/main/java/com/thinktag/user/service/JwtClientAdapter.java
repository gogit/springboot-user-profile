package com.thinktag.user.service;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class JwtClientAdapter {


    JwtClient client;

    public JwtClientAdapter(@Value("${jwtClient.url}")
                                    String jwtClientUrl,
                            @Value("${jwtClient.url.readTimeoutSecs}")
                                    int jwtClientUrlReadTimeout,
                            @Value("${jwtClient.url.connectTimeoutSecs}")
                                    int jwtClientUrlConnectTimeout) {
        client = createClient(JwtClient.class, jwtClientUrl, jwtClientUrlReadTimeout,
                jwtClientUrlConnectTimeout);
    }

    private <T> T createClient(Class<T> type, String url,
                               int jwtClientUrlReadTimeout,
                               int jwtClientUrlConnectTimeout) {
        return Feign.builder()
                .options(new Request.Options(jwtClientUrlConnectTimeout, jwtClientUrlReadTimeout))
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, url);
    }


    public Map<String, String>  validateToken(String token) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("token", token);
        return client.validateToken(params);
    }
}
