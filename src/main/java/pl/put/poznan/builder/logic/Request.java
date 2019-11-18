package pl.put.poznan.builder.logic;

/**
 * JavaBean to which request body JSON is mapped by Spring
 */
public class Request {

    private boolean headerEnable;
    private String headerType;
    private String headerText;
    private boolean footerEnable;
    private String footerText;

    public void setHeaderEnable(boolean headerEnable) { this.headerEnable = headerEnable; }

    public boolean isHeaderEnable() { return this.headerEnable; }

    public void setHeaderType(String headerType) { this.headerType = headerType; }

    public String getHeaderType() { return this.headerType; }

    public void setHeaderText(String headerText) { this.headerText = headerText; }

    public String getHeaderText() { return this.headerText; }

    public void setFooterEnable(boolean footerEnable) { this.footerEnable = footerEnable; }

    public boolean isFooterEnable() { return this.footerEnable; }

    public void setFooterText(String footerText) { this.footerText = footerText; }

    public String getFooterText() { return this.footerText; }

}
