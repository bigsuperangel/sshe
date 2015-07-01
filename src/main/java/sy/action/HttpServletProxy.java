package sy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class HttpServletProxy extends HttpServlet {
	/** 
     * random serialVersionUID 
     */  
    private static final long serialVersionUID = -7208519469035631940L;  
    Log logger = LogFactory.getLog(HttpServletProxy.class);  
    private String targetServlet;  
    private HttpServlet proxy;  
    public void init() throws ServletException {  
        this.targetServlet = getInitParameter("targetServlet");  
        getServletBean();  
        proxy.init(getServletConfig());  
        System.out.println(targetServlet + " was inited by HttpServletProxy  successfully......");  
    }  
    private void getServletBean() {  
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());  
        this.proxy = (HttpServlet) wac.getBean(targetServlet);  
    }  
    @Override  
    public void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException, RuntimeException {  
        proxy.service(request, response);  
    }  
}