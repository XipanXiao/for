public class TradeRecord {
	static final int NOACTION = 0;
	static final int BUY = +1;
	static final int SELL = -1;

	String symbol;
	double price;
	int amount;
	int action;
	
	TradeRecord(String symbol, double price, int amount, int action) {
		this.symbol = symbol;
		this.price = price;
		this.action = action;
		this.amount = amount;
	}
}
