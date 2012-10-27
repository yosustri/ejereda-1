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
		 if (isEmpty())
		        return null;
		 if(count==1)
			 {
			 first=null;
			 last=null;
			 count--;
			 return null;
			 }
		 Node<T> anterior=first;
		 Node<T> result = first.next; 
		while(result.next!=null)
			{
			anterior=result;
			result=result.next;		
			}
		last=anterior;
		last.next=null;
		count--;
		return last.data;
//coste:O(n)
    }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		if (isEmpty())
	          return null;
		boolean enc=false;
		Node<T> anterior=first;
		 Node<T> current = first.next;
		 if(elem.equals (first.data))
			 this.removeFirst();
		 if(elem.equals(last.data))
			 this.removeLast();
		 while(current != null && !enc)
			{
			if(elem.equals (current.data))
				{
				enc=true;
				anterior.next=current.next;
				count--;
				}
			else{
				anterior=current;
				current=current.next;
				}
		 }
		 if(enc)
			 return current.data;
		 else
			 return null;
		 //coste: O(n);
}

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
		if (isEmpty())
	          return null;
		boolean enc=false;
		 Node<T> current = first.next;
		while(current != null &&!enc)
		{
		if(elem.equals (current.data))
			enc=true;
		else{
			current = current.next;
			}
	 }
	 if(enc)
		 return current.data;
	 else
		 return null;
//Coste O(n);

	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return first == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new MiListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class MiListIterator implements Iterator<T> {
		   private Node<T> current=first;
		   public boolean hasNext(){return current !=null;}
		   public void remove(){ throw new UnsupportedOperationException();}
		   public T next(){
			   if(!hasNext()) throw new NoSuchElementException();
			   T item=current.data;
			   current=current.next;
			   return item;
		   }
	   } 
		
		
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
