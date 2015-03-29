import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HistoryRecords {
	List<HistoryRecord> records;
	String currencyPairSymbol;
	
	HistoryRecords(List<HistoryRecord> records, String symbol) {
		this.records = records;
		this.currencyPairSymbol = symbol;
	}
	
	static HistoryRecords fromFile(String filename) throws IOException {
		String symbol = null;
		List<HistoryRecord> records = new ArrayList<HistoryRecord>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		boolean firstLine = true;
		for (String line; (line = reader.readLine()) != null; ) {
			if (firstLine) {
				firstLine = false;
				continue;
			}
			
			if (symbol == null) {
				symbol = HistoryRecord.getCurrencySymbol(line);
			}

			HistoryRecord record = HistoryRecord.fromString(line);
			records.add(record);
		}
		
		reader.close();
		return new HistoryRecords(records, symbol);
	}
}
