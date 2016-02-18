package at.ac.tgm.hit.dezsyslabor.hampl.rest;

import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import at.ac.tgm.hit.dezsyslabor.hampl.service.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class RegisterEndpoint {

    @Inject
    UserRepository userRepository;

    @POST
    public Response post(User user) {
        if (!this.userRepository.exists(user.getEmail())) {
            this.userRepository.save(user);
            return Utils.createResponse(Response.Status.CREATED, "User successfully created!");
        } else {
            return Utils.createResponse(Response.Status.BAD_REQUEST, "User already exists");
        }
    }
}
