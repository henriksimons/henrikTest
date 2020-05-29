package henrikTest.henrikTest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {
    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Response user(@RequestParam(value = "key") String key, @RequestBody UserRequest request) {
        Response response = new Response();
        if (sharedKey.equalsIgnoreCase(key)) {

            String itemId = request.getName();

            // Process the request
            // ....
            // Return success response to the client.
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        } else {
            response.setStatus(ERROR_STATUS);
            response.setCode(AUTH_FAILURE);
        }
        return response;
    }
}