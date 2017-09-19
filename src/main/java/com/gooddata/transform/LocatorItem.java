package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Locator hold information about specific element in path of elements.
 * It can be attribute element, metric, etc.
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AttributeLocatorItem.class, name = "attributeLocatorItem"),
        @JsonSubTypes.Type(value = MeasureLocatorItem.class, name = "metricLocatorItem")
})
interface LocatorItem {

//   TODO Locator toLocator(List<Grid.MetricElement> metrics);
}
