package hospital;

import resident.Resident;

import java.util.Arrays;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    List<Resident> preference;
    String name;

    public Hospital(String name, Resident ...preference) {
        this.preference = Arrays.asList(preference);
        this.name = name;
    }

    public void setPreference(Resident ...preference) {
        this.preference = Arrays.asList(preference);
    }
    
    @Override
    public int compareTo(Hospital o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return name.compareTo(o.name);
    }
}
