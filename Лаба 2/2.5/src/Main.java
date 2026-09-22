public class Main {
    public static void main(String[] args) {
        Table table = new Table(2, 3); // 2 стр 3 стлб
        table.setValue(0, 0, 5);
        table.setValue(0, 1, 10);
        table.setValue(1, 2, 15);

        System.out.println("Строк: " + table.rows());
        System.out.println("Столбцов: " + table.cols());
        System.out.println("Значение в (0,1): " + table.getValue(0, 1));
        System.out.println("Среднее: " + table.average());
        System.out.println("Вся таблица:\n" + table.toString());
    }
}

class Table {
    int[][] data;

    public Table(int rows, int cols) {
        data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    public double average() {
        double sum = 0;
        int count = 0;
        for (int r = 0; r < rows(); r++) {
            for (int c = 0; c < cols(); c++) {
                sum = sum + data[r][c];
                count++;
            }
        }
        return sum / count;
    }

    public String toString() {
        String result = "";
        for (int r = 0; r < rows(); r++) {
            for (int c = 0; c < cols(); c++) {
                result = result + data[r][c] + " ";
            }
            result = result + "\n";
        }
        return result;
    }
}
