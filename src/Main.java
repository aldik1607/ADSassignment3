import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);
        Random random = new Random();

        // Добавляем 10,000 элементов в хеш-таблицу
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Name" + random.nextInt(10000);

            MyTestingClass key = new MyTestingClass(id, name);
            Student student = new Student("Student" + i, random.nextInt(1000));

            table.put(key, student);
        }

        // Выводим количество элементов в каждом бакете
        for (int i = 0; i < 100; i++) {
            int bucketSize = table.bucketSize(i);
            System.out.println("Bucket #" + i + " contains " + bucketSize + " elements.");
        }
    }
}
