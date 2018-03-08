package edu.umuc.addressbook.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	private PrintWriter outputFile = null;
	private String filename;
	private boolean append;
	
	public Log(String filename, boolean append) {
		this.filename = filename;
		this.append = append;
		init();
	}
	
	private void init() {
		try {
			outputFile = new PrintWriter(new FileWriter(filename, append));
		} catch (IOException e) {}
	}
	
	public void println(String message) {
		outputFile.println(message);
	}
	
	public void close() {
		outputFile.close();
	}
}
