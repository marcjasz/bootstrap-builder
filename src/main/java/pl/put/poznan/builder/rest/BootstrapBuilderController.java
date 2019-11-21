package pl.put.poznan.builder.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.Request;


@RestController
@RequestMapping("/")
public class BootstrapBuilderController {

    @RequestMapping(method = RequestMethod.GET, produces = "text/plain")
    public String get() {
        return "Witam";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Request port(@RequestBody Request request) {
        return request;
    }
}


