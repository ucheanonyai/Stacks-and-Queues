/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eceproject2;

import java.awt.Color;
import java.lang.*;
import java.io.*;
import java.util.*;

//////////////////////////////////////////////////////////
//////// Extend the class Stack with Operation on complex
//////////////////////////////////////////////////////////
class StackCalc extends Stack{

    //////// variables (to be completed if needed)
    private Variables array[] = new Variables[300];
    private Variables obj;
    String name;
    Complex value;
    private int stacksize=0;
    
    Queue myqueue;
    EasyIn easy;
    int queuesize=0;
    String data;
    Scanner sc=new Scanner(System.in);
   

    /////////////// Constructor
    public StackCalc(int maxSize){
	super(maxSize);
    } 

    
    /////////////////////////////////  
    ////////////// Operations
    /////////////////////////////////
    
    ///// addition  
    public void add(){
	if (size()>=2){ 
	    Complex z1=(Complex) pop();
	    Complex z2=(Complex) pop();
	    push(z1.plus(z2));
	}
    }

  	
    //// return pi number
    public void pi(){
	if (!isFull()) push(new Complex(Math.PI,0));
    }
    
    //subtraction
    public void subtraction(){
        if (size()>=2){ 
	    Complex z1=(Complex) pop();
	    Complex z2=(Complex) pop();
	    push(z1.minus(z2));
	}
    }
    
    //division
    public void division(){
        if (size()>=2){ 
	    Complex z1=(Complex) pop();
	    Complex z2=(Complex) pop();
	    push(z2.divides(z1));
	}
    }
    
    //multiply
    public void multiply(){
        if (size()>=2){ 
	    Complex z1=(Complex) pop();
	    Complex z2=(Complex) pop();
	    push(z1.times(z2));
	}
    }
    
    public void power(){
        if (size()>=2){ 
         
	    Complex z1=(Complex) pop();
	    Complex z2=(Complex) pop();
            
           
            push(z1.pow(z2));
        }
    }
    
    //create imaginary number
    public void imaginary(){
      push(new Complex(0,1));  
    }
    
    public void exponential(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.exp());

    }
    
    public void sin(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.sin());

    }
    
    public void cos(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.cos());
        
    }
    
    public void tan(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.tan());

    }
    
    public void log(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.log());

    }
    
    public void abs(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.valueOf(z1.abs()));

    }
    
    public void sqrt(){
        Complex z1=(Complex) pop();
        //if(z1.im()!=0){
            push(z1.sqrt());

    }
    
    public void conj(){
        Complex z1=(Complex) pop();
        push(z1.conj());
    }
    
    

    
    ////// TO COMPLETE

   

    //////////////////////////////////////////
    //// Selection- RPN Operations on Stack
    /////////////////////////////////////////
    public void rpnCommand(String data){    
        
        //to accept variables
        this.data=data;
	//boolean putinqueue=true;
	if(data.indexOf("=")!=-1){
        String[] parts = data.split("=");
        
        if(data.contains("=")) {
            
       String name = parts[0];
       
       value=value.valueOf(parts[1]);
       
	
       
            insertVars(name, value);
            
	        }
        }
        
        
        else{
            switch(data)
	    {
	        case("+"): 
		 add(); 
		 break;
                
                case("pi"):
                 pi();
                 break;
                
                case("-"):
                 subtraction();
                 break;
                
                case("/"):
                    division();
                    break;
                    
                case("*"):
                    multiply();
                    break;
                
                case("^"):
                    power();
                    break;
                    
                case("i"):
                    imaginary();
                    break;
                    
                case("e"):
                    exponential();
                    break;
                    
                 case("copy"):
                     copy();
                     break;
                     
                case("delete"):
                    delete();
                    break;
                    
                case("flush"):
                    flush();
                    break;
                    
                case("swap"):
                    swap();
                    break;
                    
                case("sqrt"):
                    sqrt();
                    //Complex.sqrt();
                    break;
                    
                case("cos"):
                    cos();
                    break;
                    
                case("sin"):
                    sin();
                    break;
                    
                case("tan"):
                    tan();
                    break;
                    
                case("abs"):
                    abs();
                    break;
                   
                case("log"):
                    log();
                    break;
                
                case("list"):
                    displayVars();
                    break;
                    
                case("reset"):
                    resetVars();
                    break;
                    
                case("conj"):
                    conj();
                    break;

             
		////// TO COMPLETE
	 
	    default: // data is not an operator, it is a complex number (or variable definition for App2,3,4)
		
		////// TO COMPLETE
                //check if variable is letter or number
               if (Character.isLetter(data.charAt(0))){
                   if(displayVariable(data)==null){
                   System.out.println("Enter/Update value for variables (if any)... press enter to end:");
                   data=sc.next();
                   rpnCommand(data);
                   push(value);
                   }
               }
               else 
		 push(Complex.valueOf(data));

                ////// TO COMPLETE
		
		break;
	      
	    }

        }
	    
    }
        

    //////////////////////////////////////////
    //// OTHER METHODS
    /////////////////////////////////////////    
    
    //insert variables
    public void insertVars(String name,Complex value){
        //boolean existing=false;
        Variables newitem=new Variables(name, value);
        int i;
        
        for(i=0;i<stacksize;i++){
           
           if(newitem.getName().equals(array[i].getName())){
           array[i].setValue(newitem.getValue());
           break;
         //  existing=true;
            }
        }
        if (i == stacksize) {
           array[stacksize]=new Variables(name, value);
           stacksize++;
        }
          
       
    }
    
    //display variables in array
    public void displayVars(){
        if(array!=null){
        System.out.println("Variable list:");
        for(int i=0;i<stacksize;i++){
            System.out.println(array[i].getName() + " = " +array[i].getValue());
        }
        }
        else
            System.out.println("No Variable in list!");
    }
    
    //make array empty
    public void resetVars(){
        
            array=null;
        
    }
    //display value of valuables
    public Complex displayVariable(String data){
        Complex variable=null;
                   for(int i=0;i<stacksize;i++){
                    if(array[i].getName().equals(data)){
                        variable=array[i].getValue();
                        push(array[i].getValue());
                        break;
                    }
                }
                    return variable;
    }
    
   //solve postfix
    public Complex evaluatePostfix(Queue myQueue){
        while(!myQueue.isEmpty()){
            this.rpnCommand(myQueue.dequeue().toString());
        }
        return (Complex)this.peek();
    }
    

    ////// TO COMPLETE

