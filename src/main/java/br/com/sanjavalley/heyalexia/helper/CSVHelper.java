package br.com.sanjavalley.heyalexia.helper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



import org.springframework.web.multipart.MultipartFile;
import br.com.sanjavalley.heyalexia.entities.Cliente;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
 

public class CSVHelper {
	  public static String TYPE = "text/csv";
	  static String[] HEADERs = { "cliente_Id", "Nome",	"Sobrenome",	"ClienteTelefone",	"ClienteEmail",	"Endereco_Id" };
	  
	    
		
	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<Cliente> csvToClientes(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<Cliente> clientes = new ArrayList<Cliente>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      for (CSVRecord csvRecord : csvRecords) {
	        Cliente cliente= new Cliente(        		
	        		Long.parseLong(csvRecord.get("Cliente_Id")),
	        		csvRecord.get("Nome"),	        		 
	        		 csvRecord.get("Sobrenome"),
	        		 csvRecord.get("ClienteTelefone"),	        		
	        		 csvRecord.get("ClienteEmail"),	        	
	        		 Long.parseLong(csvRecord.get("Endereco_Id")));
	        		
	       clientes.add(cliente);
	      }
	      return clientes;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
	}