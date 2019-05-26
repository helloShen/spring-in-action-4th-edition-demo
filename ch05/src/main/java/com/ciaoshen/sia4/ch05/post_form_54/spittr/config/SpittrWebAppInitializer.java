package com.ciaoshen.sia4.ch05.post_form_54.spittr.config;

// spring framework
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// servlet
import javax.servlet.ServletException;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 将一个或多个路径映射到DispatcherServlet上
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * 要求ContextLoaderListener加载根应用上下文（Application Context）时，
     * 创建定义在RootConfig.class配置类中的bean。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * 要求DispatcherServlet加载网络子应用上下文（Web Application Context）时，
     * 创建定义在WebConfig配置类中的bean。
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}
