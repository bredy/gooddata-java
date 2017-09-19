/*
 * Copyright (C) 2017, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.md.report.Total;

import java.util.List;

/**
 * Total definition
 */
public class TotalItem {
    private final Total type;
    private final String measureIdentifier;
    private final List<String> attributeIdentifiers;

    @JsonCreator
    public TotalItem(
            @JsonProperty("type") Total type,
            @JsonProperty("measureIdentifier") String measureIdentifier,
            @JsonProperty("attributeIdentifiers") List<String> attributeIdentifiers) {
        this.type = type;
        this.measureIdentifier = measureIdentifier;
        this.attributeIdentifiers = attributeIdentifiers;
    }

    @JsonProperty
    public Total getType() {
        return type;
    }

    @JsonProperty
    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

    @JsonProperty
    public List<String> getAttributeIdentifiers() {
        return attributeIdentifiers;
    }

//    TODO
//    public <T extends AttributeDescription, E> E processTotalItem(Class<T> clazz, Function<T, E> mapFunction) {
//        if (clazz.isInstance(attributeIdentifiers)) {
//            return mapFunction.apply((T) attributeIdentifiers);
//        }
//
//        return null;
//    }
}
