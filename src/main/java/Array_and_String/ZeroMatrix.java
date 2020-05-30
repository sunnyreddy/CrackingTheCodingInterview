package Array_and_String;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
    public int[][] zeroMatrix(int[][] matrix) {
        boolean firstColZero = false;
        int nrows = matrix.length, ncols = matrix[0].length;

        for(int i=0; i<nrows; i++) {
            // explicitely checking for col one
            if(matrix[i][0] == 0)
                firstColZero = true;

            for(int j=1; j<ncols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<nrows; i++) {
            for(int j=1; j<ncols; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j=0; j<ncols; j++) {
                matrix[0][j] = 0;
            }
        }


        if (firstColZero) {
            for (int i = 0; i < nrows; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
