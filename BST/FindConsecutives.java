package prova;

import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Acha pares de nós que são consecutivos, ou seja, a diferença entre eles é 1 
 */
public class FindConsecutives {

	public static void main(String[] args) {
		FindConsecutives consecutive = new FindConsecutives();
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
		
		Set<Pair> c = consecutive.findConsecutives(tree.getRoot());
		
		System.out.println(c.toString());
	}

	public Set<Pair> findConsecutives(BSTNode<Integer> root) {
		
		TreeSet<Pair> set = new TreeSet<Pair>();
		findConsecutives(set, root);
		
		return set;
	}

	private void findConsecutives(TreeSet<Pair> set, BSTNode<Integer> root) {
		if(!root.isEmpty()) {
			
			if(!root.getLeft().isEmpty()) {
				if(root.getData() - root.getLeft().getData() == 1) {
					set.add(new Pair(root.getLeft().getData(), root.getData()));
				}
				findConsecutives(set, (BSTNode<Integer>) root.getLeft());
			}
			if(!root.getRight().isEmpty()) {
				if(root.getRight().getData() - root.getData() == 1) {
					set.add(new Pair(root.getData(), root.getRight().getData()));
				}
				findConsecutives(set, (BSTNode<Integer>) root.getRight());
			}
		}
	}
}
