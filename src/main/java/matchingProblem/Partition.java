package matchingProblem;

import element.Element;

import java.util.List;

public class Partition {
    List<Element> elements;

    public Partition(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
