package com.groupstp.datasupplier.data;

import java.io.Serializable;

/**
 * Data supplier address representation class
 *
 * @author adiatullin
 */
public class AddressData implements Serializable {
    private static final long serialVersionUID = 6000749205632037935L;

    private String address;
    private String postalCode;
    private String fiasId;
    private String fiasCode;
    private Double latitude;
    private Double longitude;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFiasId() {
        return fiasId;
    }

    public void setFiasId(String fiasId) {
        this.fiasId = fiasId;
    }

    public String getFiasCode() {
        return fiasCode;
    }

    public void setFiasCode(String fiasCode) {
        this.fiasCode = fiasCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
