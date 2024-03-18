package com.hydroyura.tutorials.springauthserver.sharedlibs;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Enumeration;


public abstract class AbstractLogFilter implements Filter {

    protected Logger LOG;

    @PostConstruct
    protected abstract void initLogger();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = HttpServletRequest.class.cast(req);
        LOG.info("Got request to URL=[{}]", r.getRequestURL());
        LOG.info("\tHEADERS:");
        int counter = 1;
        Enumeration<String> headers = r.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            LOG.info("{}. {} = [{}]", counter, headerName, r.getHeader(headerName));
            counter++;
        }
        LOG.info("----------------------------------------------------------------\n\n\n");
        chain.doFilter(req, res);
    }
}