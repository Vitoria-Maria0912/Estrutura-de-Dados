package prova;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

public class Ordenada<T extends Comparable<T>> {
	
	public String name(SingleLinkedListNode<T> node) {
		
		String ordenada = "";
		boolean crescente = false;
		boolean decrescente = false;
		
		SingleLinkedListNode<T> node2 = node;
		SingleLinkedListNode<T> node3 = node;
		
		while(!node2.isNIL()) {
			if(!node2.getNext().isNIL()) {
				if(node2.getData().compareTo(node2.getNext().getData()) < 0) {
					crescente = true;
				} else {
					crescente = false;
					break;
				}
			}
			node2 = (DoubleLinkedListNode<T>) node2.getNext();
		}
		
		while(!node3.isNIL()) {
			if(!node3.getNext().isNIL()) {
				if(node3.getData().compareTo(node3.getNext().getData()) > 0) {
					decrescente = true;
				} else {
					decrescente = false;
					break;
				}
			}
			node3 = (DoubleLinkedListNode<T>) node3.getNext();
		}
		
		if(crescente) {
			ordenada = "lista crescente";
		}
		
		else if(decrescente) {
			ordenada = "lista descrescente";
		}
		
		else if(!decrescente && !crescente){
			ordenada = "lista desordenada";
		}
		
		
		return ordenada;
	}

	public static void main(String[] args) {
		Ordenada<Integer> o = new Ordenada<>();
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
		
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		System.out.println(o.name(list.getHead()));
		
		list = new DoubleLinkedListImpl<>();
		
		list.insert(9);
		list.insert(8);
		list.insert(7);
		System.out.println(o.name(list.getHead()));
		
		list = new DoubleLinkedListImpl<>();
		
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		System.out.println(o.name(list.getHead()));
		
	}
}
