import java.util.Random;


public class RandomPolicy extends TradePolicy {
	
	Random rand = new Random();
	
	RandomPolicy(AccountSummary account, Orderer orderer, String symbol) {
		super(account, orderer, symbol);
	}

	@Override
	public int getActionType() {
		int dice = rand.nextInt(6);
		switch (dice) {
			case 1:
				return TradeRecord.BUY;
			case 2:
				return TradeRecord.SELL;
			default:
				return TradeRecord.NOACTION;
		}
	}

	@Override
	public TradeRecord trade(int tradeType) {
		int amount = tradeType == TradeRecord.BUY ?
			(int)(account.balance / lastRecord.ask) :
			account.getBoughtAmmount(symbol);

		TradeRecord record = orderer.place(symbol, tradeType, lastRecord.ask, 
				amount);
		return record;
	}
}

