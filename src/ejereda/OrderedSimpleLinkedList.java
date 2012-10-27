package listasSimples;

public class OrderedSimpleLinkedList<T> extends SimpleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		Node<T> current=first;
		Node<T> ant=null;
		Node<T> nuevo=null;
		boolean enc=false;
		while(current != null &&!enc)
		{
			if(current.data==elem)
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
			nuevo=current;
			ant.next=nuevo;
		}
		//FAlta cuando lista vacia y con un solo elemeto
	}


}

