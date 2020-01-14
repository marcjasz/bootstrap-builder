package pl.put.poznan.builder;
import org.junit.Test;
import pl.put.poznan.builder.logic.Attribute;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AttributeTest {

    @Test
    public void addValueTest() {
        Attribute  attribute = new Attribute("nazwa");
        attribute.addValue("6");
        assertEquals("[6]", attribute.getValue().toString());
    }

    @Test
    public void toStringTest() {
        String name = "nazwa";
        String value = "6";
        Attribute  attribute = new Attribute(name, value);
        assertEquals (name+"=\""+value+"\"", attribute.toString()) ;

    }

    @Test
    public void toStringNotTest() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute(name, "6");
        assertNotEquals (name+"=\""+value+"\"", attribute.toString()); ;
    }

    @Test
    public void toStringNot2Test() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute("naz", value);
        assertNotEquals (name+"=\""+value+"\"", attribute.toString());
    }

    @Test
    public void toStringNot3Test() {
        String name = "nazwa";
        String value = "5";
        Attribute  attribute = new Attribute("naz", "9");
        assertNotEquals (name+"=\""+value+"\"", attribute.toString());
    }
}