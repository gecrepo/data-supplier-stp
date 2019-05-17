package com.groupstp.datasupplier.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum QcHouse implements EnumClass<String> {

    LOCATED("2"),
    NOT_LOCATED("10");

    private String id;

    QcHouse(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static QcHouse fromId(String id) {
        for (QcHouse at : QcHouse.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}