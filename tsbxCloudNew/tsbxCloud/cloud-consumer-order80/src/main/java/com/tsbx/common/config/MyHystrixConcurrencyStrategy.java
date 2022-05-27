package com.tsbx.common.config;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.Callable;

public class MyHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                try {
                    if (null != servletRequestAttributes) {
                        RequestContextHolder.setRequestAttributes(servletRequestAttributes);
                    }
                    return callable.call();
                }finally {
                    RequestContextHolder.resetRequestAttributes();
                }
            }
        };
    }
}
