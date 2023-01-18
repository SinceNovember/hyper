package com.simple.hyper.common.ex;

import lombok.Data;

/**
 * 通用业务异常
 *
 * @author SinceNovember
 * @date 2022/12/13
 */
@Data
public class HyperException extends RuntimeException{

    private Integer code;

    public HyperException(){
        super();
    }

    public HyperException(String message) {
        super(message);
    }

    public HyperException(int code, String message) {
        super(message);
        this.code = code;
    }
}
