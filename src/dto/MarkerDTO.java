package dto;

public class MarkerDTO {
    private int markerId;
    private String markerCompany;
    private String markerColor;
    private double markerPrice;

    public int getMarkerId() {
        return markerId;
    }

    public void setMarkerId(int markerId) {
        this.markerId = markerId;
    }

    public String getMarkerCompany() {
        return markerCompany;
    }

    public void setMarkerCompany(String markerCompany) {
        this.markerCompany = markerCompany;
    }

    public String getMarkerColor() {
        return markerColor;
    }

    public void setMarkerColor(String markerColor) {
        this.markerColor = markerColor;
    }

    public double getMarkerPrice() {
        return markerPrice;
    }

    public void setMarkerPrice(double markerPrice) {
        this.markerPrice = markerPrice;
    }
}
