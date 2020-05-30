package Array_and_String;

public class RotateMatrix {
    public int[][] rotateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length==0) return matrix;
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        this.printMatrix(matrix);
        for(int i=0; i<n; i++) {
            int s = 0;
            int e = n-1;
            while(s < e) {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] t1 = new int[3][3];
        int p = 1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                t1[i][j] = p++;
            }
        }
        rm.printMatrix(t1);
        t1 = rm.rotateMatrix(t1);
        rm.printMatrix(t1);
    }
}
