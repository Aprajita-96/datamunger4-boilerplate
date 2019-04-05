

package com.stackroute.datamunger.query;

		import java.util.Arrays;

public class DataTypeDefinitions {
	private String[] dataType;
	public DataTypeDefinitions(String[] dataType){
		this.dataType=dataType;
	}
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */

	@Override
	public String toString() {
		return "DataTypeDefinitions{" +
				"datatype=" + Arrays.toString(dataType) +
				'}';
	}

	public String[] getDataTypes() {

		return dataType;
	}
}
