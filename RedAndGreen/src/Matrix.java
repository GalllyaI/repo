import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        this.matrix = new int[rows][cols];
    }

    public void fillRow(int row, String input) {
       this.matrix[row] =  Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRowLength(int r) {
        return this.getMatrix()[r].length;
    }
    public int getLength() {
        return this.getMatrix().length;
    }

    public int getValue(int row, int col){
       return this.matrix[row][col];
    }

    public void setValue(int row, int col, int value){
        this.matrix[row][col] = value;
    }

    public void updateValues(int [][] values){
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getRowLength(0) ; j++) {
                this.setValue(i,j,values[i][j]);
            }
        }
    }
}
