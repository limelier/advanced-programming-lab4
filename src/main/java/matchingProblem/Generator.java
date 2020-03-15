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
