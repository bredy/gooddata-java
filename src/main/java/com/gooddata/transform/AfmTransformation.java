package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Represents structure for triggering AFM (Attributes Filters Metrics) transformation.
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("afmTransformationRequest")
public class AfmTransformation {

    // TODO add URI
    private Afm afm;
    private Transformation transformation;

    @JsonProperty
    public Afm getAfm() {
        return afm;
    }

    @JsonProperty
    public Transformation getTransformation() {
        return transformation;
    }
}
