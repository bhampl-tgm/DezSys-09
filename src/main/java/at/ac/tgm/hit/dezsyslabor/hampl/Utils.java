package at.ac.tgm.hit.dezsyslabor.hampl;

import org.hornetq.utils.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * A util class for the web service
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
public class Utils {
    /**
     * Creates a HTTP response with the given HTTP status code and message in JSON
     *
     * @param status  the HTTP status code
     * @param message a additional massage
     * @return the finished HTTP response with the content as JSON representation
     */
    public static Response createResponse(Response.Status status, String message) {
        Map<String, String> msg = new HashMap<>();
        msg.put("code", status.getStatusCode() + "");
        msg.put("reason", status.toString());
        msg.put("message", message);
        return Response.status(status).entity(new JSONObject(msg).toString()).build();
    }
}
