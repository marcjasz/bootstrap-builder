package pl.put.poznan.builder.logic;

import java.util.Vector;

/**
 * Class which defines an HTML element's attribute. It contains a name, equality sign and one or more values in quotes.
 * E.g. class="lead text-justify col-md-8"
 */
public class Attribute {
    private String name;
    public Vector<String> values = new Vector<String>();

    /** Constructor which sets only the name. */
    public Attribute(String name) {
        this.name = name;
    }

    /** Constructor which sets the name and a single value. */
    public Attribute(String name, String value) {
        this.name = name;
        addValue(value);
    }

    /** Adds an attribute value. */
    public Attribute addValue(String value) {
        this.values.addElement(value);
        return this;
    }

    /** Forms a string from the Attribute object, the values are all surrounded by quotes and separated by spaces. */
    public String toString() {
        String result = this.name + "=";
        result += '"' + this.values.toString().replaceAll(",|]|\\[", "") + '"';
        return result;
    }
}
