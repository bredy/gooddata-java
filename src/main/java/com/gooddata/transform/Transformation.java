package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static com.gooddata.util.Validate.notNull;
import static java.util.Collections.emptyList;

@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("transformationRequest")
public class Transformation {
    private final List<TransformationMeasure> measures;
    private final List<Dimension> dimensions;
    private final List<TotalItem> totals;
    private final List<SortItem> sorts;

    @JsonCreator
    public Transformation(
            @JsonProperty("measures") List<TransformationMeasure> measures,
            @JsonProperty("dimensions") List<Dimension> dimensions,
            @JsonProperty("totals") List<TotalItem> totals,
            @JsonProperty("sorts") List<SortItem> sorts) {
        this.measures = notNull(measures, "measures");
        this.dimensions = dimensions != null ? dimensions : emptyList(); // TODO really empty list? what about serialization??
        this.totals = totals != null ? totals : emptyList();
        this.sorts = sorts != null ? sorts : emptyList();
    }

    @JsonProperty
    public List<TransformationMeasure> getMeasures() {
        return measures;
    }

    @JsonProperty
    public List<Dimension> getDimensions() {
        return dimensions;
    }

    @JsonProperty
    public List<TotalItem> getTotals() {
        return totals;
    }

    @JsonProperty
    public List<SortItem> getSorts() {
        return sorts;
    }

//    @JsonIgnore
//    public Set<String> getIdentifiers() {
//        Set<String> identifiers = new HashSet<>();
//        identifiers.addAll(getDataIdentifiers());
//        identifiers.addAll(getDimensionIdentifiers());
//        identifiers.addAll(getTotalIdentifiers());
//        identifiers.addAll(getSortIdentifiers());
//        return identifiers;
//    }

//    public TransformationRequest replaceIdentifiers(Map<String, String> identifiers) {
//        return new TransformationRequest(
//                replaceDataIdentifiers(identifiers),
//                replaceDimensionIdentifiers(identifiers),
//                filters,
//                replaceTotalIdentifiers(identifiers) ,
//                replaceSortIdentifier(identifiers));
//    }
//
//    @JsonIgnore
//    public List<MetricDefinition> getMetricDefinitions() {
//        return processDataItems(
//                AdHocItemDescription.class,
//                AdHocItemDescription::getMetricDefinition
//        );
//    }
//
//    public TransformationRequest replaceMetricDefinitions(Map<String, String> metricExpressions) {
//        return new TransformationRequest(
//                processDataItems(
//                        ExtendedItemDescription.class,
//                        item -> {
//                            if (item instanceof AdHocItemDescription) {
//                                String expression = ((AdHocItemDescription)item).getValue();
//                                String uri = metricExpressions.get(expression);
//                                return new StoredItemDescription(uri);
//                            } else {
//                                return item;
//                            }
//                        }
//                ),
//                dimensions,
//                filters,
//                totals,
//                sorts);
//    }
//
//    private List<String> getDataIdentifiers() {
//        return processDataItems(
//                StoredRelativeItemDescription.class,
//                StoredRelativeItemDescription::getIdentifier
//        );
//    }
//
//    private List<String> getDimensionIdentifiers() {
//        return processDimensionItems(
//                StoredRelativeItemDescription.class,
//                StoredRelativeItemDescription::getIdentifier
//        );
//    }
//
//    private List<String> getTotalIdentifiers() {
//        return processTotalItems(
//                StoredRelativeItemDescription.class,
//                StoredRelativeItemDescription::getIdentifier
//        );
//    }
//
//    private List<String> getSortIdentifiers() {
//        return processSortItems(
//                StoredRelativeItemDescription.class,
//                StoredRelativeItemDescription::getIdentifier
//        );
//    }
//
//    private <T extends ExtendedItemDescription, E> List<E> processDataItems(Class<T> clazz, Function<T, E> mapFunction) {
//        return measures.stream()
//                .filter(clazz::isInstance)
//                .map(clazz::cast)
//                .map(mapFunction)
//                .collect(toList());
//    }
//
//    private <T extends AttributeDescription, E> List<E> processDimensionItems(final Class<T> clazz, final Function<T, E> mapFunction) {
//        return dimensions.stream()
//                .flatMap(dimension -> dimension.processDimensionItem(clazz, mapFunction).stream())
//                .collect(toList());
//    }
//
//    private <T extends AttributeDescription, E> List<E> processTotalItems(final Class<T> clazz, final Function<T, E> mapFunction) {
//        return totals.stream()
//                .map(total -> total.processTotalItem(clazz, mapFunction))
//                .filter(Objects::nonNull)
//                .collect(toList());
//    }
//
//    private <T extends AttributeDescription, E> List<E> processSortItems(final Class<T> clazz, final Function<T, E> mapFunction) {
//        List<E> sortItemsResult = new ArrayList<>();
//
//        for(SortItem sortItem : sorts) {
//            if (sortItem instanceof AttributeSortItem) {
//                AttributeSortItem attributeSortItem = (AttributeSortItem) sortItem;
//                if (clazz.isInstance(attributeSortItem.getAttributeIdentifier())) {
//                    sortItemsResult.add(
//                            mapFunction.apply(clazz.cast(attributeSortItem.getAttributeIdentifier()))
//                    );
//                }
//            } else {
//                MeasureSortItem measureSortItem = (MeasureSortItem) sortItem;
//                sortItemsResult.addAll(
//                        measureSortItem.getLocators().stream()
//                                .filter(locatorItem -> locatorItem instanceof AttributeLocatorItem)
//                                .map(AttributeLocatorItem.class::cast)
//                                .map(AttributeLocatorItem::getAttributeIdentifier)
//                                .filter(clazz::isInstance)
//                                .map(clazz::cast)
//                                .map(mapFunction)
//                                .collect(toList())
//                );
//            }
//        }
//
//        return sortItemsResult;
//    }
//
//    private List<ExtendedItemDescription> replaceDataIdentifiers(Map<String, String> identifiers) {
//        return processDataItems(
//                ExtendedItemDescription.class,
//                item -> {
//                    if (item instanceof StoredRelativeItemDescription) {
//                        String identifier = ((StoredRelativeItemDescription)item).getIdentifier();
//                        String uri = identifiers.get(identifier);
//                        return new StoredItemDescription(uri);
//                    } else {
//                        return item;
//                    }
//                }
//        );
//    }
//
//    private List<Dimension> replaceDimensionIdentifiers(Map<String, String> identifiers) {
//        return dimensions.stream()
//                .map(dimension -> new Dimension(
//                        dimension.getIdentifier(),
//                        dimension.processDimensionItem(
//                                AttributeDescription.class,
//                                item -> item.cloneToStoredItem(identifiers)
//                        )
//                ))
//                .collect(toList());
//    }
//
//
//
//    private List<TotalItem> replaceTotalIdentifiers(Map<String, String> identifiers) {
//        return totals.stream()
//                .map(total -> new TotalItem(
//                        total.getType(),
//                        total.getMeasureIdentifier(),
//                        total.processTotalItem(
//                                AttributeDescription.class,
//                                item -> item.cloneToStoredItem(identifiers)
//                        )
//                ))
//                .collect(toList());
//    }
//
//    private  List<SortItem> replaceSortIdentifier(Map<String, String> identifiers) {
//        List<SortItem> newSorts = new ArrayList<>();
//
//        for(SortItem sortItem : sorts) {
//            if (sortItem instanceof AttributeSortItem) {
//                AttributeSortItem attributeSortItem = (AttributeSortItem) sortItem;
//                newSorts.add(new AttributeSortItem(
//                        attributeSortItem.getDirection(),
//                        attributeSortItem.getAttributeIdentifier().cloneToStoredItem(identifiers)
//                ));
//            } else {
//                MeasureSortItem measureSortItem = (MeasureSortItem) sortItem;
//                newSorts.add(measureSortItem.replaceLocatorIdentifiers(identifiers));
//            }
//        }
//
//        return newSorts;
//    }
}
