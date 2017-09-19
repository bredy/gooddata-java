
package com.gooddata.transform;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.web.util.UriTemplate;

import java.util.regex.Pattern;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Holds attribute including it's specific element
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("attributeLocatorItem")
public class AttributeLocatorItem implements LocatorItem {
    private final String attributeIdentifier;
    private final String element;

    private static final Pattern ELEMENT_IDENTIFIER_PATTERN = Pattern.compile("^\\{([a-zA-Z0-9_.]+)\\?(\\d+)\\}$");
    private static final String ELEMENTS_TEMPLATE = "{attributeUri}/elements?id={elementId}";
    private static final UriTemplate ELEMENTS_URI_TEMPLATE = new UriTemplate("/gdc/md/{projectId}/obj/{objectId}/elements?id={elementId}");

    @JsonCreator
    public AttributeLocatorItem(
            @JsonProperty("attributeIdentifier") String attributeIdentifier,
            @JsonProperty("element") String element) {
        this.attributeIdentifier = attributeIdentifier;
        this.element = element;
    }

    @JsonProperty
    public String getAttributeIdentifier() {
        return attributeIdentifier;
    }

    @JsonProperty
    public String getElement() {
        return element;
    }

//    public AttributeLocatorItem replaceIdentifiers(Map<String, String> identifiers) {
//        return new AttributeLocatorItem(
//                attributeIdentifier.cloneToStoredItem(identifiers),
//                replaceElementIdentifier(identifiers)
//        );
//    }
//
//    String replaceElementIdentifier(Map<String, String> identifiers) {
//        Matcher matcher = ELEMENT_IDENTIFIER_PATTERN.matcher(element);
//        if (!matcher.matches()) {
//            return element;
//        }
//
//        String identifier = matcher.group(1);
//        String elementId = matcher.group(2);
//
//        String attributeUri = identifiers.get(identifier);
//        if (attributeUri == null) {
//            throw new NotFoundException("Identifier: " + identifier + " not found.");
//        }
//
//        return UriUtils.expandUriTemplate(ELEMENTS_TEMPLATE, attributeUri, elementId).getTargetUriAsString();
//    }
//
//    @Override
//    public Locator toLocator(List<Grid.MetricElement> metrics) {
//        if (isFromTransformedRequest()) {
//            StoredItemDescription storedItemDescription = (StoredItemDescription) attributeIdentifier;
//            return new Locator.AttributeLocator2(new Reference(storedItemDescription.getUri()), new Reference(element));
//        } else {
//            throw new IllegalStateException("Item should be already transformed to uri based request");
//        }
//    }
//
//    private boolean isFromTransformedRequest() {
//        return attributeIdentifier instanceof StoredItemDescription && ELEMENTS_URI_TEMPLATE.matches(element);
//    }
}
