/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eceproject2;

class Stack{
    
    //variables
    private int maxSize; // Stack capacity initialized by user
    private int top;     // top of stack
    private Object[] array; // array that holds the items
  
    // constructors
    public Stack(int maxSize) 
    {
	this.maxSize=maxSize;    // set array size
	array = new Object[maxSize];// create array 
	top = -1;                // no item yet
    }
  
    ////// Traditional methods
    public boolean isEmpty() 
    {
	return(top==-1);//true if stack is empty
    }
  
  
    public boolean isFull() 
    {
	return(top==maxSize-1);//true if stack is full
    }
  
  
    public int size() 
    {
	return(top+1);// return curent number of items
    }


    public Object peek() {
	if (!isEmpty())
	    return array[top];     //object at the top 
	else
	    throw new IllegalStateException ("Stack is empty");
    }
  
    public Object pop() {
	if (!isEmpty()){
	    top--;                 //decrement top
	    return(array[top+1]);
	}
	else
	    throw new IllegalStateException ("Stack is empty");
      
    }
  
    public void push(Object item) {
	if (!isFull()){
	    top++;             //increment top
	    array[top]= item;  //insert item 
	}
    }
    
 ////////////////////////
 ////// Additional methods
 /////////////////////////
    
    /// swap the item on top and top-1
    public void swap() {
	// to complete
        Object temp=array[top-1];
        array[top-1]=array[top];
        array[top]=temp;
    }

    //// duplicate the top item   
    public void copy() {
	//to complete
      
        array[top+1]=array[top];
        top++;
         
    }    
    
    //// display the stack
    public void display(){
        //to complete
        for(int i=0;i<=top;i++){
           // if(array[i]!=null)
            System.out.println(i +"    "+ array[i] + "   " );
        }
    }

    
    //// flush (empty) the stack
    public void flush(){
	// to complete
        top=-1;
    }       
    
    public void delete(){
        top--;
    }
}
////////////////////////////////////
