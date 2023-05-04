/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natemoe
 */
public class EmptyStackException extends RuntimeException{  
    public EmptyStackException(){
        super("Exception was found");
    }
    public EmptyStackException(String s){
        super(s);
    }
}