import java.util.HashMap;
import java.util.Map;


public class AccountSummary {
	double balance;
	
	Map<String, Integer> boughtSymbols = new HashMap<String, Integer>();
	
	void addTradeRecord(TradeRecord record) {
		balance -= record.price * record.amount * record.action;
		
		Integer bought = boughtSymbols.get(record.symbol);
		if (bought == null) {
			bought = new Integer(record.amount);
		} else {
			bought = new Integer(bought.intValue() + 
					record.amount * record.action);
		}
		
		boughtSymbols.put(record.symbol, bought);
	}
	
	int getBoughtAmmount(String symbol) {
		Integer bought = boughtSymbols.get(symbol);
		return bought == null ? 0 : bought.intValue();
	}
}
