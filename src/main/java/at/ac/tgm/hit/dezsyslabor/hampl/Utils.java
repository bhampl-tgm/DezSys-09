package at.ac.tgm.hit.dezsyslabor.hampl;

import org.hornetq.utils.json.JSONObject;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Response createResponse(Response.Status status, String message) {
        Map<String, String> msg = new HashMap<>();
        msg.put("code", status.getStatusCode() + "");
        msg.put("reason", status.toString());
        msg.put("message", message);
        return Response.status(status).entity(new JSONObject(msg).toString()).build();
    }
}
