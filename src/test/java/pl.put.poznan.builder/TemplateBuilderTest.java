import org.testng.annotations.Test;
import pl.put.poznan.builder.logic.TemplateBuilder;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;


public class TemplateBuilderTest {

    @Test
    public void builderAddMetaTest() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addMeta("meta", "title");
        assertEquals( "head",builder.getHeadTag());
    }
    @Test
    public void builderAddMeta2Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addMeta("meta", "title");
        assertNotEquals( "meta",builder.getHeadTag());
    }
    @Test
    public void builderAddMeta3Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addMeta("meta", "title");
        assertEquals(builder.getHeadChildTag(), "meta");
    }
    @Test
    public void builderAddMeta4Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addMeta("meta", "title");
        assertNotEquals(builder.getHeadChildTag(), "head");
    }
    @Test
    public void linkBootstrapTest() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.linkBootstrap();
        assertEquals(builder.getHeadChildTag(), "link");
    }
    @Test
    public void addParagraphTest() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addParagraph ("Hello", "display-1");
        assertEquals(builder.getMainChildTag(), "p");
    }
    @Test
    public void addParagraph2Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addParagraph ("Hello", "display-1");
        assertNotEquals(builder.getMainChildTag(), "r");
    }
    @Test
    public void addParagraph3Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addParagraph ("Hello", "display-1");
        assertNotEquals(builder.getMainChildText(), "Hello1");
    }
    @Test
    public void addParagraph4Test() {
        TemplateBuilder.Builder builder = new TemplateBuilder.Builder();
        builder.setHead();
        builder.setMain();
        builder.setBody();
        builder.addParagraph ("Hello", "display-1");
        assertEquals(builder.getMainChildText(), "Hello");
    }


}