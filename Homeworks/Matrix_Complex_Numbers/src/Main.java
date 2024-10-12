public class Main {
    public static void main(String[] args) {
        //создаём два комплексных числа для проверки работы класса комп. чисел
        Complex complex1 = new Complex(5, 0);
        Complex complex2 = new Complex(5, 4);

        //их произведение
        Complex complex3 = complex1.mult(complex2);
        System.out.print("complex1 * complex2 = ");
        complex3.print();
        System.out.println(); //пустая строка для эстетики

        //их деление
        Complex complex4 = complex1.div(complex2);
        System.out.print("complex1 / complex2 = ");
        complex4.print();
        System.out.println(); //пустая строка для эстетики

        //создаём две матрицы 2х2 и забиваем её числами
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setElement(0, 0, new Complex(1, 2));
        matrix1.setElement(0, 1, new Complex(3, 4));
        matrix1.setElement(1, 0, new Complex(5, 6));
        matrix1.setElement(1, 1, new Complex(7, 8));

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setElement(0, 0, new Complex(2, 3));
        matrix2.setElement(0, 1, new Complex(4, 5));
        matrix2.setElement(1, 0, new Complex(6, 7));
        matrix2.setElement(1, 1, new Complex(8, 9));
        System.out.println(); //пустая строка для эстетики

        //печать матриц:
        System.out.print("Matrix1\n");
        matrix1.print();
        System.out.println(); //пустая строка для эстетики

        System.out.print("Matrix2\n");
        matrix2.print();
        System.out.println(); //пустая строка для эстетики

        //сумма матриц
        System.out.print("Matrix1 + Matrix2:\n");
        Matrix sum = matrix1.sum(matrix2);
        sum.print();
        System.out.println(); //пустая строка для эстетики

        //разница матриц
        System.out.print("Matrix1 - Matrix2:\n");
        Matrix diff_ = matrix1.diff(matrix2);
        diff_.print();
        System.out.println(); //пустая строка для эстетики

        //Транспонировал первую матрицу
        System.out.print("Matrix1 ^ T:\n");
        Matrix transposition_matrix1 = matrix1.transposition();
        transposition_matrix1.print();
        System.out.println(); //пустая строка для эстетики

        //перемножил эти матрицы
        System.out.print("Matrix1 * Matrix2:\n");
        Matrix matrix_multi = matrix1.multiMatrix(matrix2);
        matrix_multi.print();
        System.out.println(); //пустая строка для эстетики

        //находим детерминант первой матрицы
        System.out.print("det(Matrix1):\n");
        Complex deter_matrix1 = matrix1.determinant();
        deter_matrix1.print();
        System.out.println(); //пустая строка для эстетики


        //создание матрицы 3х3
        Matrix matrix3x3 = new Matrix(3, 3);
        matrix3x3.setElement(0, 0, new Complex(1, 2));
        matrix3x3.setElement(0, 1, new Complex(3, 4));
        matrix3x3.setElement(0, 2, new Complex(5, 6));
        matrix3x3.setElement(1, 0, new Complex(5, 4));
        matrix3x3.setElement(1, 1, new Complex(6, 7));
        matrix3x3.setElement(1, 2, new Complex(8, 7));
        matrix3x3.setElement(2, 0, new Complex(3, 2));
        matrix3x3.setElement(2, 1, new Complex(2, 1));
        matrix3x3.setElement(2, 2, new Complex(3, 2));


        System.out.print("Matrix3x3\n");
        matrix3x3.print();

        //Транспонировал  матрицу 3x3
        System.out.println(); //пустая строка для эстетики
        System.out.print("Matrix3x3 ^ T:\n");
        Matrix transposition_matrix3x3 = matrix3x3.transposition();
        transposition_matrix3x3.print();
        System.out.println(); //пустая строка для эстетики

        //находим детерминант  матрицы 3x3
        System.out.print("det(Matrix3x3):\n");
        Complex deter_matrix3x3 = matrix3x3.determinant();
        deter_matrix3x3.print();
        System.out.println(); //пустая строка для эстетики
    }
}