package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Dimension content definition. Dimension contains one or more attributes.
 */
public class Dimension {
    private final String identifier;
    private final List<String> itemIdentifiers;

    @JsonCreator
    public Dimension(
            @JsonProperty("identifier") String identifier,
            @JsonProperty("itemIdentifiers") List<String> itemIdentifiers) {
        this.identifier = identifier;
        this.itemIdentifiers = itemIdentifiers;
    }

    @JsonProperty
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty
    public List<String> getItemIdentifiers() {
        return itemIdentifiers;
    }

//    TODO do we need this when in SDK?
//    public <T extends AttributeDescription, E> List<E> processDimensionItem(Class<T> clazz, Function<T, E> mapFunction) {
//        return itemIdentifiers.stream()
//                .filter(clazz::isInstance)
//                .map(clazz::cast)
//                .map(mapFunction)
//                .collect(toList());
//    }
}
