package com.groupstp.datasupplier.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum QcGeo implements EnumClass<String> {

    ACCURATE("0"),
    NEAREST_HOUSE("1"),
    STREET("2"),
    LOCATION("3"),
    CITY("4"),
    UNDEFINED("5");

    private String id;

    QcGeo(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static QcGeo fromId(String id) {
        for (QcGeo at : QcGeo.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}