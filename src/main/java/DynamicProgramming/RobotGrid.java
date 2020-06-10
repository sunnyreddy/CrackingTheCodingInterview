package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class RobotGrid {
    public List<Point> robotPath(int[][] grid) {
        List<Point> path = new ArrayList<>();

        int row = grid.length, col = grid[0].length;
        if(getPath(grid, row, col, path)) return path;
        return null;
    }

    public boolean getPath(int[][] grid, int row, int col, List<Point> path) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0)
            return false;
        if(row==grid.length-1 && col==grid[0].length-1) return true;

        boolean isAtStart = (row == 0) && (col == 0);

        if(isAtStart || getPath(grid, row+1, col, path) || getPath(grid, row, col+1, path)) {
            Point p = new Point(row,col);
            path.add(p);
            return true;
        }
        return false;
    }
}
