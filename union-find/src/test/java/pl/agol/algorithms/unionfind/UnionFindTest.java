package pl.agol.algorithms.unionfind;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class UnionFindTest {

	private static final int ELEM_NUMNBER = 8;

	@Test(dataProvider = "algorithmsProvider")
	public void checks_correctness_of_union_find_algorithms(UnionFind unionFind) {

		unionFind.union(1, 4);
		unionFind.union(4, 5);
		unionFind.union(2, 6);
		unionFind.union(2, 3);
		unionFind.union(3, 7);

		Assert.assertTrue(unionFind.connected(2, 7));
		Assert.assertTrue(unionFind.connected(6, 7));
		Assert.assertTrue(unionFind.connected(2, 3));
		Assert.assertTrue(unionFind.connected(5, 1));
		Assert.assertTrue(unionFind.connected(4, 1));

		Assert.assertFalse(unionFind.connected(5, 6));
		Assert.assertFalse(unionFind.connected(7, 4));
		Assert.assertFalse(unionFind.connected(1, 7));

		unionFind.union(5, 2);

		Assert.assertTrue(unionFind.connected(1, 7));
		Assert.assertTrue(unionFind.connected(5, 6));
		Assert.assertTrue(unionFind.connected(7, 4));
	}

	@DataProvider(name = "algorithmsProvider")
	private Object[][] paramsProvider() {
		return new Object[][] { { new QuickFind(ELEM_NUMNBER) }, { new QuickUnion(ELEM_NUMNBER) } };
	}
}
