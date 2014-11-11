package com.mono.util;

import java.util.Random;

public class Dado {
	public int getCara() {
		Random rand = new Random();
		int cara = 1+rand.nextInt(6);
		return cara;
	}
}