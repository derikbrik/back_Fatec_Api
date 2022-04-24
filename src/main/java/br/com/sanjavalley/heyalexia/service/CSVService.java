package br.com.sanjavalley.heyalexia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sanjavalley.heyalexia.entities.Cliente;
import br.com.sanjavalley.heyalexia.helper.CSVHelper;
import br.com.sanjavalley.heyalexia.repository.ClientesRepository;

@Service
public class CSVService {
	
  @Autowired
  ClientesRepository repository;
  public void save(MultipartFile file) {
    try {
      List<Cliente> clientes = CSVHelper.csvToClientes(file.getInputStream());
      repository.saveAllAndFlush(clientes);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  public List<Cliente> getAllClientes() {
    return repository.findAll();
  }
}