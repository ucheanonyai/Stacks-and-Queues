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
class App3
{

    public static void main(String[] args)
    {
	StackCalc mystack = new StackCalc(100); // 100 max capacity
	Queue myqueue = new Queue(100);         // 100 max capacity
	EasyIn easy = new EasyIn();
	// other variables here.........


	//////// Print Menu
	System.out.println();
	System.out.println("===============================================");
	System.out.println("==A RPN calculator for Formula Evaluations ====");
	System.out.println("===============================================");
	System.out.println("");
	    

	////////// TO COMPLETE
         while (true)
	    {
		mystack.display();   // display the content of the stack   
		System.out.print(">");
		String data = easy.readString(); // read 'data' from input keyboard
                
		
               
                if(data.equals("run")){
                   mystack.evaluatePostfix(myqueue);
                }
                else if (!data.equals("exit")){
                     myqueue.enqueue(data);
                     myqueue.display();
                     mystack.postfix2infix(myqueue);
                }
                else break;
		System.out.println("==========================================================");
	    }
        
		
	System.out.println("Thanks for using the RPN calculator");

    }
    
}