//     public Complex evaluatePostfix(Queue myqueue){
//         
//        Queue queue2= new Queue(myqueue);
//        Queue queue3=new Queue(myqueue.size());
//        for(int i=0;i<myqueue.size();i++){
//            String a= (String) queue2.dequeue();
////            System.out.println((Double)queue3.dequeue());
//            if(isOperator(a)){
//                String c= (String) queue3.dequeue();
//                String b= (String) queue3.dequeue();
//               // double b= Double.parseDouble(queue3.dequeue()+"");
//                //double c= Double.parseDouble(queue3.dequeue()+"");
//                double result = 0;
//                rpnCommand(b);
//                rpnCommand(c);
//                rpnCommand(a);
//
//                queue3.enqueue(result);
//            }
//            
//            if(trigonometry(a)){
//                 String b= (String) queue3.dequeue();
//                 rpnCommand(b);
//                 rpnCommand(a);
//                 
//                 
//            }
//            else
//                  queue3.enqueue(a);
//        }
//
//             System.out.println(peek());
//             //System.out.println((Double)queue3.peekFront());
//         
//            //return new Complex((Double)queue3.peekFront(),0);
//              return (Complex)peek();
//         }

    //convert postfix to infix
    public void postfix2infix(Queue myqueue){
        Queue queue2= new Queue(myqueue);
        Queue queue3=new Queue(myqueue.size());
        for(int i=0;i<myqueue.size();i++){
            String a= (String) queue2.dequeue();
            
            if(isOperator(a)){
                String c= (String) queue3.dequeue();
                String b= (String) queue3.dequeue();
                queue3.enqueue("("+b+a+c+")");
     
            }
            
            else if(trigonometry(a) || commands(a)){
                String b= (String) queue3.dequeue();
                queue3.enqueue(a+"("+b+")");
            }
            
            else if(a.equals("abs")){
                String b= (String) queue3.dequeue();
                queue3.enqueue("|"+b+"|");
            }
            else
                  queue3.enqueue(a);
        }
        System.out.print("Infix: ");
        for(int i=0;i<queue3.size();i++){
        System.out.print( queue3.dequeue());
        }
        System.out.println();
        }
    
    public boolean isOperator(String c){
        if(c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*") || c.equals("^")){
            return true;
        }
        return false;
    }
    
    public boolean trigonometry(String c){
        if(c.equals("cos") || c.equals("sin") || c.equals("tan")){
            return true;
        }
        return false;
    }
    
    
    public boolean commands(String c){
        if(c.equals("sqrt") || c.equals("log")  || c.equals("conj")  ){
            return true;
        }
        return false;
    }
    
    
    //plot graph method
    public void plot(Queue myqueue){
        
        System.out.println("input lx");
        double lx=sc.nextDouble();
        System.out.println("input Lx");
        double Lx=sc.nextDouble();
        System.out.println("input nbp");
        int nbp=sc.nextInt();
        double range=Lx-lx;
        double[]x=new double[nbp];
        double [] y=new double[nbp];
        int smax=600;
        double dx=range/nbp;
        
        
        System.out.println("Enter values of: lx Lx nbp " + lx +" "+ Lx +" "+ nbp);
        
        StdDraw.setCanvasSize(smax,smax);
        StdDraw.setXscale(lx, Lx);
        
        StdDraw.setPenColor(StdDraw.BLACK);
        
        StdDraw.setPenRadius(0.01);
        
        for(int i=0;i<nbp;i++){
           // System.out.println(myqueue);
            Queue temporary=new Queue(myqueue);
            x[i]=lx;
            rpnCommand("x="+x[i]);
            lx=lx+dx;
            y[i]=evaluatePostfix(temporary).re();
            
            StdDraw.point(x[i], y[i]);
        }
       
        double max=y[0];
        double min=y[0];
        
            for(int j=0;j<nbp;j++){
            if(max<y[j]){
                max=y[j];
            }
            else if(min>y[j]){
                min=y[j];
            }
            
            StdDraw.setYscale(min, max);
                }
            
            
        }
    
    


    
}

    
	



