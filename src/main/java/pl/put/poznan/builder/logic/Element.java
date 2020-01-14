package pl.put.poznan.builder.logic;

import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Vector;

/**
 * This class offers fine-grained control over the HTML tree.
 * It is responsible for setting of all the details of a generic element.
 */
public class Element {
    private String tag;
    private String text;
    private Integer depth = 0;
    private Boolean nullTag = false;
    private Vector<Attribute> attributes = new Vector<Attribute>();
    private Vector<Element> childElements = new Vector<Element>();

    /** Adds an element which will be inside of the current element. Elements are rendered in the order they were added here.*/
    public Element addNode(Element node) {
        this.childElements.addElement(node);
        return this;
    }

    /** Sets the name of the element's tag. E.g. 'p' for paragraph ({@code <p>...</p>}). */
    public Element setTag(String tag) {
        this.tag = tag;
        return this;
    }

    /** Marks the element as one without content, children and a closing tag; such as meta, img, link... */
    public Element setNullTag() {
        this.nullTag = true;
        return this;
    }

    public String getTag(){
        return tag;
    }

    public String getChildTag() {
        return childElements.get(0).getTag();
    }

    public  Boolean getNullTag(){
        return nullTag;
    }

    /** Sets the text content which will be placed inside the element. */
    public Element setText(String text) {
        this.text = text;
        return this;
    }

    public  String getChildText() {
        return childElements.get(0).text;
    }

    /** Method which is called recurrently to find how deeply the element is nested, so we can indent it properly. */
    public Element setDepth(Integer depth) {
        this.depth = depth;
        for(Element child : childElements) {
            child.setDepth(depth + 1);
        }
        return this;
    }

    /** Adds an attribute to the element's tag. E.g. class="text-left" */
    public Element addAttribute(Attribute attribute) {
        this.attributes.addElement(attribute);
        return this;
    }

    /** Recurrently generates a string from the element and its children. */
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

    /** Returns a string with tabs needed to properly indent the element. */
    private String getIndentation() {
        return String.join("", Collections.nCopies(this.depth, "\t"));
    }
}
