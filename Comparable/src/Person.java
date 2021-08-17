import java.util.ArrayList;
import java.util.Collections;

public class Person implements Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson){
        if(this.age == otherPerson.age) return this.name.compareTo(otherPerson.name );
        return Integer.compare(this.age, otherPerson.age);
    }

    @Override
    public String toString(){
        return "Name: " + name + " Age: " + age;
    }

    public static void main(String[] args) {

        Person p1 = new Person("Alperen", 24);
        Person p2 = new Person("Sukru", 25);
        Person p3 = new Person("Mevlut", 21);
        Person p4 = new Person("Mustafa", 25);
        Person p5 = new Person("Ramazan", 26);
        Person p6 = new Person("Ahmet", 26);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);

        Collections.sort(personList);

        for(Person p : personList) System.out.println(p);
    }

}
