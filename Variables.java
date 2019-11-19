/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eceproject2;

class Variables
{
    private String name;
    private Complex value;
    
    public Variables(String name,Complex value)
    {
	this.name=name;
	this.value=value;
    }

    public String getName(){return(name);}
    public Complex getValue(){return(value);}
    public void setValue(Complex z){value=z;}
}
