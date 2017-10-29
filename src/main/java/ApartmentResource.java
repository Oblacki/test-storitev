

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Benjamin Kastelic
 * @since 2.3.0
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("apartments")
public class ApartmentResource {

    @GET
    public Response getAllApartments() {
        List<Apartment> apartments = Database.getApartments();
        return Response.ok(apartments).build();
    }

    @GET
    @Path("{apartmentId}")
    public Response getApartment(@PathParam("apartmentId") String apartmentId) {
        Apartment apartment = Database.getApartment(apartmentId);
        return apartment != null
                ? Response.ok(apartment).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response getApartmentByCustomer(@PathParam("customerId") String customerId) {
        List<Apartment> apartments = Database.getApartmentByCustomerId(customerId);
        return apartments != null
                ? Response.ok(apartments).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewApartment(Apartment apartment) {
        Database.addApartment(apartment);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{apartmentId}")
    public Response deleteApartment(@PathParam("apartmentId") String apartmentId) {
        Database.deleteApartment(apartmentId);
        return Response.noContent().build();
    }
}
