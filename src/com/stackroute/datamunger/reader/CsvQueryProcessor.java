package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	String fileName;

	/*
	 * parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		this.fileName=fileName;
	
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException {
		// TODO Auto-generated method stub

		{
			BufferedReader object=new BufferedReader(new FileReader(this.fileName));
			String string="";
			String[] header=null;
			while((string=object.readLine())!=null){
				if(string.startsWith("id")){
					header=string.split(",");
				}
			}
			System.out.println(header[1]);
			Header object1=new Header(header);


			// read the first line

			// populate the header object with the String array containing the header names
			return object1;
		}

	}
	

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		// TODO Auto-generated method stub

//String result="";
		BufferedReader  object=new BufferedReader(new FileReader(this.fileName));
		String[] result=null;
		String string;
		while((string=object.readLine()+" ")!=null){
			if(string.startsWith("1,")){
				result=string.split(",");
				//System.out.println(result[1]);
				break;
			}
		}
		String[] dataType=new String[result.length];
		int i=0;
	for(String s:result) {
		if (Pattern.matches("[0-9]+",s)) {
			dataType[i] = "java.lang.Integer";
		}            // checking for floating point numbers
		else if (Pattern.matches("[0-9]+\\.[0-9]+",s)) {
			dataType[i] = "java.lang.Float";
		}            // checking for date format dd/mm/yyyy
		else if (Pattern.matches("[0-3][0-9]\\/[0-1][0-9]\\/[0-9]+",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format mm/dd/yyyy
		else if (Pattern.matches("[0-1][0-9]\\/[0-3][0-9]\\/[0-9]+",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format dd-mon-yy
		else if (Pattern.matches("[0-3][0-9]\\-[a-zA-z][a-zA-z][a-zA-z]\\-[0-9][0-9]",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format dd-mon-yyyy
		else if (Pattern.matches("[0-3][0-9]\\-[a-zA-z][a-zA-z][a-zA-z]\\-[0-9]+",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format dd-month-yy
		else if (Pattern.matches("[0-3][0-9]\\-[a-zA-z]+\\-[0-9][0-9]",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format dd-month-yyyy
		else if (Pattern.matches("[0-3][0-9]\\-[a-zA-Z]+\\-[0-9]+",s)) {
			dataType[i] = "java.util.Date";
		}            // checking for date format yyyy-mm-dd
		else if (Pattern.matches("[0-9]+\\-[0-1][]0-9]\\-[0-3][0-9]",s)) {
			dataType[i] = "java.util.Date";
		} else if (Pattern.matches("\\s",s)){
			dataType[i] = "java.lang.Object";
		}
		else {
			dataType[i] = "java.lang.String";
		}

		System.out.println( dataType[i]);
		i++;

	}
		DataTypeDefinitions ob = new DataTypeDefinitions(dataType);
		return ob;
	}
	
	

	
	

}
