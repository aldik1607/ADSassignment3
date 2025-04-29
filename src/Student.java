public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры (по желанию можно добавить сеттеры)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Правильное переопределение метода toString()
    @Override
    public String toString() {
        return name + " " + age;
    }
}
