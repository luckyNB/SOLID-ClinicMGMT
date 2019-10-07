package com.commercial.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import org.codehaus.jackson.map.ObjectMapper;

import com.commercial.model.CommercialPOJO;
import com.commercial.service.CommercialOperations;
import com.commercial.service.CommercialOperationsImpl;
import com.ims.util.Utility;

public class CommercialDataProcessing {

	public static ObjectMapper mapper = new ObjectMapper();
	public static LinkedList<CommercialPOJO> data = new LinkedList<>();

	public static CommercialOperations operations=new  CommercialOperationsImpl();
	
	public static void main(String args[]) throws Exception {
		int choice = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		CommercialPOJO com = new CommercialPOJO();
		do {
			System.out.println("***************Stock Management******************");
			System.out.println("1. Add data to the stock        |");
			System.out.println("2. Remove data from the stock   |");
			System.out.println("3. display list of stock        |");
			System.out.println("4. buy symbol from stock        |");
			System.out.println("5. sell symbol from stock       |");
			System.out.println("6. For Exit the stock management|");
			System.out.println("________________________________|");
			choice = Utility.inputInteger("Enter your choice");
			switch (choice) {
			case 1:
				// to add new data
				System.out.println("**************Insert Stock Details:******************");
				System.out.println("Enter company Name:");
				String name = Utility.getStringValue();

				System.out.println("Enter symbol:");
				String number = Utility.getStringValue();

				String price = Utility.inputString("Enter Price");

				com.setCompanyName(name);
				com.setSymbol(number);
				com.setSymbolValue(price);
				String date = (dtf.format(now));
				com.setDate(date);

				// add new data
				operations.saveFile(com);
				System.out.println("data added successfully ");
				break;

			case 2:
				// to remove data
				operations.removeData();
				System.out.println("data removed successfully");
				break;

			case 3:
				// to display data
				operations.displayInformation();
				break;

			case 4:
				// to buy symbol
				System.out.println("Which symbol you want to buy:");
				String symbol = Utility.inputString();
				System.out.println("enter company name:");
				String name1 = Utility.inputString();
				// System.out.println("");
				String price1 = Utility.inputString("enter symbol price:");

				com.setCompanyName(name1);
				com.setSymbol(symbol);
				com.setSymbolValue(price1);
				date = (dtf.format(now));
				com.setDate(date);
				// add new data
				operations.saveFile(com);
				System.out.println("transaction successful...buyed");
				break;

			case 5:
				// to sell data
				operations.removeData();
				break;

			case 6:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid Entry Retype");
			}

		} while (choice <= 6 && choice > 0);

	}


}