/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natemoe
 * @param <E>
 */
public class DNode_Generic <E>{
    protected E element;
    protected DNode_Generic<E>next;
    protected DNode_Generic<E>prev;
    protected DNode_Generic<E> TOS;
    
    
    protected DNode_Generic(E e){
        this.element=e;
        next = null;
        prev = null;
    }
}
