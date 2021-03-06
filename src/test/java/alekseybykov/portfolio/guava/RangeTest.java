package alekseybykov.portfolio.guava;

import com.google.common.collect.Range;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Aleksey Bykov
 * @since 03.04.2020
 */
public class RangeTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	@Test
	public void testClosedRange() {
		Range<Integer> inclusive = Range.closed(0, 10);
		assertTrue(inclusive.contains(0));
		assertTrue(inclusive.contains(10));

		assertTrue(inclusive.contains(3));
	}

	@Test
	public void testOpenedRange() {
		Range<Integer> exclusive = Range.open(0, 10);
		assertFalse(exclusive.contains(0));
		assertFalse(exclusive.contains(10));

		assertTrue(exclusive.contains(3));
	}
}
