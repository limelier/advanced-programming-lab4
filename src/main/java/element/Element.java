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

    public void setPreferences(List<Element> preferences) {
        this.preferences = new ArrayList<>(preferences);
    }

    public boolean prefersMore(Element subject, Element other) {
        return (preferences.indexOf(subject) < preferences.indexOf(other));
    }

    @Override
    public String toString() {
        return name;
    }
}
