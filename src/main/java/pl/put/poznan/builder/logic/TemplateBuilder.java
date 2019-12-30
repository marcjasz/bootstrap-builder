package pl.put.poznan.builder.logic;

/**
 * This class enables high-level control over the HTML page.
 * It constructs whole predefined elements (head, body, meta tags etc.).
 * Order in which methods are called is important - you need to set the parent (outer) element before its child!
 */
public class TemplateBuilder {
    /**
     *This class creates fluent API for creating TemplateBuilder objects.
     */
    public static final class Builder{
        private Element head;
        private Element body;
        private Element main;

        /** Empty {@code <head>} element. */
        public Builder setHead() {
            this.head = new Element().setTag("head");
            return this;
        }

        /** Empty {@code <body>} element. */
        public Builder setBody() {
            this.body = new Element().setTag("body");
            return this;
        }

        /** {@code <main>} element, specifying the main content of the document. */
        public Builder setMain() {
            Element main = new Element().setTag("main");
            main.addAttribute(new Attribute("class", "container"));
            this.main = main;
            return this;
        }

        /** Appends a {@code <meta>} tag to the head element.
         * @param attrTag name of the tag's attribute
         * @param attrValues arguments which will be added as values of that attribute
         */
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

        /** Adds a {@code <link>} tag which imports Bootstrap stylesheet into the document. */
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

        /**
         * Adds a {@code <meta>} tag to the header with OpenGraph attributes ("property" prefixed with "og:" and "content")
         * @param property OpenGraph protocol property
         * @param content value from the request
         * @return
         */
        public Builder addOpenGraphTag(String property, String content) {
            Element meta = new Element().setTag("meta").setNullTag();
            Attribute prop = new Attribute("property", "og:" + property);
            Attribute cont = new Attribute("content", content);
            meta.addAttribute(prop).addAttribute(cont);
            this.head.addNode(meta);
            return this;
        }

        /**
         * Adds a {@code <meta>} tag to the header with Twitter Card attributes ("name" prefixed with "twitter:" and "content")
         * @param name Twitter Card property name
         * @param content value from the request
         * @return
         */
        public Builder addTwitterTag(String name, String content) {
            Element meta = new Element().setTag("meta").setNullTag();
            Attribute attrName = new Attribute("name", "twitter:" + name);
            Attribute cont = new Attribute("content", content);
            meta.addAttribute(attrName).addAttribute(cont);
            this.head.addNode(meta);
            return this;
        }

        /** Adds a paragraph to the main section. Not in the project specification, but it shows if Bootstrap works.
         * @param content text inside the paragraph
         * @param classAttrs values of the 'class' attribute, in particular we can enter Bootstrap stuff here.
         */
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

        /**
         * @return This method creates a string from the previously declared HTML code,
         * it always should be at the end of definition of new object.
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
