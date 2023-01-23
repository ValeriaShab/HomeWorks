package main.java.com.shabatura.hw10;

import java.util.Objects;

public class Aspirant extends Student {
    String scientificWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public int getScholarship() {
        if (averageMark == 5) {
            return 200;
        }
        return 180;
    }

    public boolean equals(Aspirant aspirant){
       return (this.firstName.equals(aspirant.firstName) && this.lastName.equals(aspirant.lastName) &&
               this.group.equals(aspirant.group) && this.averageMark == aspirant.averageMark &&
               this.scientificWork.equals(aspirant.scientificWork));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group, averageMark, scientificWork);
    }
}
