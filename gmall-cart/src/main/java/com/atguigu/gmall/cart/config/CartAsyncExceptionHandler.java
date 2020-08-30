package com.atguigu.gmall.cart.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/30/11:27
 * @Description:
 */
@Slf4j
@Component
public class CartAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("有一个子任务出现了异常。异常信息：{}，异常方法：{}，方法参数：{}", throwable.getMessage(), method, objects); //{}是占位符 会从后面按顺序放入
    }
}

