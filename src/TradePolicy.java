
public abstract class TradePolicy {
	Orderer orderer;
	AccountSummary account;
	String symbol;
	RateRecord lastRecord;
	
	TradePolicy(AccountSummary account, Orderer orderer, String symbol) {
		this.account = account;
		this.orderer = orderer;
		this.symbol = symbol;
	}

	void addRate(RateRecord record) {
		lastRecord = record;
	}
	
	abstract int getActionType();
	abstract TradeRecord trade(int type);
}
