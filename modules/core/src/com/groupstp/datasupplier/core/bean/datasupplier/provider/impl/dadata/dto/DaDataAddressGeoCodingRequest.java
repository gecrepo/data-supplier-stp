package com.groupstp.datasupplier.core.bean.datasupplier.provider.impl.dadata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * DaData service address suggestion by geo coordinates request
 *
 * @author adiatullin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaDataAddressGeoCodingRequest implements Serializable {
    private static final long serialVersionUID = -2303606637111065421L;

    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lon")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
