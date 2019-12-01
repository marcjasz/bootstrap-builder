package pl.put.poznan.builder.logic;

import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Vector;

/**
 *This class enables creating objects of html site. It is builder.
 */
public class TemplateBuilder {
    /**
     *This class creates fluent API for creating TemplateBuilder objects.
     */
    public static final class Builder{
        private Element head;
        private Element body;
        private Element main;
        private boolean headerEnable = false;
        private String headerType;
        private String headerText;
        private boolean footerEnable = false;
        private String footerText;
        private String metaTitle;
        private String metaType;
        private String metaDescription;
        private String metaImage; //?
        private boolean metaSeoNormal;
        private boolean metaSeoTwitter;
        private boolean metaSeoOpengraph;

        public Builder setHead() {
            this.head = new Element().setTag("head");
            return this;
        }

        public Builder setBody() {
            this.body = new Element().setTag("body");
            return this;
        }

        public Builder setMain() {
            Element main = new Element().setTag("main");
            main.addAttribute(new Attribute("class", "container"));
            this.main = main;
            return this;
        }

        public Builder addMeta(String attrTag, String ... attrValues) {
            Element meta = new Element().setTag("meta").setNullTag();
            Attribute attr = new Attribute(attrTag);
            for(String attrValue : attrValues) {
                attr.addValue(attrValue);
            }
            meta.addAttribute(attr);
            this.head.addNode(meta);
            return this;
        }

        public Builder linkBootstrap() {
            Element link = new Element()
                .setTag("link")
                .setNullTag()
                .addAttribute(new Attribute("href", "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"))
                .addAttribute(new Attribute("integrity", "sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"))
                .addAttribute(new Attribute("rel", "stylesheet"))
                .addAttribute(new Attribute("crossorigin", "anonymous"));
            this.head.addNode(link);
            return this;
        }

        public Builder addParagraph(String content, String ... classAttrs) {
            Element p = new Element()
                    .setTag("p")
                    .setText(content);
            Attribute attr = new Attribute("class");
            for(String classAttr : classAttrs) {
                attr.addValue(classAttr);
            }
            p.addAttribute(attr);
            this.main.addNode(p);
            return this;
        }

        public Builder headerEnable(boolean headerEnable){
            this.headerEnable = headerEnable;
            return this;
        }

        public Builder headerType(String headerType){
            this.headerType = headerType;
            return this;
        }

        public Builder headerText(String headerText){
            this.headerText = headerText;
            return this;
        }

        public Builder footerEnable(boolean footerEnable){
            this.footerEnable = footerEnable;
            return this;
        }

        public Builder footerText(String footerText){
            this.footerText = footerText;
            return this;
        }

        public Builder metaTitle(String metaTitle){
            this.metaTitle = metaTitle;
            return this;
        }

        public Builder metaType(String metaType){
            this.metaType = metaType;
            return this;
        }

        public Builder metaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
            return this;
        }

        public Builder metaImage(String metaImage){
            this.metaImage = metaImage;
            return this;
        }

        public Builder metaSeoNormal(boolean metaSeoNormal){
            this.metaSeoNormal = metaSeoNormal;
            return this;
        }

        public Builder metaSeoTwitter(boolean metaSeoTwitter){
            this.metaSeoTwitter = metaSeoTwitter;
            return this;
        }

        public Builder metaSeoOpengraph(boolean metaSeoOpengraph){
            this.metaSeoOpengraph = metaSeoOpengraph;
            return this;
        }

        /**
         * @return This method creates object, it always should be at the end of definition of new object.
         */
        public String build() {
            String doctype = new Element().setTag("!DOCTYPE html").setNullTag().toString();
            String document = new Element()
                .setTag("html")
                .addNode(this.head)
                .addNode(this.body.addNode(this.main))
                .setDepth(0)
                .toString();
            return doctype + "\n" + document;
        }
    }

    /**
     * @return This method creates new builder object to create new templateBuilder object.
     */
    public static Builder builder() {
        return new Builder();
    }
}
