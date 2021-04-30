package dataLoads;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	// to parse json file download jackson Core and jackson databind dependencies

	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		//readValue- method takes json as string, so we have to convert the same
		//so we will use FileUtils to do the same
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		//mapper.readValue- takes file data as String and it will read json file
		//and wrap all json data in list of Hashmap
		//TypeReference converting ur json object to hashmap
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;		
	}

}
