package pl.put.poznan.builder.logic;

/**
 *This class enables creating objects of html site. It is builder.
 */
public class TemplateBuilder {
    private String result;

    /**
     *This class creates fluent API for creating TemplateBuilder objects.
     */
    public static final class Builder{
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
        public String build(){

            TemplateBuilder templateBuilder= new TemplateBuilder();
            templateBuilder.result =  "<!DOCTYPE html>\n"
                                      +"<html lang=\"en\">\n"
                                      +"<head>\n"
                                      +"\t<meta charset=\"utf-8\">\n"
                                      +"\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                                      +"\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
                                      +"</head>\n"
                                      +"<body>\n"
                                      +"\t<h1>Hello, world!</h1>\n"
                                      +"</body>"
                                      +"</html>";
            return templateBuilder.result;
        }
    }

    /**
     * @return This method creates new builder object to create new templateBuilder object.
     */
    public static Builder builder() {
        return new Builder();
    }
}
