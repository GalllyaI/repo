public class Cell {
    private int x;
    private int y;
    private int value;
    private int count=0;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.setValue(value);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void countCellGreens() {
        if(this.getValue() == 1){
            count++;
        }
    }
}
