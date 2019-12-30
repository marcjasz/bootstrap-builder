import pl.put.poznan.builder.logic.Request;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestTest {
    @org.junit.jupiter.api.Test
    void setHeaderEnableTest() {
        Request request= new Request ();
        boolean variable = true;
        request.setHeaderEnable (variable);
        assertTrue(request.isHeaderEnable ());
    }
    @org.junit.jupiter.api.Test
    void setHeaderTypeTest() {
        Request request = new Request ();
        String variable = "static";
        request.setHeaderType (variable);
        assertEquals ("static", request.getHeaderType ());
    }
    @org.junit.jupiter.api.Test
    void setHeaderTextTest() {
        Request request = new Request ();
        String variable = "Boli";
        request.setHeaderText (variable);
        assertEquals ("Boli", request.getHeaderText ());
    }
    @org.junit.jupiter.api.Test
    void setFooterEnableTest() {
        Request request= new Request ();
        boolean variable = true;
        request.setFooterEnable (variable);
        assertTrue(request.isFooterEnable ());
    }
    @org.junit.jupiter.api.Test
    void setFooterTextTest() {
        Request request = new Request ();
        String variable = "Boli";
        request.setFooterText (variable);
        assertEquals ("Boli", request.getFooterText ());
    }
}