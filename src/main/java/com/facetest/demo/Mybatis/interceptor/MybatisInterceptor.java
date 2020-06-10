package com.facetest.demo.Mybatis.interceptor;

import com.facetest.demo.Mybatis.MybatisController;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * MyBatis自定义插件拦截器
 */
@Intercepts(
        value = {
                @Signature(
                        type = StatementHandler.class, method = "testInterFaceOverride", args = {Connection.class})
        }
)
public class MybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
