package ma.youcode.ssagencyspring.config.Initializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// docs.spring.io/spring-framework/docs/current/reference/html/web.html
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
