
package io.collapp.web.api;

import java.util.ArrayList;
import java.util.List;

abstract class Utils {

	/**
	 * CHECK: After updating to spring4rc2 we receive List of Double o_O
	 *
	 * @param v
	 * @return
	 */
	static List<Integer> from(List<Number> v) {
		List<Integer> res = new ArrayList<>();
		for (Number n : v) {
			res.add(n.intValue());
		}
		return res;
	}
}
