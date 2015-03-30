
public class Orderer {
	TradeRecord place(String symbol, int tradeType, double price, int amount) {
		return new TradeRecord(symbol, price, amount, tradeType);
	}
}
