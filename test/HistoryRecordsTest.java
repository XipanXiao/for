import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HistoryRecordsTest {

	HistoryRecords records;
	@Before
	public void setUp() throws Exception {
		records = new HistoryRecords();
		records.addFile("EUR_USD_Week5.csv");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddFile() throws IOException {
		assertEquals(records.currencyPairSymbol, "EUR/USD");
		assertFalse(records.records.isEmpty());
	}

	public void testGetNextRate() {
		assertTrue(records.hasNextRate());
		
		while(records.hasNextRate()) {
			RateRecord rate = records.getNextRate();
			assertNotNull(rate);
		}
	}
}
