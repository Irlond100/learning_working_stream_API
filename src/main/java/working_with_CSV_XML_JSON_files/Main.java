package working_with_CSV_XML_JSON_files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
	
	// public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
	//
	// 	String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
	//
	// 	String fileName = "data.csv";
	//
	// 	List<Employee> list1 = parseCSV(columnMapping, fileName);
	//
	// 	print(listToJson(list1), "data.json");
	//
	// 	List<Employee> list = parseXML("data.xml");
	//
	// 	print(listToJson(list), "data2.json");
	//
	// }
	
	private static List<Employee> parseXML(String s) throws ParserConfigurationException, IOException, SAXException {
		List<Employee> employees = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File(s));
		
		NodeList nodeList = doc.getElementsByTagName("employee");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node_ = nodeList.item(i);
			if (Node.ELEMENT_NODE == node_.getNodeType()) {
				Element element = (Element) node_;
				long id = Long.parseLong((element.getElementsByTagName("id").item(0).getTextContent()));
				String firstName = (element.getElementsByTagName("firstName").item(0).getTextContent());
				String lastName = (element.getElementsByTagName("lastName").item(0).getTextContent());
				String country = (element.getElementsByTagName("country").item(0).getTextContent());
				int age = (Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
				
				employees.add(new Employee(id, firstName, lastName, country, age));
				
			}
			
		}
		return employees;
	}
	
	private static void print(String json, String name) {
		try (FileWriter file = new FileWriter(name)) {
			file.write(json);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// private static String listToJson(List<Employee> list) {
	// 	GsonBuilder gsonBuilder = new GsonBuilder();
	// 	gsonBuilder.setPrettyPrinting();
	// 	Gson gson = gsonBuilder.create();
	// 	Type listType = new TypeToken<List<Employee>>() {
	// 	}.getType();
	//
	// 	return gson.toJson(list, listType);
	//
	// }
	//
	// private static List<Employee> parseCSV(String[] columnMapping, String fileName) {
	// 	CsvToBean<Employee> csv = null;
	//
	// 	try {
	// 		CSVReader reader = new CSVReader(new FileReader(fileName));
	// 		ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
	// 		strategy.setType(Employee.class);
	// 		strategy.setColumnMapping(columnMapping);
	//
	// 		csv = new CsvToBeanBuilder<Employee>(reader)
	// 			.withMappingStrategy(strategy)
	// 			.build();
	//
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	//
	// 	return csv.parse();
	// }
	
}
