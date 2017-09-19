package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Define sort by specific attribute
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("attributeSortItem")
public class AttributeSortItem implements SortItem {
    private final String direction;
    private final String attributeIdentifier;

    public AttributeSortItem(
            @JsonProperty("direction") String direction,
            @JsonProperty("attributeIdentifier") String attributeIdentifier) {
        this.direction = direction;
        this.attributeIdentifier = attributeIdentifier;
    }

    public String getDirection() {
        return direction;
    }

    public String getAttributeIdentifier() {
        return attributeIdentifier;
    }

//    @Override
//    public Optional<Pair<Grid.Section, Sort.SortRule>> transformToSortRule(List<Grid.GridElement> columns,
//                                                                           List<Grid.GridElement> rows,
//                                                                           List<Grid.MetricElement> metrics,
//                                                                           Supplier<Grid.Section> defaultSectionSupplier) {
//        if (attributeIdentifier instanceof StoredItemDescription) {
//            StoredItemDescription storedItemDescription = (StoredItemDescription) attributeIdentifier;
//            if (findMatch(columns, storedItemDescription)) {
//                return Optional.of(new Pair<>(Grid.Section.COLUMNS, new Sort.AttributeSort(new Reference(storedItemDescription.getUri()), direction)));
//            } else if (findMatch(rows, storedItemDescription)) {
//                return Optional.of(new Pair<>(Grid.Section.ROWS, new Sort.AttributeSort(new Reference(storedItemDescription.getUri()), direction)));
//            } else {
//                return Optional.empty();
//            }
//        } else {
//            throw new IllegalStateException("Item should be already transformed to uri based request");
//        }
//    }
//
//    private boolean findMatch(List<Grid.GridElement> elements, StoredItemDescription _item) {
//        return elements.stream()
//                .anyMatch(gridElement -> gridElement.getUri().getTargetUriAsString().equalsIgnoreCase(_item.getUri()));
//    }
}
