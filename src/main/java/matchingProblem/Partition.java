package matchingProblem;

import element.Element;

import java.util.Iterator;
import java.util.List;

public class Partition implements Iterable<Element> {
    List<Element> elements;

    public Partition(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }
}
