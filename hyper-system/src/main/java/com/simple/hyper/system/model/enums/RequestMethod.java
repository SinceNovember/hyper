package com.simple.hyper.system.model.enums;

import com.simple.hyper.common.base.enums.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Api请求方式
 */
@Getter
@AllArgsConstructor
public enum RequestMethod implements ValueEnum<String> {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private final String type;


    @Override
    public String getValue() {
        return type;
    }


}
