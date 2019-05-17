package com.groupstp.datasupplier.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Qc implements EnumClass<String> {

    CERTAINTY("0"),
    BAD("2"),
    EXTRA("1"),
    ALTERNATIVES("3");

    private String id;

    Qc(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Qc fromId(String id) {
        for (Qc at : Qc.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}