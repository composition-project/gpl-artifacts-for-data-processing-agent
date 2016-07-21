package eu.linksmart.ceml.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import eu.linksmart.api.event.ceml.data.ClassesDescriptor;
import weka.core.Attribute;

import java.util.ArrayList;

/**
 * Created by José Ángel Carvajal on 21.07.2016 a researcher of Fraunhofer FIT.
 */
public class ClassesAttributeStructure extends  AttributeStructure {
    @JsonPropertyDescription("Define the name of the attribute or of the attribute vector name (base name of all members of the vector")
    @JsonProperty(value = "AttributesClasses")
    protected ArrayList<String> attributesClasses=null;

    public ClassesAttributeStructure(String name, Class clazz, boolean isTarget) throws Exception {
        super(name, clazz, isTarget);
    }

    public ClassesAttributeStructure(ClassesDescriptor descriptor) throws Exception {
        super(descriptor);

    }
    public ArrayList<String> getAttributesClasses() {
        return attributesClasses;
    }

    public void setAttributesClasses(ArrayList<String> attributesClasses) {
        this.attributesClasses = attributesClasses;
    }

    @Override
    public ClassesDescriptor build() throws Exception {
        super.build();
        if (attributesClasses != null)
            if (!attributesClasses.isEmpty()) {
                attribute = new Attribute(name, attributesClasses);

            }
        return this;
    }


}
