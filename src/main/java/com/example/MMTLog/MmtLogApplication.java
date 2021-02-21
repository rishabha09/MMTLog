package com.example.MMTLog;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MmtLogApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please provide the file path");
		String filePath = scanner.nextLine();

		System.out.println("Please provide the keys name can be present in JSON file");
		String keysString = scanner.nextLine();

		String[] keys = keysString.split(" ");
		ProcessLog processLog = new ProcessLog();
		System.out.println("reading file path is " + filePath);
		processLog.readLogsFromFile(filePath, keys);

		CheckOccurrence checkOccurrence = new CheckOccurrence();
		String[] arrays = null;
		System.out.println("****** Input format ***********");
		System.out.println("please provide the input to test the application " );
		System.out.println("input can be in format of like");
		System.out.println("To test on single value   eg:     " + "DESKTOP INFO");
		System.out.println("To test on multiple values on and  eg:     " + "DESKTOP and INFO");
		System.out.println("To test on multiple values on or    eg:   " + "DESKTOP or INFO");
		while (true) {
			String input = scanner.nextLine();
			arrays = input.split(" and ");
			if(arrays.length > 1) {
				System.out.println("****** Output ***********");
				System.out.println("Finding occurrence in values based on AND  is " + checkOccurrence.findOccurrenceOfValuesOnAnd(arrays));
			} else {
				arrays = input.split(" or ");
				if(arrays.length > 1) {
					System.out.println("****** Output ***********");
					System.out.println("Finding occurrence in values based on OR  is " + checkOccurrence.findOccurrenceOfValuesOnOr(arrays));
				} else {
					arrays = input.split(" ");
					for(String onSingleValue : arrays) {
						System.out.println("****** Output ***********");
						System.out.println("Finding occurrence for single value is for value " + onSingleValue + " "
							+ checkOccurrence.findOccurrenceOnSingleValue(onSingleValue));
					}

				}
			}

		}
	}

}
