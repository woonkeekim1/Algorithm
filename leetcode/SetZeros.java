class SetZeros {
    public void setZeroes(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int col0 = 1;
        for(int i = 0; i < N; i++) {
            if(matrix[i][0] == 0) {
                col0 = 0;
            }
            for(int j = 1; j < M; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = N-1; i >= 0; i--) {
            for(int j = M - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
