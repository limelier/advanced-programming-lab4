package matchingProblem;


import com.github.javafaker.Faker;
import element.Element;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    Faker faker;

    public Generator() {
        this.faker = new Faker();
    }

    /**
     * Generate a matching problem with the given number of elements in both partitions.
     * <p>
     * The generator uses a fake name generator to make the first partition a list of first names, and the second, a list of last names. The preferences of each item are a shuffled list of the other items.
     *
     * @param n the number of suitors and acceptors
     * @return the generated problem
     */
    public Problem generate(int n) {
        List<Element> suitors = IntStream.range(0, n)
                .mapToObj(i -> new Element(faker.name().firstName()))
                .collect(Collectors.toList());
        List<Element> acceptors = IntStream.range(0, n)
                .mapToObj(i -> new Element(faker.name().lastName()))
                .collect(Collectors.toList());

        for (Element suitor : suitors) {
            Collections.shuffle(acceptors);
            suitor.setPreferences(acceptors);
        }

        for (Element acceptor : acceptors) {
            Collections.shuffle(suitors);
            acceptor.setPreferences(suitors);
        }

        return new Problem(new Partition(suitors), new Partition(acceptors));
    }
}
