/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eceproject2;

import java.lang.*;
import java.io.*;
import java.util.*;


//////////////////////////////////////
///////   application class
/////////////////////////////////////
class App4
{

    public static void main(String[] args)
    {
	// to complete
        StackCalc mystack = new StackCalc(100); // 100 max capacity
	Queue myqueue = new Queue(100);         // 100 max capacity
	EasyIn easy = new EasyIn();

	//////// Print Menu
	System.out.println();
	System.out.println("===============================================");
	System.out.println("==A RPN calculator for Function Plotting   ====");
	System.out.println("===============================================");
	System.out.println("");
	    
	/// To Complete
        while (true)
	    {
		mystack.display();   // display the content of the stack   
		System.out.print(">");
		String data = easy.readString(); // read 'data' from input keyboard
                
		
                

                if(data.equals("run")){
                    
                }
                else if(data.equals("plot")){
                    mystack.plot(myqueue);
                }
                else if (!data.equals("exit")){
                    myqueue.enqueue(data); //enqueue data
                    myqueue.display();   //display stack
                    mystack.postfix2infix(myqueue); //convert postfix to infix
                }
                
                else break;            
		System.out.println("==========================================================");
	    }
        //mystack.evaluatePostfix(myqueue);
		
	
}
}

