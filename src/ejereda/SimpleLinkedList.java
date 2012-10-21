package ejereda;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; // apuntador al primero
	protected Node<T> last;  // apuntador al �ltimo
	protected int count;

	// Constructor
	public SimpleLinkedList() {
		first = null;
		last = null;
		count = 0;
	}

	public T removeFirst() {
	//Elimina el primer elemento de la lista
    if (isEmpty())
        return null;
     
     Node<T> result = first; 
     first = first.next;
     if (first == null)
        last = null;
     count--;
     return result.data;
	}

	public T removeLast() {
	//Elimina el �ltimo elemento de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

    }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista

	
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

};

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		      if (isEmpty())
		          return false;

		      boolean found = false;
		      Node<T> current = first;

		      while (current != null && !found) 
		         if (elem.equals (current.data))
		            found = true;
		         else
		            current = current.next;
		      return found;
		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�

			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return first == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO

	   } // private class
		
		
		public void visualizarNodos() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
