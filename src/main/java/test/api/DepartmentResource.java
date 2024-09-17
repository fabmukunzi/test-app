package test.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import test.api.dtos.DepartmentDto;
import test.api.services.DepartmentService;

import java.util.HashMap;
import java.util.Map;

@Path("/api/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {
    @Inject
    DepartmentService departmentService;
    @POST
    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        departmentService.creatDepartment(departmentDto);
        return departmentDto;
    }
    @GET
    public Response getDepartments(){
        return Response.ok(departmentService.getDepartments()).build();
    }
    @Path("/{id}")
    @GET
    public Response getDepartmentById(@PathParam("id") Long id) {
        return Response.ok(departmentService.getDepartmentById(id)).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteDepartmentById(@PathParam("id") Long id){
        try{
            var deleted= departmentService.deleteDepartmentById(id);
            Map<String,Object> response=new HashMap<>();
            if(deleted){
                response.put("message","Department deleted successfully");
                return Response.ok(response).build();
            }
            else {
                response.put("message","Department with id "+id+" is not found");
                return Response.ok(response).build();
            }

        }catch (Exception e){
            Map<String,Object> response=new HashMap<>();
            response.put("message","Error deleting department");
            response.put("error",e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
