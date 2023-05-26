package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class ReverseLinkedList<T extends Comparable<T>> {
	
	public SingleLinkedListNode<T> reverse(SingleLinkedListNode<T> node) {
		
		SingleLinkedListNode<T> prev = new SingleLinkedListNode<>();
		SingleLinkedListNode<T> atual = node;
		
		while(!(atual.isNIL())) {
			atual.setNext(prev);
			prev = atual;
			atual = atual.getNext();
		}
		
		return prev;
	}

	public static void main(String[] args) {
		ReverseLinkedList<Integer> r = new Reverse<>();
		SingleLinkedListImpl<Integer> list = new SingleLinkedListImpl<>();
		
		list.insert(9);
		list.insert(0);
		list.insert(1);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		
		SingleLinkedListNode<Integer> node = list.getHead();
		
		while(!(node.isNIL())) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
		
		System.out.println();
		System.out.println("-----------------------------");
		SingleLinkedListNode<Integer> node2 = r.reverse(list.getHead());
		
		while(!(node2.isNIL())) {
			System.out.print(node2.getData() + "->");
			node2 = node2.getNext();
		}
	}
}
