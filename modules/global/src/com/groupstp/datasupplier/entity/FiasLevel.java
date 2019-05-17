package com.groupstp.datasupplier.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum FiasLevel implements EnumClass<String> {

    COUNTRY("0"),
    REGION("1"),
    AREA("3"),
    CITY("4"),
    COMMUNITY("5"),
    LOCATION("6"),
    STREET("7"),
    HOUSE("8"),
    PLANING_STRUCTURE("65"),
    SUPPLEMENTARY_TERRITORY("90"),
    SUPPLEMENTARY_TERRITORY_STREET("91"),
    EMPTY("-1");

    private String id;

    FiasLevel(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static FiasLevel fromId(String id) {
        for (FiasLevel at : FiasLevel.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}