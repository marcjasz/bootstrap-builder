package pl.put.poznan.builder.logic;

import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Vector;

public class Element {
    private String tag;
    private String text;
    private Integer depth = 0;
    private Boolean nullTag = false;
    private Vector<Attribute> attributes = new Vector<Attribute>();
    private Vector<Element> childElements = new Vector<Element>();

    public Element addNode(Element node) {
        this.childElements.addElement(node);
        return this;
    }

    public Element setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Element setNullTag() {
        this.nullTag = true;
        return this;
    }

    public Element setText(String text) {
        this.text = text;
        return this;
    }

    public Element setDepth(Integer depth){
        this.depth = depth;
        for(Element child : childElements) {
            child.setDepth(depth + 1);
        }
        return this;
    }

    public Element addAttribute(Attribute attribute) {
        this.attributes.addElement(attribute);
        return this;
    }

    public String toString() {
        String result = getIndentation() + "<"  + this.tag;
        for(Attribute attribute : this.attributes) {
            result += " " + attribute.toString();
        }
        result += ">";
        for(Element child : childElements) {
            result += "\n" + child.toString();
        }
        if (!StringUtils.isEmpty(this.text)) {
            result += "\n\t" + getIndentation() + this.text;
        }
        if(!this.nullTag) {
            result += "\n" + getIndentation() + "</" + this.tag + ">";
        }
        return result;
    }

    private String getIndentation() {
        return String.join("", Collections.nCopies(this.depth, "\t"));
    }
}
