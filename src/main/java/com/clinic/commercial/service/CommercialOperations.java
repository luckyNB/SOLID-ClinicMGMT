package com.commercial.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.commercial.model.CommercialPOJO;

public interface CommercialOperations {

	void saveFile(CommercialPOJO pojo) throws JsonGenerationException, IOException, JsonParseException;

	void removeData();

	void displayInformation() throws  JsonMappingException, IOException ;
 
	void buySymbol();
	
}
