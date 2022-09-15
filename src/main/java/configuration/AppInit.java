package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
// appinit là class khởi tạo web.xml
// nó sẽ được sử dụng để khởi tạo các bean quan trọng trong spring mvc
// như là dispatcher servlet, view resolver, ...
// nó sẽ được sử dụng để khởi tạo các bean quan trọng trong hibernate
// như là session factory, ...
// nó sẽ được sử dụng để khởi tạo các bean quan trọng trong spring security
// như là filter chain proxy, ...
// nó sẽ được sử dụng để khởi tạo các bean quan trọng trong spring data
// như là entity manager, ...
    //abstract annotation config dispatcher servlet initializer là một class quan trọng trong spring mvc
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
//getservletmappings dung de map url
        return new String[] { "/" };
        //string array là một mảng các chuỗi
        //mỗi chuỗi là một url mapping
        //nó sẽ được sử dụng để mapping các request đến các controller

    }
}
