package pl.put.poznan.builder.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.Attribute;
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
        String doctype = TemplateBuilder.builder()
                .setName("!DOCTYPE html")
                .setNullTag(true)
                .build();

        TemplateBuilder.Builder meta = TemplateBuilder.builder()
                .setName("meta")
                .setNullTag(true)
                .addAttribute(new Attribute("charset", "utf-8"))
                .addAttribute(new Attribute("name", "viewport"))
                .addAttribute(new Attribute("content")
                                    .addValue("width=device-width")
                                    .addValue("initial-scale=1")
                                    .addValue("shrink-to-fit=no"));

        TemplateBuilder.Builder linkBootstrap = TemplateBuilder.builder()
                .setName("link")
                .setNullTag(true)
                .addAttribute(new Attribute("href", "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"))
                .addAttribute(new Attribute("integrity", "sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"))
                .addAttribute(new Attribute("crossorigin", "anonymous"));

        TemplateBuilder.Builder head = TemplateBuilder.builder()
                .setName("head")
                .addNode(meta)
                .addNode(linkBootstrap);

        TemplateBuilder.Builder body = TemplateBuilder.builder()
                .setName("body")
                .addNode(TemplateBuilder.builder()
                                .setName("h1")
                                .setText("Hello"));

        TemplateBuilder.Builder base = TemplateBuilder.builder()
                    .setName("html")
                    .addAttribute(new Attribute("lang", "en"))
                    .addNode(head)
                    .addNode(body)
                    .setDepth(0);

        return doctype + "\n" + base.build();
    }
}


