public class Field {
    private Matrix matrix;
    private ColorGenerator colorGenerator;
    private Cell cell;

    public Field(Matrix matrix, Cell cell) {
        this.cell = cell;
        this.matrix = matrix;
        this.colorGenerator = new ColorGenerator(this.matrix);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void modifyField() {
        int[][] copy = this.colorGenerator.changeCellColors();
        this.getMatrix().updateValues(copy);
        this.cell.setValue(this.getMatrix().getValue(this.cell.getX(), this.cell.getY()));
        this.cell.countCellGreens();
    }
}


