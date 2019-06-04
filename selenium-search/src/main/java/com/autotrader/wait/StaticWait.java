package com.autotrader.wait;

public class StaticWait {

	public static StaticWait using() {
		return new StaticWait();
	}
	
	public void waitForMilliSeconds(int milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
