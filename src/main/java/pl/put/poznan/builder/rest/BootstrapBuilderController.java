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
    String post(@RequestBody Request request) {
        new TemplateBuilder();
        TemplateBuilder.Builder templateBuilder  = TemplateBuilder.builder()
            .setHead()
            .addMeta("charset", "utf-8")
            .addMeta("name", "viewport")
            .addMeta("content", "width=device-width", "initial-scale=1", "shrink-to-fit=no")
            .linkBootstrap()
            .setBody()
            .setMain()
            .addParagraph("Hello", "display-1");

        if (request.isOpenGraphEnabled()) {
            templateBuilder.addOpenGraphTag("type", "website");

            if (request.getOpenGraphTitle() != null)
                templateBuilder.addOpenGraphTag("title", request.getOpenGraphTitle());

            if (request.getOpenGraphUrl() != null)
                templateBuilder.addOpenGraphTag("title", request.getOpenGraphUrl());
        }

        return templateBuilder.build();
    }
}


