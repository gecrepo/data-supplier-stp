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
    private String fiasId;
    private String fiasCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
