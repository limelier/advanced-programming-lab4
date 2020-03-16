package matchingProblem;

public class Problem {
    Partition suitors;
    Partition acceptors;

    public Problem(Partition suitors, Partition acceptors) {
        this.suitors = suitors;
        this.acceptors = acceptors;
    }

    public Partition getSuitors() {
        return suitors;
    }

    public Partition getAcceptors() {
        return acceptors;
    }

    @Override
    public String toString() {
        return "{" + suitors + " / " + acceptors + "}";
    }
}
