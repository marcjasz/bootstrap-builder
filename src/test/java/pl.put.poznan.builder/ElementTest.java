import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.Element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ElementTest {

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


}