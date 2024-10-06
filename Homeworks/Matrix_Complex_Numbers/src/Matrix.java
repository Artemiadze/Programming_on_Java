public class Matrix {
    private final Complex[][] matrix;
    private final int row;
    private final int col;

    public Matrix(int rows, int cols) {
        matrix = new Complex[rows][cols];
        row = rows;
        col = cols;
    }

    public void setElement(int row, int col, Complex num) {
        matrix[row][col] = num;
    }

    public Complex getElement(int row, int col) {
        return matrix[row][col];
    }


    //сумма матриц
    public Matrix sum(Matrix other) {
        Matrix result = new Matrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Complex sum = matrix[i][j].sum(other.getElement(i, j));
                result.setElement(i, j, sum);
            }
        }
        return result;
    }


    //разность матриц
    public Matrix diff(Matrix other) {
        Matrix result = new Matrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Complex diff_ = matrix[i][j].diff(other.getElement(i, j));
                result.setElement(i, j, diff_);
            }
        }
        return result;
    }


    //транспонирование матрицы
    public Matrix transposition() {
        Matrix newMatrix = new Matrix(this.col, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return newMatrix;
    }


    // произведение матриц
    public Matrix multiMatrix(Matrix other) {
        if (this.col == other.row) {
            Matrix result = new Matrix(this.row, other.col);

            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < other.col; j++) {
                    Complex sum_numbers = new Complex();
                    for (int k = 0; k < this.col; k++) {
                        Complex product = matrix[i][k].mult(other.getElement(k, j));
                        sum_numbers = sum_numbers.sum(product);
                    }
                    result.setElement(i, j, sum_numbers);
                }
            }
            return result;
        }
        System.out.print("You can't multiply these matrix's and system return the identity matrix\n");
        return new Matrix(1, 1);
    }


    // вычисление минора
    public Matrix Minor(Matrix example, int index)
    {
        int index_1 = 0;
        Matrix minor_matrix = new Matrix(example.row - 1, example.row - 1);

        for (int i = 1; i < example.row; i++) {
            int index_2 = 0;
            for (int j = 0; j < example.col; j++) {
                if (j != index) {
                    minor_matrix.setElement(index_1,index_2,example.matrix[i][j]);
                    index_2++;
                }
            }
            index_1++;
        }
        return minor_matrix;
    }


    // вычисление детерминанта матрицы
    public Complex determinant()
    {
        if (this.row != this.col) {
            System.out.println("You can't calculate determinant and system return the zero");
            return new Complex();
        }
        if (this.row == 1) {
            return this.matrix[0][0];
        }

        //операция вычисления детерминанта
        Complex result = new Complex();
        for (int i = 0; i < this.col; i++) {
            Complex element_a_for_matrix = new Complex();
            Matrix minor_matrix = Minor(this, i);
            element_a_for_matrix = minor_matrix.determinant().mult(this.matrix[0][i]);
            if (i % 2 == 0) {
                result = result.sum(element_a_for_matrix);
            } else {
                Complex tmp = new Complex(-1, 0);
                result = result.sum(element_a_for_matrix.mult(tmp));
            }
        }
        return result;
    }


    //печать матрицы
    public void print() {
        for (Complex[] complexes : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                complexes[j].print();
            }
            System.out.println();
        }
    }
}
