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
    public String post(@RequestBody Request request) {
        new TemplateBuilder();

        TemplateBuilder.Builder templateBuilder  = TemplateBuilder.builder()
            .setHead()
            .addTitleIfProvided(request.getTitle())
            .addDescriptionIfProvided(request.getDescription())
            .addMeta("charset", "utf-8")
            .addMeta("name", "viewport")
            .addMeta("content", "width=device-width", "initial-scale=1", "shrink-to-fit=no")
            .linkBootstrap()
            .setBody()
            .setMain()
            .addParagraph("Hello", "display-1");

        if (request.isOpenGraphEnabled()) {
            TemplateBuilder.SeoTagBuilder openGraphBuilder = TemplateBuilder.seoTagBuilder();
            openGraphBuilder.setPrefix("og").setPropertyAttributeName("property");

            templateBuilder
                    .addSeoTagIfExists(openGraphBuilder.buildSeoTag("type", "website"))
                    .addSeoTagIfExists(openGraphBuilder.buildSeoTag("title", request.getOpenGraphTitle()))
                    .addSeoTagIfExists(openGraphBuilder.buildSeoTag("url", request.getOpenGraphUrl()))
                    .addSeoTagIfExists(openGraphBuilder.buildSeoTag("image", request.getOpenGraphImage()));
        }

        if (request.isTwitterCardEnabled()) {
            TemplateBuilder.SeoTagBuilder twitterTagBuilder = TemplateBuilder.seoTagBuilder();
            twitterTagBuilder.setPrefix("twitter").setPropertyAttributeName("name");

            templateBuilder
                    .addSeoTagIfExists(twitterTagBuilder.buildSeoTag("type", "summary"))
                    .addSeoTagIfExists(twitterTagBuilder.buildSeoTag("title", request.getTwitterCardTitle()))
                    .addSeoTagIfExists(twitterTagBuilder.buildSeoTag("url", request.getTwitterCardUrl()))
                    .addSeoTagIfExists(twitterTagBuilder.buildSeoTag("image", request.getTwitterCardImage()))
                    .addSeoTagIfExists(twitterTagBuilder.buildSeoTag("description", request.getTwitterCardDescription()));
        }
        if(request.isFooterEnable()){
             templateBuilder
                    .addFooter(request.getFooterText());
        }
        if (request.isHeaderEnable()) {
            templateBuilder
                    .addHeader(request.getHeaderType(), request.getHeaderText());
        }

        return templateBuilder.build();

    }
}


