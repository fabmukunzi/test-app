package test.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/greeting")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        Map<String,Object> response=new HashMap<>();
        response.put("message","Hello from Quarkus REST");
        response.put("status",200);
        return Response.ok(response).build();
    }
}
