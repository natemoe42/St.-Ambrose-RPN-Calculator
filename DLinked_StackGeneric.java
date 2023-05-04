/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natemoe
 * @param <E>
 */
public class DLinked_StackGeneric<E> implements StackGeneric_Interface<E>{
    private int size;
    private DNode_Generic<E> tos;
    
    public DLinked_StackGeneric(){
        tos =null;
        size = 0;
    }

    @Override
    public void push(E element) {
    DNode_Generic<E> temp = new DNode_Generic<>(element);
    if (tos == null) {
        tos = temp;
    } else {
        tos.next = temp;
        temp.prev = tos;
        tos = temp;
    }
    size++;
}

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E result = tos.element;
        tos = tos.prev;
        if(tos==null){}
        else{
            tos.next.prev = null;
            tos.next = null;
        }
        size--;
        return result;
    }   
    

    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tos.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        tos = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String S = "TOS [";
        boolean first = true;
        DNode_Generic<E> current = tos;
        for(int i = 0;i<size;i++){
            if(first){
            S+= current.element;
            first = false;
            }
            else{
                S+=", " + current.element;
            }
            current = current.prev;
        }
        S+="]";
        return S;
    }
}
