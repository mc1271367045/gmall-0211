package com.atguigu.gmall.common.exception;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/09/01/12:44
 * @Description:
 */
public class OrderException extends RuntimeException {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}