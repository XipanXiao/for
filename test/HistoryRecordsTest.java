import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HistoryRecordsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFromFile() throws IOException {
		HistoryRecords records = HistoryRecords.fromFile("EUR_USD_Week5.csv");
		assertNotNull(records);
		assertEquals(records.currencyPairSymbol, "EUR/USD");
		assertFalse(records.records.isEmpty());
	}

}
