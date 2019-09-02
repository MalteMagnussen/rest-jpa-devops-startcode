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

@Path("cinema")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Get Number of Tickets Sold.
     *
     * @param id of the Movie.
     * @return Number of Tickets Sold.
     */
    @Path("/tickets/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getTicketSales(@PathParam("id") int id) {
        return GSON.toJson(FACADE.getTicketSales(id));
    }

    /**
     * Get all movies.
     * @return 
     */
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        return GSON.toJson(FACADE.getAllMoviesDTO());
    }
    
}
