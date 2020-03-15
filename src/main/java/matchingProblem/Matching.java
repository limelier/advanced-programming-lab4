package matchingProblem;

import element.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Matching {
    Map<Element, Element> matches;

    public Matching() {
        this.matches = new HashMap<>();
    }

    public void match(Element from, Element to) {
        matches.put(from, to);
    }

    /**
     * Renders the matching as a comma-separated list of matches.
     *
     * @return the list of matches
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Element key : matches.keySet()) {
            stringJoiner.add("(" + key + ", " + matches.get(key) + ")");
        }
        return stringJoiner.toString();
    }
}
