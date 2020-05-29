package henrikTest.henrikTest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController extends SpringBootServletInitializer{

    private static final String template = "Hej, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "FÖLJ @DAGENSFOLKISKAFFE PÅ INSTAGRAM") String name) {
        return new Greeting(String.format(template, name));
    }
}