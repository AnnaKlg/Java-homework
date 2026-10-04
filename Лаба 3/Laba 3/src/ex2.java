import java.util.*;

class PrimesGenerator implements Iterator<Integer>, Iterable<Integer> {
    private final int count;
    private int generatedCount = 0;
    private int currentNumber = 2;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return generatedCount < count;
    }

    @Override
    public Integer next() {
        while (!isPrime(currentNumber)) {
            currentNumber++;
        }
        generatedCount++;
        return currentNumber++;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}


public class ex2 {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator generator = new PrimesGenerator(N);
        List<Integer> list = new ArrayList<>();

        // прямой порядкок
        System.out.print("В прямом порядке: ");
        for (int prime : generator) {
            list.add(prime);
            System.out.print(prime + " ");
        }
        System.out.println();

        //  в обратном порядке
        System.out.print("В обратном порядке: ");
        Collections.reverse(list);
        for (int prime : list) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}
