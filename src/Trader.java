import java.util.ArrayList;
import java.util.List;


public class Trader implements Runnable {
	
	List<TradePolicy> policies = new ArrayList<TradePolicy>();
	List<TradeRecord> tradeRecords = new ArrayList<TradeRecord>();
	RatedataFeeder rateSource;
	AccountSummary account;
	
	Trader(AccountSummary account, RatedataFeeder rateSource) {
		this.account = account;
		this.rateSource = rateSource;
	}
	
	@Override
	public void run() {
		while (rateSource.hasNextRate()) {
			RateRecord rate = rateSource.getNextRate();
			
			for (TradePolicy policy : policies) {
				policy.addRate(rate);

				int tradeType = policy.getActionType();
				if (tradeType == TradeRecord.NOACTION) {
					continue;
				}
				
				TradeRecord tradeRecord = policy.trade(tradeType);
				tradeRecords.add(tradeRecord);
				account.addTradeRecord(tradeRecord);
				TradeLogger.log(tradeRecord, account);
			}
		}
	}
	
	
	void addPolicy(TradePolicy policy) {
		policies.add(policy);
	}
}
