package com.groupstp.datasupplier.data;

import java.io.Serializable;
import java.util.Objects;

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
    private String kladrId;
    private Double latitude;
    private Double longitude;
    private String source;
    private String fiasLevel;
    private String fiasActualityState;
    private String qcGeo;
    private String qcHouse;
    private String qc;
    private String unparsedParts;


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

    public String getKladrId() {
        return kladrId;
    }

    public void setKladrId(String kladrId) {
        this.kladrId = kladrId;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFiasLevel() {
        return fiasLevel;
    }

    public void setFiasLevel(String fiasLevel) {
        this.fiasLevel = fiasLevel;
    }

    public String getFiasActualityState() {
        return fiasActualityState;
    }

    public void setFiasActualityState(String fiasActualityState) {
        this.fiasActualityState = fiasActualityState;
    }

    public String getQcGeo() {
        return qcGeo;
    }

    public void setQcGeo(String qcGeo) {
        this.qcGeo = qcGeo;
    }

    public String getQcHouse() {
        return qcHouse;
    }

    public void setQcHouse(String qcHouse) {
        this.qcHouse = qcHouse;
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc;
    }

    public String getUnparsedParts() {
        return unparsedParts;
    }

    public void setUnparsedParts(String unparsedParts) {
        this.unparsedParts = unparsedParts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() == o.getClass()) {
            AddressData other = (AddressData) o;
            return Objects.equals(address, other.address) &&
                    Objects.equals(postalCode, other.postalCode) &&
                    Objects.equals(fiasId, other.fiasId) &&
                    Objects.equals(fiasCode, other.fiasCode) &&
                    Objects.equals(kladrId, other.kladrId) &&
                    Objects.equals(latitude, other.latitude) &&
                    Objects.equals(longitude, other.longitude) &&
                    Objects.equals(source, other.source) &&
                    Objects.equals(fiasLevel, other.fiasLevel) &&
                    Objects.equals(fiasActualityState, other.fiasActualityState) &&
                    Objects.equals(qcGeo, other.qcGeo) &&
                    Objects.equals(qcHouse, other.qcHouse) &&
                    Objects.equals(qc, other.qc) &&
                    Objects.equals(unparsedParts, other.unparsedParts);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, postalCode, fiasId, fiasCode, kladrId, latitude, longitude,
                source, fiasLevel, fiasActualityState, qcGeo, qcHouse, qc, unparsedParts);
    }
}
