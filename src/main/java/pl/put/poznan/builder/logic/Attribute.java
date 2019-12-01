package pl.put.poznan.builder.logic;

import java.util.Vector;

public class Attribute {
    private String name;
    private Vector<String> values;

    public Attribute(String name) {
        this.name = name;
        this.values = new Vector<String>();
    }

    public Attribute(String name, String value) {
        this.name = name;
        this.values = new Vector<String>();
        addValue(value);
    }

    public Attribute addValue(String value) {
        this.values.addElement(value);
        return this;
    }

    public String toString() {
        String result = this.name + "=";
        result += '"' + this.values.toString().replaceAll(",|]|\\[", "") + '"';
        return result;
    }
}
