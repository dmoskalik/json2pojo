package ch.cern.dmoskali;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.cern.syscontrol.objects.Container;
import ch.cern.syscontrol.objects.Host;

public class Json2PojoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// POJO to JSON
		User user = new User();
		user.setId(1L);
		user.setName("User");
		user.setBirthDate(Calendar.getInstance());
		user.setEmails(new HashSet<String>());
		user.getEmails().add("user@gmail.com");
		user.getEmails().add("user@yahoo.com");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Container obj = mapper.readValue(new File("e:\\test.json"), Container.class);
			String entity = obj.getScEntity();
			obj.setScComment("Test n 1");
			//List<Host> hosts = obj.getHosts();
			//for (Host host : hosts){
			//	System.out.println(host.getScHostName());
			//}
			System.out.println("SC_entity: "+ entity);
			
			// Save container somewhere else
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("e:\\tomcat2.json"), obj);
		} catch (JsonParseException e) {
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
}
