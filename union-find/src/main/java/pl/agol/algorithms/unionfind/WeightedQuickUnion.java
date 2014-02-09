package pl.agol.algorithms.unionfind;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class WeightedQuickUnion implements UnionFind {

	protected final Node nodes[];

	 protected class Node {
		public final int id;
		public int treeSize = 1;

		public Node(int id) {
			this.id = id;
		}

		@Override
		public boolean equals(Object obj) {
			return ((Node) obj).id == id;
		}
	}

	public WeightedQuickUnion(int elemNumber) {
		nodes = new Node[elemNumber];
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = new Node(i);
	}

	@Override
	public boolean connected(int p, int q) {
		return findRoot(p).equals(findRoot(q));
	}

	protected Node findRoot(int i) {
		while (i != nodes[i].id)
			i = nodes[i].id;
		return nodes[i];
	}

	@Override
	public void union(int p, int q) {
		Node pRoot = findRoot(p);
		Node qRoot = findRoot(q);
		if (pRoot.treeSize < qRoot.treeSize) {
			nodes[pRoot.id] = qRoot;
			qRoot.treeSize += pRoot.treeSize;
		} else {
			nodes[qRoot.id] = pRoot;
			pRoot.treeSize += qRoot.treeSize;
		}
	}

}
