import java.util.Objects;

public class MyTestingClass {
    private int number;
    private String name;

    public MyTestingClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    // Переопределённый hashCode по правилам Java
    @Override
    public int hashCode() {
        int hash = 11;
        hash = 37 * hash + number;
        hash = 37 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }

    // Переопределённый equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return number == other.number && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
