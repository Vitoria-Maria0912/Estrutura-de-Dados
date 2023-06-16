package prova;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Calcula o maior caminho em uma BST
 * 
 */
public class BSTDiameter {

	public static void main(String[] args) {
		BSTDiameter diameter = new BSTDiameter();
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
		
		int diametro = diameter.diametro(tree);
		
		System.out.println(diametro);
		
	}

	public Integer diametro(BSTImpl<Integer> tree) {
		int diametro = 0;
		
		if(!tree.isEmpty()) {
			
			if(tree.getRoot().isLeaf()) {
				diametro = 1;
			} else {
				diametro = 1 + recursive(tree.getRoot().getLeft(), 0) + recursive2(tree.getRoot().getRight(), 0);
			}
		}
		
		return diametro;
	}

	private Integer recursive2(BTNode<Integer> root, int treeHeight) {
		
		if(!root.isEmpty()) {
			treeHeight = Math.max(recursive2(root.getLeft(), 1 + treeHeight), recursive2(root.getRight(), 1 + treeHeight));
		}
		
		return treeHeight;
	}

	private Integer recursive(BTNode<Integer> root, int treeHeight) {
		
		if(!root.isEmpty()) {
			treeHeight = 1 + Math.max(recursive(root.getLeft(), treeHeight), recursive(root.getRight(), treeHeight));
		}
		
		return treeHeight;
	}
}
