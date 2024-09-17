package test.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import test.api.dtos.QualificationDto;
import test.api.services.QualificationService;

@Path("/api")
public class QualificationResources {
    @Inject
    QualificationService qualificationService;
    @Path("/qualifications")
    @POST
    public Response createQualification(QualificationDto qualificationDto){

        return Response.ok(qualificationService.creatQualification(qualificationDto)).build();
    }
    @Path("/qualifications")
    @GET
    public Response getQualifications(){
        return Response.ok(qualificationService.getQualifications()).build();
    }
}
