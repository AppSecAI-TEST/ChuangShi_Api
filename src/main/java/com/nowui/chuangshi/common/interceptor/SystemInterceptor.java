package com.nowui.chuangshi.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class SystemInterceptor implements Interceptor {

    public void intercept(Invocation invocation) {
        invocation.invoke();
    }

}
