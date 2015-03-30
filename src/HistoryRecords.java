import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HistoryRecords implements RatedataFeeder {
	int currentIndex = 0;
	List<RateRecord> records;
	String currencyPairSymbol;
	
	HistoryRecords() {
	}
	
	HistoryRecords(List<RateRecord> records, String symbol) {
		this.records = records;
		this.currencyPairSymbol = symbol;
	}
	
	void addFile(String filename) throws IOException {
		if (records == null) {
			records = new ArrayList<RateRecord>();
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		boolean firstLine = true;
		for (String line; (line = reader.readLine()) != null; ) {
			if (firstLine) {
				firstLine = false;
				continue;
			}
			
			if (currencyPairSymbol == null) {
				currencyPairSymbol = RateRecord.getCurrencySymbol(line);
			}

			RateRecord record = RateRecord.fromString(line);
			records.add(record);
		}
		
		reader.close();
	}

	@Override
	public RateRecord getNextRate() {
		if (records == null || records.isEmpty()) {
			return null;
		}
		
		return records.get(currentIndex++);
	}

	@Override
	public boolean hasNextRate() {
		return currentIndex < records.size();
	}
}
