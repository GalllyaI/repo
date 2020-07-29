public class ColorGenerator {
    private Matrix matrix;

    public ColorGenerator(Matrix matrix) {
        this.matrix = matrix;

    }

    private int[][] getCoordinatesToCheck(int x, int y) {
        return new int[][]{
                {x-1,y},
                {x+1,y},
                {x,y-1},
                {x,y+1},
                {x-1,y-1},
                {x-1,y+1},
                {x+1,y-1},
                {x+1,y+1},
        };
    }

    private int countGreenNeighbours(int x, int y) {
        int greens = 0;
        int[][] cellsToCheck = this.getCoordinatesToCheck(x, y);

        for (int[] ints : cellsToCheck) {
            int r = ints[0];
            int c = ints[1];

            if (isInField(r,c) && this.matrix.getValue(r,c) == 1) {
                greens++;
            }
        }
        return greens;
    }

    private boolean isInField(int x, int y) {
        return x >= 0 && y >= 0 && x < this.matrix.getLength() && y < this.matrix.getRowLength(0);
    }

    public int [][] changeCellColors() {
        int[][] copy = new int[this.matrix.getLength()][this.matrix.getRowLength(0)];
        for (int i = 0; i < copy.length ; i++) {
            for (int j = 0; j <copy[0].length; j++) {
                int greens = countGreenNeighbours(i, j);
                if(this.matrix.getValue(i,j) == 0){
                    if(greens == 3 || greens == 6){
                        copy[i][j] = 1;
                    }
                }
                if(this.matrix.getValue(i,j) == 1){
                    if(greens == 2 || greens == 3 || greens == 6){
                       copy[i][j] = 1;
                    }
                    else{
                        copy[i][j] = 0;
                    }
                }
            }
        }
        return copy;
    }
}
