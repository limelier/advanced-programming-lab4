package element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Element {
    String name;
    List<Element> preferences;

    public Element(String name) {
        this.name = name;
        preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Set the elements that this element accepts a matching with, in decreasing order of preference.
     * @param preferences the preferences, in decreasing order
     */
    public void setPreferences(Element... preferences) {
        this.preferences = Arrays.asList(preferences);
    }

    @Override
    public String toString() {
        return name;
    }
}
