/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eceproject2;

import java.util.Objects;

public class Complex {
    private final double re;   // the real part -- cannot be changed once defined
    private final double im;   // the imaginary part-- cannot be changed once defined

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(re, im);
       
    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(im, re);
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }
  

    // return a new Complex object whose value is the conjugate of this
    public Complex conj() {
        return new Complex(re, -im);
    }


    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }
    

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }


    // Comparison operation
    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }
    
    public Complex log() {
        return new Complex(Math.log(this.abs()),this.phase());
    }
    
    //square root method
    public Complex sqrt() {
        double r=Math.sqrt(this.abs());
        double theta=this.phase()/2;
        return new Complex(r*Math.cos(theta),r*Math.sin(theta));
    }
    
    public Complex pow(Complex b){
        Complex a=this;
        return b.times(a.log()).exp();
    }

    ///////////////////////////////////
    ///////////////// Static methods
    ///////////////////////////////////
    
    // String to Complex
    public static Complex valueOf(String exp){

	/// TO COMPLETE
      // exp = exp.substring(1, exp.length() - 1);
        String[] parts = exp.split(",");
        
        if(exp.contains(",")) {
            
       double r = Double.parseDouble(parts[0]);
       double i = Double.parseDouble(parts[1]);
	
        return new Complex(r, i); // TO MODIFY
        }
        else
        return new Complex(Double.parseDouble(exp),0);
    }

    
    // double to Complex
    public static Complex valueOf(double real){
        
       
       return new Complex(real, 0);
         // TO MODIFY
    }

} 
    


