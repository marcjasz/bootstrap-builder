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
        private String name;
        private String text;
        private Integer depth = 0;
        private Boolean nullTag = false;
        private Vector<Attribute> attributes = new Vector<Attribute>();
        private Vector<Builder> childElements = new Vector<Builder>();

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

        public Builder addNode(Builder node) {
            this.childElements.addElement(node);
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNullTag(Boolean nullTag) {
            this.nullTag = nullTag;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setDepth(Integer depth){
            this.depth = depth;
            for(Builder child : childElements) {
                child.setDepth(depth + 1);
            }
            return this;
        }

        public Builder addAttribute(Attribute attribute) {
            this.attributes.addElement(attribute);
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
            String result = getIndentation() + "<"  + this.name;
            for(Attribute attribute : this.attributes) {
                result += " " + attribute.toString();
            }
            result += ">";
            for(Builder child : childElements) {
                result += "\n" + child.build();
            }
            if (!StringUtils.isEmpty(this.text)) {
                result += "\n\t" + getIndentation() + this.text;
            }
            if(!this.nullTag) {
                result += "\n" + getIndentation() + "</" + this.name + ">";
            }
            return result;
        }

        private String getIndentation() {
            return String.join("", Collections.nCopies(this.depth, "\t"));
        }
    }

    /**
     * @return This method creates new builder object to create new templateBuilder object.
     */
    public static Builder builder() {
        return new Builder();
    }
}
