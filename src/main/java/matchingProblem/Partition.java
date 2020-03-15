package matchingProblem;

import element.Element;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Partition implements Iterable<Element> {
    List<Element> elements;

    public Partition(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Element element : elements) {
            joiner.add(element + " - " + element.getPreferences());
        }
        return joiner.toString();
    }

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }
}
