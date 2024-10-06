public class Complex {
    private double re;
    private double im;

    public Complex(double reValue, double imValue)
    {
        this.re = reValue;
        this.im = imValue;
    }

    //создает дефолтно нулевое комплексное число
    public Complex()
    {
        re = 0.0;
        im = 0.0;
    }

    public double getRe()
    {
        return this.re;
    }

    public double getIm()
    {
        return this.im;
    }

    public void set_Re(double reValue)
    {
        this.re = reValue;
    }

    public void set_Im(double imValue)
    {
        this.im = imValue;
    }

    public Complex sum(Complex other)     // сумма комплексных чисел
    {
        return new Complex(this.re + other.re, this.im + other.im);
    }


    // разность комплексных чисел
    public Complex diff(Complex other)
    {
        return new Complex(this.re - other.re, this.im - other.im);
    }


    // произведение комплексных чисел
    public Complex mult(Complex other)
    {
        return new Complex(this.re * other.re + this.im * other.im * (-1),
                this.re * other.im + this.im * other.re);
    }


    // частное комплексных чисел
    public Complex div(Complex other)     // частное комплексных чисел
    {
        Complex result_div = new Complex(other.re, (-1) * other.im);
        Complex result = this.mult(result_div);
        Complex tmpDiv = other.mult(result_div);
        result.re /= tmpDiv.re;
        result.im /= tmpDiv.re;
        return result;
    }

    // вывод комплексного числа/комплексных чисел
    public void print()
    {
        if (this.re == 0){
            if (this.im >= 0) {
                System.out.printf("%.1f * i ; ", this.im);
            } else {
                System.out.printf("-%.1f * i ; ", (-1) * this.im);
            }
        }
        else {
            if (this.im > 0) {
                System.out.printf("%.1f + %.1f * i ; ", this.re, this.im);
            } else if (this.im < 0){
                System.out.printf("%.1f - %.1f * i ; ", this.re, (-1) * this.im);
            } else {
                System.out.printf("%.1f; ", this.re);
            }
        }
    }
}
