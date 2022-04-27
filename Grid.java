public class Grid {
    int rows = 20;
    int columns = 20;

    public Grid() {
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = 0;
            }
        }
    }

}
