package pl.put.poznan.builder.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.Request;
import pl.put.poznan.builder.logic.TemplateBuilder;


@RestController
@RequestMapping("/")
public class BootstrapBuilderController {

    @RequestMapping(method = RequestMethod.GET, produces = "text/plain")
    public String get() {
        return "Witam";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "text/html")
    String port(@RequestBody Request request) {
        new TemplateBuilder();
        String result = TemplateBuilder.builder()
                .setHead()
                .setFoot()
                .addMeta("charset", "utf-8")
                .addMeta("name", "viewport")
                .addMeta("content", "width=device-width", "initial-scale=1", "shrink-to-fit=no")
                .linkBootstrap()
                .setBody()
                .setMain()
                .addParagraph("Hello", "display-1")
                .build();
        return result;
    }
}


