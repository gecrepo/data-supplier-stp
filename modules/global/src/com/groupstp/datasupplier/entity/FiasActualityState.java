package com.groupstp.datasupplier.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum FiasActualityState implements EnumClass<String> {

    ACTUAL("0"),
    PARENT_CHANGED("51"),
    REMOVED("99"),
    RENAMED1("1"),
    RENAMED50("50");

    private String id;

    FiasActualityState(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static FiasActualityState fromId(String id) {
        for (FiasActualityState at : FiasActualityState.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}