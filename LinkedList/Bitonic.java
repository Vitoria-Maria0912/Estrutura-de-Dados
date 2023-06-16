package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

public class Bitonic<T extends Comparable<T>>{

	public SingleLinkedListNode<T> bitonico(DoubleLinkedListNode<T> topo) {
		
		DoubleLinkedListNode<T> dir = topo;
		DoubleLinkedListNode<T> esq = topo;
		
		DoubleLinkedListImpl<T> list = new DoubleLinkedListImpl<>();
		
		while(!(dir.getNext().isNIL())) {
			dir = (DoubleLinkedListNode<T>) dir.getNext();
		}
		
		while(!(esq.getPrevious().isNIL())) {
			esq = esq.getPrevious();
		}
		
		while(!(esq.equals(topo)) && !(dir.isNIL())) {
			if(esq.getData().compareTo(dir.getData()) < 0){
				list.insert(esq.getData());
				esq = (DoubleLinkedListNode<T>) esq.getNext();
			} else {
				list.insert(dir.getData());
				dir = dir.getPrevious();
			}
		}
		
		list.insert(topo.getData());
		
		return list.getHead();
		
	}
	
	public static void main(String[] args) {
		Bitonic<Integer> b = new Bitonic<>();
		
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
		
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10); // ponto bitônico
		list.insert(5);
		list.insert(4);
		list.insert(3);
		
		SingleLinkedListNode<Integer> head1 = list.getHead();
		
		while(!(head1.isNIL())) {
			System.out.print(head1.getData() + " -> ");
			head1 = head1.getNext();
		}
		
		System.out.println("");
		System.out.println("-----------------------------------");
		
		DoubleLinkedListNode<Integer> topo = new DoubleLinkedListNode<>();
		SingleLinkedListNode<Integer> head = list.getHead();
		
		while(!(head.isNIL())) {
			if(head.getData().compareTo(10) == 0) {
				topo = (DoubleLinkedListNode<Integer>) head;
			}
			head= head.getNext();
		}
		
		SingleLinkedListNode<Integer> head2 = b.bitonico(topo);
		
		while(!(head2.isNIL())) {
			System.out.print(head2.getData() + " -> ");
			head2 = head2.getNext();
		}
	}
}
