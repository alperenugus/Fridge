import java.util.Comparator;

public class Main {


    public static void main(String[] args) {

        CustomPriorityQueue<Person> customPriorityQueue = new CustomPriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        customPriorityQueue.add(new Person("Alperen", "Ugus", 25));
        customPriorityQueue.add(new Person("Murat", "Tuter", 27));
        customPriorityQueue.add(new Person("Ramazan", "Korucu", 26));

        customPriorityQueue.printQueue();

    }

}
