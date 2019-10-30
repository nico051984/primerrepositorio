import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ResponseCorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, 
            ContainerResponseContext responseContext) throws IOException {

        MultivaluedMap<String, Object> responseHeaders = responseContext.getHeaders();
        String origin = requestContext.getHeaderString("Origin");
        if (null != origin && 
            (ApplicationConfig.accessControlAllowedOrigins.contains(origin) ||
                 ApplicationConfig.accessControlAllowedOrigins.contains("*"))) {

            responseHeaders.putSingle("Access-Control-Allow-Origin", origin);
            responseHeaders.putSingle("Access-Control-Allow-Methods", 
                "GET, POST, OPTIONS, PUT, DELETE, HEAD");

            String reqHead = requestContext.getHeaderString(
                "Access-Control-Request-Headers");

            if (null != reqHead && !reqHead.equals("")) {
                responseHeaders.putSingle("Access-Control-Allow-Headers", reqHead);
            }
        }
    }
}