import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RateRecord {
	String symbol;
	long tid;
	boolean dealable;
	Date time;
	double bid;
	double ask;

	RateRecord(long tid, boolean dealable, Date time, double bid,
			double ask) {
		this.tid = tid;
		this.dealable = dealable;
		this.time = time;
		this.bid = bid;
		this.ask = ask;
	}
	
	static RateRecord fromString(String record) {
		String[] fields = record.split(",");
		long tid = Long.valueOf(fields[0]);
		boolean dealable = fields[1].equals("D");
		
		Date time;
        SimpleDateFormat simpleDateFormat = 
        		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {
			time = simpleDateFormat.parse(fields[3]);
		} catch (ParseException e) {
			return null;
		}

        double bid = Double.valueOf(fields[4]);
        double ask = Double.valueOf(fields[5]);
        
        return new RateRecord(tid, dealable, time, bid, ask);
	}
	
	static String getCurrencySymbol(String record) {
		String[] fields = record.split(",");
		return fields[2];
	}
}
