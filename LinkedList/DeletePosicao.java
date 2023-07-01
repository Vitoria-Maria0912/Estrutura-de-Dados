package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class DeletePosicao<T extends Comparable<T>> {

	public SingleLinkedListNode<T> delete(SingleLinkedListNode<T> node, int posicao) {
		
		int index= 0;
		
		SingleLinkedListNode<T> node1 = node;
		
		while(!(node1.isNIL())) {
			if(index == posicao) {
				node1.setData(node1.getNext().getData());
				node1.setNext(node1.getNext().getNext());
				break;
				
			} else {
				index++;
				node1 = node1.getNext();
			}
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		DeletePosicao<Integer> d = new DeletePosicao<>();
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
		
		list.insert(9);
		list.insert(0);
		list.insert(1); // removido
		list.insert(4);
		list.insert(3);
		
		SingleLinkedListNode<Integer> node = d.delete(list.getHead(), 2);
		
		while(!node.isNIL()) {
			System.out.print(node.getData() + "->");
			node = node.getNext();
		}
	}
}
