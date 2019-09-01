package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("cinema")
public class MovieResource {

//    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
//                "pu",
//                "jdbc:mysql://localhost:3307/startcodev2",
//                "dev",
//                "ax2",
//                EMF_Creator.Strategy.DROP_AND_CREATE);
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Get Number of Tickets Sold.
     *
     * @param id of the Movie.
     * @return Number of Tickets Sold.
     */
    @Path("tickets/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getTicketSales(@PathParam("id") int id) {
        return new Gson().toJson(FACADE.getTicketSales(id));
    }

}
