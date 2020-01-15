package com.thinktag.user.service;


import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface JwtClient {

    @RequestLine("POST /api/token/validate")
    //@Headers("Content-Type: application/json")
    Map<String, String> validateToken(@QueryMap Map<String, String> params);
}
