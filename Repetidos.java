package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class Repetidos <T extends Comparable<T>>{
	
	public SingleLinkedListNode<T> rep(SingleLinkedListNode<T> node1, T elemento) {
		
		SingleLinkedListNode<T> node = node1;
		
		boolean first = false;
		
		while(!(node.isNIL())){
			if(!first && node.getData().compareTo(elemento) == 0) {
				first = true;
				node = node.getNext();
			}
			else if(first && node.getData().compareTo(elemento) == 0) {
				node.setData(node.getNext().getData());
				node.setNext(node.getNext().getNext());
			} else {
				node = node.getNext();
			}
		}
		
		return node1;
	}

	public static void main(String[] args) {
		Repetidos<Integer> r = new Repetido1<>();
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
		
		list.insert(9);
		list.insert(0);
		list.insert(1);
		list.insert(1);
		list.insert(4);
		list.insert(3);
		
		SingleLinkedListNode<Integer> node = r.rep(list.getHead(), 1);
		
		while(!node.isNIL()) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
	}
}
