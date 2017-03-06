package hu.bme.mit.train.interfaces;
import java.util.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph {
	public Table<Date, Integer, Integer> table = HashBasedTable.create();
	
	public void addEntry(Date date, int joypos, int speed){
		table.put(date, (Integer)joypos, (Integer)speed);
	}
}
