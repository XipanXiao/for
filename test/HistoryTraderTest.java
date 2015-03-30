import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HistoryTraderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() throws IOException {
		AccountSummary account = new AccountSummary();
		account.balance = 10000.0;
		
		HistoryRecords history = new HistoryRecords();
		history.addFile("EUR_USD_Week5.csv");

		Trader trader = new Trader(account, history);
		trader.addPolicy(new RandomPolicy(account, new Orderer(), "EUR/USD"));
		
		trader.run();
	}

	@Test
	public void testAddPolicy() {
		assertTrue(true);
	}
}
