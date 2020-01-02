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
    private String title;
    private String description;
    private boolean openGraphEnabled;
    private String openGraphTitle;
    private String openGraphUrl;
    private String openGraphImage;
    private boolean twitterCardEnabled;
    private String twitterCardTitle;
    private String twitterCardUrl;
    private String twitterCardImage;
    private String twitterCardDescription;

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

    public boolean isOpenGraphEnabled() { return openGraphEnabled; }

    public void setOpenGraphEnabled(boolean openGraphEnabled) { this.openGraphEnabled = openGraphEnabled; }

    public String getOpenGraphTitle() { return openGraphTitle; }

    public void setOpenGraphTitle(String openGraphTitle) { this.openGraphTitle = openGraphTitle; }

    public String getOpenGraphUrl() { return openGraphUrl; }

    public void setOpenGraphUrl(String openGraphUrl) { this.openGraphUrl = openGraphUrl; }

    public String getOpenGraphImage() { return openGraphImage; }

    public void setOpenGraphImage(String openGraphImage) { this.openGraphImage = openGraphImage; }

    public boolean isTwitterCardEnabled() { return twitterCardEnabled; }

    public void setTwitterCardEnabled(boolean twitterCardEnabled) { this.twitterCardEnabled = twitterCardEnabled; }

    public String getTwitterCardTitle() { return twitterCardTitle; }

    public void setTwitterCardTitle(String twitterCardTitle) { this.twitterCardTitle = twitterCardTitle; }

    public String getTwitterCardUrl() { return twitterCardUrl; }

    public void setTwitterCardUrl(String twitterCardUrl) { this.twitterCardUrl = twitterCardUrl; }

    public String getTwitterCardImage() { return twitterCardImage; }

    public void setTwitterCardImage(String twitterCardImage) { this.twitterCardImage = twitterCardImage; }

    public String getTwitterCardDescription() { return twitterCardDescription; }

    public void setTwitterCardDescription(String twitterCardDescription) { this.twitterCardDescription = twitterCardDescription; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
