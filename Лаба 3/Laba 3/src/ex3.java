import java.util.*;
class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    @Override
    public int compareTo(Human o) {
        int res = this.firstName.compareTo(o.firstName);
        if (res != 0) return res;
        res = this.lastName.compareTo(o.lastName);
        if (res != 0) return res;
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}

public class ex3 {
    public static void main(String[] args) {
        // a)
        List<Human> list = new ArrayList<>();
        list.add(new Human("Иван", "Петров", 25));
        list.add(new Human("Анна", "Иванова", 20));
        list.add(new Human("Борис", "Смирнов", 30));
        list.add(new Human("Иван", "Алексеев", 22)); // Дубликат имени для проверки сортировок

        System.out.println("Список: " + list);
        // b)
        Set<Human> hashSet = new HashSet<>(list);
        // c)
        System.out.println("c) HashSet: " + hashSet);

        // d)
        Set<Human> linkedHashSet = new LinkedHashSet<>(list);
        // e)
        System.out.println("e) LinkedHashSet: " + linkedHashSet);

        // f)
        Set<Human> treeSetDefault = new TreeSet<>(list);
        // g)
        System.out.println("g) TreeSet : " + treeSetDefault);

        // h)
        // i)
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(list);
        // j)
        System.out.println("j) TreeSet (по Фамилии): " + treeSetByLastName);

        // k)
        // l)
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(list);
        // m)
        System.out.println("m) TreeSet (по Возрасту): " + treeSetByAge);
    }
}


