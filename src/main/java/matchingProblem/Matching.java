package matchingProblem;

import element.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Matching {
    Map<Element, Element> matchesFromTo;
    Map<Element, Element> matchesToFrom;

    public Matching() {
        this.matchesFromTo = new HashMap<>();
        this.matchesToFrom = new HashMap<>();
    }

    /**
     * Create a two-directional match between the two elements.
     * @param from element to match from
     * @param to element to match to
     */
    public void match(Element from, Element to) {
        matchesFromTo.put(from, to);
        matchesToFrom.put(to, from);
    }

    /**
     * Remove a two-dimensional match between two elements.
     * @param from element the match starts from
     * @param to element the match ends at
     */
    public void unmatch(Element from, Element to) {
        matchesFromTo.remove(from);
        matchesToFrom.remove(to);
    }

    /**
     * Renders the matching as a comma-separated list of matches.
     *
     * @return the list of matches
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Element key : matchesFromTo.keySet()) {
            stringJoiner.add("(" + key + ", " + matchesFromTo.get(key) + ")");
        }
        return stringJoiner.toString();
    }
}
