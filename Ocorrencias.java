package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class Ocorrencias<T extends Comparable<T>> {
	
	public int ocorrencias(SingleLinkedListNode<T> node1, T element) {
		
		int o = 0;
		
		SingleLinkedListNode<T> node = node1;
		
		while(!(node.isNIL())) {
			if(node.getData().compareTo(element) == 0) {
				o++;
			}
			node = node.getNext();
		}
		
		return o;
	}

	public static void main(String[] args) {
		
		Ocorrencias<Integer> o = new Ocorrencias<>();
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
		
		list.insert(9);
		list.insert(0);
		list.insert(1);
		list.insert(1);
		list.insert(4);
		list.insert(3);
		
		System.out.println(o.ocorrencias(list.getHead(), 10));
	}
}
