package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds metric position
 */
public class MeasureLocatorItem implements LocatorItem {
    private final String measureIdentifier;

    @JsonCreator
    public MeasureLocatorItem(
            @JsonProperty("measureIdentifier") String measureIdentifier) {
        this.measureIdentifier = measureIdentifier;
    }

    public String getMeasureIdentifier() {
        return measureIdentifier;
    }

//    @Override
//    public Locator toLocator(List<Grid.MetricElement> metrics) {
//        if (measureIdentifier + 1 > metrics.size() || measureIdentifier < 0) {
//            throw new IllegalStateException("Invalid measureIdentifier");
//        }
//        return new Locator.MetricLocator(metrics.get(measureIdentifier).getUri());
//    }
}
