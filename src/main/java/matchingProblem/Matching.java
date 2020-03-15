package matchingProblem;

import element.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Matching {
    Map<Element, Element> suitorMatches;
    Map<Element, Element> acceptorMatches;

    public Matching() {
        this.suitorMatches = new HashMap<>();
        this.acceptorMatches = new HashMap<>();
    }

    /**
     * Create a two-directional match between a suitor and an acceptor.
     * @param suitor suitor to match
     * @param acceptor acceptor to match
     */
    public void match(Element suitor, Element acceptor) {
        suitorMatches.put(suitor, acceptor);
        acceptorMatches.put(acceptor, suitor);
    }

    /**
     * Remove a two-dimensional match between a suitor and an acceptor.
     * @param suitor suitor to unmatch
     * @param acceptor acceptor to unmatch
     */
    public void unmatch(Element suitor, Element acceptor) {
        suitorMatches.remove(suitor);
        acceptorMatches.remove(acceptor);
    }

    /**
     * Renders the matching as a comma-separated list of matches.
     *
     * @return the list of matches
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Element suitor : suitorMatches.keySet()) {
            stringJoiner.add("(" + suitor + ", " + suitorMatches.get(suitor) + ")");
        }
        return stringJoiner.toString();
    }
}
