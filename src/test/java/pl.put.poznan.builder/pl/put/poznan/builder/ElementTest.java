package pl.put.poznan.builder;
import org.junit.Test;
import pl.put.poznan.builder.logic.Element;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ElementTest {

    @Test
    public void addNodeTest() {
        Element child = new Element();
        child.setTag("meta");
        Element parent = new Element();
        parent.setTag("head");
        parent.addNode(child);
        assertEquals("meta", parent.getChildTag());

    }

    @Test
    public void addNode2Test() {
        Element child = new Element();
        child.setTag("meta");
        Element parent = new Element();
        parent.setTag("head");
        parent.addNode(child);
        assertNotEquals("head", parent.getChildTag());
    }

    @Test
    public void toStringTest() {
        Element child = new Element();
        child.setTag("meta");
        child.setText("Hello");
        child.setNullTag();
        Element parent = new Element();
        parent.setTag("head");
        parent.setText("world");
        parent.setNullTag();
        parent.addNode(child);
        assertEquals("<head>\n<meta>\n\tHello\n\tworld", parent.toString() );
    }

    @Test
    public void toString2Test() {
        Element child = new Element();
        child.setTag("meta");
        child.setText("Hello");
        Element parent = new Element();
        parent.setTag("head");
        parent.setText("world");
        parent.addNode(child);
        assertEquals("<head>\n<meta>\n\tHello\n</meta>\n\tworld\n</head>", parent.toString() );
    }

    @Test
    public void toString3Test() {
        Element parent = new Element();
        parent.setTag("head");
        parent.setText("world");
        assertEquals("<head>\n\tworld\n</head>", parent.toString() );
    }

    @Test
    public void toString4Test() {
        Element parent = new Element();
        parent.setTag("head");
        assertEquals("<head>\n</head>", parent.toString() );
    }
}