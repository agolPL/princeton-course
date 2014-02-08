package pl.agol.algorithms.unionfind;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class QuickFind implements UnionFind {

	private final int[] id;

	public QuickFind(int elemNumber) {
		id = new int[elemNumber];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}

	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId)
				id[i] = qId;
		}
	}
}
