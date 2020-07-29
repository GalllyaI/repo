import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input  = scan.nextLine();
        int[] dimensions = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        Matrix matrix = new Matrix(rows,cols);

        for (int i = 0; i < rows ; i++) {
            input  = scan.nextLine();
            matrix.fillRow(i,input);
        }

        input = scan.nextLine();
        int[] data = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
        int cellX = data[1];
        int cellY = data[0];
        int repeat = data[2];
        Cell cell = new Cell(cellX, cellY, matrix.getValue(cellX,cellY));
        Field field = new Field(matrix, cell);

        for (int k = 0; k < repeat ; k++) {
            field.modifyField();
        }
       System.out.println(cell.getCount());
    }
}

