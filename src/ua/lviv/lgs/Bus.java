package ua.lviv.lgs;

import java.util.Objects;

public class Bus extends Transport {
    String nameOfCompany;
    int countOfSits;

    public Bus(int power, double length, String nameOfCompany, int countOfSits) {
        super(power, length);
        this.nameOfCompany = nameOfCompany;
        this.countOfSits = countOfSits;
    }


    public int getCountOfSits() {
        return countOfSits;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setCountOfSits(int countOfSits) {
        this.countOfSits = countOfSits;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return countOfSits == bus.countOfSits && Objects.equals(nameOfCompany, bus.nameOfCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCompany, countOfSits);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "nameOfCompany='" + nameOfCompany + '\'' +
                ", countOfSits=" + countOfSits +
                '}';
    }
}
