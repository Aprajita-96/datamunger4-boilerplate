package com.stackroute.datamunger.query;

import java.util.Arrays;

//header class
public class Header {

	//
	private String[] header;

	public Header(String[] header) {
		this.header = header;
	}

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the headers.
	 */

	public String[] getHeaders() {

		return this.header;
	}

	@Override
	public String toString() {
		return "Header{" +
				"header=" + Arrays.toString(header) +
				'}';
	}
}
