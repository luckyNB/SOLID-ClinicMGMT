package com.commercial.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.commercial.model.CommercialPOJO;
import com.ims.util.Utility;

public class CommercialOperationsImpl implements CommercialOperations {
	public static ObjectMapper mapper = new ObjectMapper();
	public static LinkedList<CommercialPOJO> data = new LinkedList<>();

	@Override
	public void saveFile(CommercialPOJO pojo) throws JsonGenerationException, IOException, JsonParseException {
		try {
			data = mapper.readValue(new File("/home/admin111/Spring Modules/DDD/ims/src/main/java/Inventory.json"),
					new TypeReference<LinkedList<CommercialPOJO>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		data.add(pojo);
		try {
			mapper.writeValue(new File("/home/admin111/Spring Modules/DDD/ims/src/main/java/Inventory.json"), data);

			// write data to file
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeData() {
		try {

			data = mapper.readValue(new File("/home/admin111/Spring Modules/DDD/ims/src/main/java/Inventory.json"),
					new TypeReference<LinkedList<CommercialPOJO>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.println("Enter Symbol");
		String symbol = Utility.inputString();
		int i = 0;
		for (i = 0; i < data.size(); i++) {
			if (i == data.size()) { // to check list is empty or not
				System.out.println("Invalid ");
			} else if (data.get(i).getSymbol().equals(symbol)) { // if symbol found then remove it
				data.remove(i);
			}
		}
		try {
			mapper.writeValue(new File("/home/admin111/Spring Modules/DDD/ims/src/main/java/Inventory.json"), data);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public void displayInformation() throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		LinkedList<CommercialPOJO> data1 = mapper.readValue(
				new File("/home/admin111/Spring Modules/DDD/ims/src/main/java/Inventory.json"),
				new TypeReference<LinkedList<CommercialPOJO>>() {
				});

		int i = 0;
		int size = data1.size();
		if (size == 0)
			System.out.println("\nno data found");
		else {
			System.out.println("Name\tsymbol\tvalue");
			for (i = 0; i < data1.size(); i++) {
				System.out.println(data1.get(i).getCompanyName() + "\t  " + data1.get(i).getSymbol() + "\t"
						+ data1.get(i).getSymbolValue());
			}
		}
	}

	@Override
	public void buySymbol() {
		// TODO Auto-generated method stub

	}

}
