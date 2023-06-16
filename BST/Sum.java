package prova;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Verifica se há dois elementos que somados resultam no valor passado como parâmetro.
 */
public class Sum {
	
	public static void main(String[] args) {
		
		Sum soma = new Sum();
		BSTImpl<Integer> tree = new BSTImpl<>();
		
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(2);
		tree.insert(4);
		tree.insert(8);
		tree.insert(1);
		tree.insert(7);
		tree.insert(9);
		
		boolean sum = soma.soma(tree, 8);
		
		System.out.println(sum);
	}
	
	public boolean soma(BSTImpl<Integer> tree, Integer value) {
		
		boolean soma = false;
		
		if(!tree.isEmpty()) {
			if(!tree.getRoot().isEmpty() && tree.height() >= 1) {
				soma = sumRecursive(tree, tree.getRoot(), value, soma);
			}
		}
			
		return soma;
	}
	
	private boolean sumRecursive(BSTImpl<Integer> tree, BSTNode<Integer> root, Integer value, boolean soma) {
		
		if(!root.isEmpty()) {
			if(!tree.search(value - root.getData()).isEmpty()) {
				soma = true;
			}
			
			if(!root.getLeft().isEmpty()) {
				sumRecursive(tree, (BSTNode<Integer>) root.getLeft(), value, soma);
			}
			if(!root.getRight().isEmpty()) {
				sumRecursive(tree, (BSTNode<Integer>) root.getRight(), value, soma);
			}
		}
		
		return soma;
	}
}
