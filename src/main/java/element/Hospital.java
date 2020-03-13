package hospital;

public class Hospital implements Comparable<Hospital> {
    String name;

    public Hospital(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hospital o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
