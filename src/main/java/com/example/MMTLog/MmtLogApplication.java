package com.example.MMTLog;

import org.springframework.boot.SpringApplication;
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

		System.out.println("Please provide the multiple values on which single occurrence has to find");
		String findOnSingleValueString = scanner.nextLine();
		String findOnMultipleString = scanner.nextLine();

		String[] keys = keysString.split(" ");
		String[] findOnSingleValue= findOnSingleValueString.split(" ");
		String[] findOnMultipleAnd = findOnMultipleString.split(" and ");
		System.out.println(findOnSingleValue.toString());
		String[] findOnMultipleOr = findOnMultipleString.split(" or ");


		ProcessLog processLog = new ProcessLog();
		System.out.println("reading file path is " + filePath);
		processLog.readLogsFromFile(filePath, keys);

		CheckOccurrence checkOccurrence = new CheckOccurrence();

		for(String onSingleValue : findOnSingleValue) {
			System.out.println("");
			System.out.println("Finding occurrence for single value is for value " + onSingleValue + " "  + checkOccurrence.findOccurrenceOnSingleValue(onSingleValue));
		}

		if(findOnMultipleAnd.length > 0) {
			System.out.println("Finding occurrence in values based on AND  is " + checkOccurrence.findOccurrenceOfValuesOnAnd(findOnMultipleAnd));
		}

		if(findOnMultipleAnd.length > 0) {
			System.out.println("Finding occurrence in values based on OR  is " + checkOccurrence.findOccurrenceOfValuesOnOr(findOnMultipleOr));
		}
	}

}
