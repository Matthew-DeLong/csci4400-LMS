package com.lms;

public interface DatabaseInterface {
	
	public int getRecordNumber(String identifier);
	
	public String[] getRecord(int recordNumber);
	
	public void save(String[] record);

}
