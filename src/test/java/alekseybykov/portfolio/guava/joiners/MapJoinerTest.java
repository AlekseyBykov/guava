package alekseybykov.portfolio.guava.joiners;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksey Bykov
 * @since 19.03.2020
 */
public class MapJoinerTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private Map<String, String> map;

	@Before
	public void setup() {
		map = Maps.newLinkedHashMap();
	}

	@Test
	public void testJoinKeyValuePairsFromMapToString() {
		map = Maps.newLinkedHashMap();
		map.put("key 1", "value 1");
		map.put("key 2", "value 2");
		map.put("key 3", "value 3");

		String expectedString = "key 1=value 1#key 2=value 2#key 3=value 3";
		Joiner.MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");

		String actualString = mapJoiner.join(map);

		assertThat(actualString, is(expectedString));
	}
}
