import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HistoryRecordTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFromString() {
		String data = "3705101498,D,EUR/USD,2014-12-28 17:00:06.370000000,1.217840,1.218340";
		assertNotNull(HistoryRecord.fromString(data));
	}
}
