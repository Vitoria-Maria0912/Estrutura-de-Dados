package prova;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T>{
	
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2){
    	
    	SingleLinkedListNode<T> firstNode = firstNode(node1, node2);
    	SingleLinkedListNode<T> linkedMerge = mergeLinkedLists(node1, node2);
    	
    	return firstNode;

    }

	private SingleLinkedListNode<T> mergeLinkedLists(SingleLinkedListNode<T> n1, SingleLinkedListNode<T> n2) {
		
		SingleLinkedListNode<T> linkedMerge = new SingleLinkedListNode<>();
		SingleLinkedListNode<T> node1 = n1;
		SingleLinkedListNode<T> node2 = n2;
		
		int size1 = 0;
		int size2 = 0;
		
		while(!(node1.isNIL())) {
			size1++;
			node1 = node1.getNext();
		}
		
		while(!(node2.isNIL())) {
			size2++;
			node2 = node2.getNext();
		}
		
		int i = 0;
		int j = 0;
		
		while(!(node1.isNIL()) && !(node2.isNIL()) && i <= size1 && j <= size2) {
			if(node1.getData().compareTo(node2.getData()) <= 0) {
				linkedMerge.setData(node1.getData());
				node1 = node1.getNext();
				i++;
			}
			else {
				linkedMerge.setData(node2.getData());
				node2 = node2.getNext();
				j++;
			}
			linkedMerge.setNext(new SingleLinkedListNode<>());
			linkedMerge = linkedMerge.getNext();
		}
		
		while(!(node1.isNIL() && i <= size1)) {
			linkedMerge.setData(node1.getData());
			node1 = node1.getNext();
			linkedMerge.setNext(new SingleLinkedListNode<>());
			linkedMerge = linkedMerge.getNext();
		}
		
		while(!(node2.isNIL() && i <= size1)) {
			linkedMerge.setData(node2.getData());
			node2 = node2.getNext();
			linkedMerge.setNext(new SingleLinkedListNode<>());
			linkedMerge = linkedMerge.getNext();
		}
		
		return linkedMerge;
	}

	private SingleLinkedListNode<T> firstNode(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
		
		SingleLinkedListNode<T> firstNode = new SingleLinkedListNode<T>();
		
		if(node1.getData().compareTo(node2.getData()) <= 0) {
			firstNode = node1;
			firstNode.setNext(node2);
		} else {
			firstNode = node2;
			firstNode.setNext(node1);
		}
		
		return firstNode;
		
	}
}
