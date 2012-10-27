package listasSimples;

public class UnorderedSimpleLinkedList<T> extends SimpleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		Node<T> result=null;
		result.data=elem;
		result.next=first;
		first=result;
		count++;
		//CosteO(1);
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		Node<T> result=null;
		result.data=elem;
		result.next=last.next;
		last.next=result;
		count++;
		//Coste(1);
	}
	
	public void addAfter(T elem, T target) {
		//pre:Como minimo hay un elemento en la lista, target.
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		if(count==1)
			addToFront(elem);
		else
		{
		Node<T> current=first;
		boolean enc=false;
		Node<T> nuevo=null;
		Node<T> ant=null;
		while(current != null&&!enc)
		{
			if(current.data.equals(target))
				enc=true;
			else
				{
				ant=current;
				current=current.next;
				}
		}
		if(enc)
		{
			nuevo.data=elem;
			nuevo.next=current;
			ant.next=nuevo;
			count++;			
		}
		}
		//Coste(n);
	}

}

