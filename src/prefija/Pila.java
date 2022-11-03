/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefija;

/**
 *
 * @author RAGAd
 */
public class Pila {

    Nodo top;
    Nodo bottom;

    public Pila() {
        this.top = null;
        this.bottom = null;
    }

    public boolean isEmpty() {
        return bottom == null;
    }

    public void push(Object value) {
        if (isEmpty()) {
            bottom = new Nodo(value);
            top = bottom;
        } else {
            Nodo nuevo = new Nodo(value);
            top.setNext(nuevo);
            top = nuevo;

//             top.setNext(new Nodo(value));
//             top = top.getNext();
        }
    }

    public void readStack() {
        readStack(bottom);
    }

    public void readStack(Nodo aux) {
        if (aux.getNext() == null) {
            System.out.println(aux.getValue());
        } else {
            readStack(aux.getNext());
            System.out.println(aux.getValue());
        }
    }

    public Object peek() {
        return top.getValue();
    }

    public Object pop() {
        if (bottom == top) {
            Object aux = bottom.getValue();
            bottom = null;
            return aux;
        } else {
            Nodo imp = top;
            Nodo aux = bottom;
            while (aux.getNext() != null && aux.getNext() != top) {
                aux = aux.getNext();
            }
            aux.setNext(null);
            top = aux;
            Object aux1 = imp.getValue();
            return aux1;
        }
    }

    Object getTop() {
        Object aux = top.getValue();
        
        return aux;
    }
}
