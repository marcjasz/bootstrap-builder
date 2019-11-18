package pl.put.poznan.transformer.logic;

public class TemplateBuilder {
    private boolean headerEnable;
    private String headerType;
    private String headerText;
    private boolean footerEnable;
    private String footerText;
    private String metaTitle;
    private String metaType;
    private String metaDescription;
    private String metaImage; //?
    private boolean metaSeoNormal;
    private boolean metaSeoTwitter;
    private boolean metaSeoOpengraph;

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

        public TemplateBuilder build(){

            TemplateBuilder templateBuilder= new TemplateBuilder();
            templateBuilder.headerEnable = this.headerEnable;
            templateBuilder.headerType = this.headerType;
            templateBuilder.headerText = this.headerText;
            templateBuilder.footerEnable = this.footerEnable;
            templateBuilder.footerText = this.footerText;
            templateBuilder.metaTitle = this.metaTitle;
            templateBuilder.metaType = this.metaType;
            templateBuilder.metaDescription = this.metaDescription;
            templateBuilder.metaImage = this.metaImage;
            templateBuilder.metaSeoNormal = this.metaSeoNormal;
            templateBuilder.metaSeoTwitter = this.metaSeoTwitter;
            templateBuilder.metaSeoOpengraph = this.metaSeoOpengraph;

            return templateBuilder;
        }
    }
    public static Builder builder() {
        return new Builder();
    }
}
