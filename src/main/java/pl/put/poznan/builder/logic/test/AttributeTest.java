package pl.put.poznan.builder.logic.test;

import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.Attribute;

import static org.junit.jupiter.api.Assertions.*;

class AttributeTest {

    @Test
    void addValueTest() {
        Attribute  attribute = new Attribute("nazwa");
        attribute.addValue("6");
        assertEquals("[6]", attribute.getValue().toString());
    }


    @Test
    void toStringTest() {
        String name = "nazwa";
        String value = "6";
        Attribute  attribute = new Attribute(name, value);
        //assertEquals ("nazwa=\"6\"", attribute.toString()) ;
        assertEquals (name+"=\""+value+"\"", attribute.toString()) ;

    }
    @Test
    void toStringNotTest() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute(name, "6");
        assertNotEquals (name+"=\""+value+"\"", attribute.toString()); ;
    }
    @Test
    void toStringNot2Test() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute("naz", value);
        assertNotEquals (name+"=\""+value+"\"", attribute.toString());
    }
    @Test
    void toStringNot3Test() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute("naz", "9");
        assertNotEquals (name+"=\""+value+"\"", attribute.toString());
    }
}