package matchingProblem;

public class Problem {
    Partition partition1;
    Partition partition2;

    public Problem(Partition partition1, Partition partition2) {
        this.partition1 = partition1;
        this.partition2 = partition2;
    }

    @Override
    public String toString() {
        return "{" + partition1 + " / " + partition2 + "}";
    }
}
