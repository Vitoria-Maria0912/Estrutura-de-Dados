package prova;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * Verifica se dois nós são "primos" de 1º grau, ou seja, tem o mesmo "avô"
 */
public class FamilyBST {
	
	public static void main(String[] args) {
		
		FamilyBST family = new FamilyBST();
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
		
		boolean primos = family.primosPrimeiroGrau(tree, 2, 4);
		
		System.out.println(primos);
	}
	
	public boolean primosPrimeiroGrau(BSTImpl<Integer> tree, Integer elem1, Integer elem2) {
		boolean areCousin = false;
		
		BSTNode<Integer> filho1 = tree.search(elem1);
		BSTNode<Integer> filho2 = tree.search(elem2);
		
		if(!filho1.isEmpty() && !filho2.isEmpty()) {
			
			BTNode<Integer> pai1 = filho1.getParent();
			BTNode<Integer> pai2 = filho2.getParent();
			
			if(!pai1.equals(pai2)) {
				
				BTNode<Integer> vo1 = pai1.getParent();
				BTNode<Integer> vo2 = pai2.getParent();
				
				if(vo1.equals(vo2)) {
					areCousin = true;
				}
			}
		}
		return areCousin;
	}
}
