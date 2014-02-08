package pl.agol.algorithms.unionfind;

/**
 * 
 * @author Andrzej Goławski
 *
 */
public class QuickUnion implements UnionFind {

	private final int[] id;

	public QuickUnion(int elemNumber) {
		id = new int[elemNumber];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}

	@Override
	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

	private int findRoot(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		
		id[pRoot] = qRoot;
	}
}
