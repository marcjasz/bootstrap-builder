package pl.put.poznan.builder;
import org.junit.Test;
import pl.put.poznan.builder.logic.Request;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {

    @Test
    public void setHeaderEnableTest() {
        Request request= new Request ();
        boolean variable = true;
        request.setHeaderEnable (variable);
        assertTrue(request.isHeaderEnable ());
    }

    @Test
    public void setHeaderTypeTest() {
        Request request = new Request ();
        String variable = "static";
        request.setHeaderType (variable);
        assertEquals ("static", request.getHeaderType ());
    }

    @Test
    public void setHeaderTextTest() {
        Request request = new Request ();
        String variable = "static";
        request.setHeaderText (variable);
        assertEquals ("static", request.getHeaderText ());
    }

    @Test
    public void setFooterEnableTest() {
        Request request= new Request ();
        boolean variable = true;
        request.setFooterEnable (variable);
        assertTrue(request.isFooterEnable ());
    }

    @Test
    public void setFooterTextTest() {
        Request request = new Request ();
        String variable = "static";
        request.setFooterText (variable);
        assertEquals ("static", request.getFooterText ());
    }
}