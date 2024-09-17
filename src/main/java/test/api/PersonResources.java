package test.api;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import test.api.dtos.PersonDto;
import test.api.services.PersonService;

import java.util.HashMap;
import java.util.Map;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
public class PersonResources {
    @Inject
    PersonService personService;

    @Path("/persons")
    @POST
    public Response createPerson(PersonDto personDto){
        try{
            return Response.ok(personService.createPerson(personDto)).build();
        }catch (EntityNotFoundException e){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
        }

    }

    @Path("/persons")
    @GET
    public Response printPersons(){
        return Response.ok(personService.getPersons()).build();
    }

    @Path("/department/{id}/persons")
    @GET
    public Response getPersonsByDepartmentId(@PathParam("id") Long id){
        return Response.ok(personService.getPersonsByDepartmentId(id)).build();
    }
}
