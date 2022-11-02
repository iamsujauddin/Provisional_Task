package com.example.model;

public class ResponseDto {

	private int id;
	private String fileName;
	private String fileType;

	public ResponseDto(int id, String fileName, String fileType) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
