package com.ssm.servlet;

import com.ssm.service.DemoService;
import com.ssm.service.impl.DemoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoServlet extends HttpServlet {

    private DemoService demoService;

    @Override
    public void init() throws ServletException {
        //对 service 实例化
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //spring 和 web 整合后所有信息都存放在 webApplicationContext
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        demoService = ac.getBean("demoService", DemoServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("demo servlet " + demoService.doAny());
    }

}
