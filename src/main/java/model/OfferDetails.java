package model;

public class OfferDetails {

    String pageId;
    String description;

    String placementId;
    String offerId;
    String placementUrl;

    public OfferDetails(String pageId, String description,String placementId,String offerId,String placementUrl) {
        super();
        this.pageId = pageId;
        this.description=description;
        this.placementId=placementId;
        this.offerId=offerId;
        this.placementUrl=placementUrl;
    }
    public String getPlacementId() {
        return placementId;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getPlacementUrl() {
        return placementUrl;
    }



    public String getPageId() {
        return pageId;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetails() {
    }


}
