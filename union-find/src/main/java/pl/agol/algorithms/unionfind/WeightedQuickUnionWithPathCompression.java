package pl.agol.algorithms.unionfind;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class WeightedQuickUnionWithPathCompression extends WeightedQuickUnion {

	public WeightedQuickUnionWithPathCompression(int elemNumber) {
		super(elemNumber);
	}

	@Override
	protected Node findRoot(int i) {
		while (i != nodes[i].id) {
			nodes[i] = nodes[nodes[i].id];
			i = nodes[i].id;
		}
		return nodes[i];
	}

}
