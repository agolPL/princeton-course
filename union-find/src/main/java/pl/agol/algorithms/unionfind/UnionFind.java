package pl.agol.algorithms.unionfind;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public interface UnionFind {

	public boolean connected(int p, int q);

	public void union(int p, int q);
}
