package com.burgas.springbrandcars.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String @NotNull [] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(@NotNull ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerServletFilter(servletContext, new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, true ,"/*");
    }
}
