package resident;

import hospital.Hospital;

import java.util.Arrays;
import java.util.List;

public class Resident {
    private List<Hospital> preference;
    String name;

    public Resident(String name, Hospital... preference) {
        this.name = name;
        this.preference = Arrays.asList(preference);
    }

    public void setPreference(Hospital... preference) {
        this.preference = Arrays.asList(preference);
    }

    @Override
    public String toString() {
        return name;
    }
}
