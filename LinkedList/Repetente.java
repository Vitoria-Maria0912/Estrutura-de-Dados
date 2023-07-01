package prova;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class Repetente<T> {

	public SingleLinkedListNode<T> repetente(SingleLinkedListNode<T> head1, T element){
		
		SingleLinkedListNode<T> head = head1;
		
		while(!(head.isNIL())) {
			if(head.getData().equals(element)) {
				head.setData(head.getNext().getData());
				head.setNext(head.getNext().getNext());
			} else {
				head = head.getNext();
			}
		}
		
		return head1;
	}
	
	public static void main(String[] args) {
		Repetente<Integer> r = new Repetente<>();
		SingleLinkedListImpl<Integer> list = new SingleLinkedListImpl<>();
		
		list.insert(2);
		list.insert(2);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(2);
		list.insert(4);
		
		SingleLinkedListNode<Integer> head = r.repetente(list.getHead(), 2);
		
		while(!(head.isNIL())) {
			System.out.print(head.getData() + " -> ");
			head = head.getNext();
		}
	}
}
