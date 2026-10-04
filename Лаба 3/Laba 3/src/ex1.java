import java.util.*;

public class ex1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = 10;
        Random random = new Random();
        // a
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("a) случайные чисела:  " + Arrays.toString(array));
        pressEnterToContinue();

        // b)
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) список List: " + list);
        pressEnterToContinue();

        // c)
        Collections.sort(list);
        System.out.println("c) по возрастанию: " + list);
        pressEnterToContinue();

        // d)
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("d) в обратном порядке: " + list);
        pressEnterToContinue();

        // e)
        Collections.shuffle(list);
        System.out.println("e) перемешанный: " + list);
        pressEnterToContinue();

        // f)
        Collections.rotate(list, 1);
        System.out.println("f) сдвиг на 1: " + list);
        pressEnterToContinue();

        // g)
        List<Integer> uniqueList = new ArrayList<>(list);
        LinkedHashSet<Integer> set = new LinkedHashSet<>(uniqueList);
        uniqueList.clear();
        uniqueList.addAll(set);
        System.out.println("g) уникальные: " + uniqueList);
        pressEnterToContinue();

        // h)
        List<Integer> duplicatesList = new ArrayList<>();
        for (Integer item : list) {
            if (Collections.frequency(list, item) > 1 && !duplicatesList.contains(item)) {
                duplicatesList.add(item);
            }
        }
        System.out.println("h) дубликаты: " + duplicatesList);
        pressEnterToContinue();

        // i)
        Integer[] newArray = list.toArray(new Integer[0]);

        System.out.println("i) массив: " + Arrays.toString(newArray));
        pressEnterToContinue();

        // j)
        System.out.println("j) Количество каждого числа:");
        Set<Integer> uniqueItems = new LinkedHashSet<>(Arrays.asList(newArray));
        for (Integer item : uniqueItems) {
            int frequency = Collections.frequency(Arrays.asList(newArray), item);
            System.out.println("   Число " + item + " встречается: " + frequency + " раз(а)");
        }
        scanner.close(); // Закрываем сканер в самом конце
    }

    // Вспом метод
    private static void pressEnterToContinue() {
        System.out.print("[Нажмите Enter для продолжения...]");
        scanner.nextLine();
        System.out.println("----------------------------------------");
    }
}
