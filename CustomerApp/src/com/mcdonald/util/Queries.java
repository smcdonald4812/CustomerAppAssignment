package com.mcdonald.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Queries {
	protected String[] p = new String[3];
	public Queries() {
		Properties props = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\steven\\eclipse-workspace2\\CustomerApp\\resources\\config.properties");
			props.load(fis);
			p[0] = props.getProperty("URL");
			p[1] = props.getProperty("USER");
			p[2] = props.getProperty("PASS");
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
