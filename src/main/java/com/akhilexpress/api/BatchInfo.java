package com.akhilexpress.api;

public class BatchInfo {
	
	private String batchName;
	private String trainerName;
	
	
	public BatchInfo(String batchName, String trainerName) {
		super();
		this.batchName = batchName;
		this.trainerName = trainerName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	

}
