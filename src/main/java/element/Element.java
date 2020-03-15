package element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Element {
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
     * Get an unmodifiable list of the elements that this element accepts a matching with, in decreasing order of preference.
     *
     * @return the preferences, in decreasing order
     */
    public List<Element> getPreferences() {
        return Collections.unmodifiableList(preferences);
    }

    /**
     * Set the elements that this element accepts a matching with, in decreasing order of preference.
     *
     * @param preferences the preferences, in decreasing order
     */
    public void setPreferences(Element... preferences) {
        this.preferences = Arrays.asList(preferences);
    }

    public boolean prefersMore(Element suitor, Element opponent) {
        return (preferences.indexOf(suitor) < preferences.indexOf(opponent));
    }

    @Override
    public String toString() {
        return name;
    }
}
