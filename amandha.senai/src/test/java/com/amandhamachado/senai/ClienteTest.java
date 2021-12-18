package com.amandhamachado.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amandhamachado.senai.domain.Cliente;
import com.amandhamachado.senai.repositories.ClienteRepository;



@SpringBootTest
public class ClienteTest {

@Autowired
ClienteRepository clienteRepo;

@Test
void Cliente () {
	Cliente cli = new Cliente();
	cli.setIdCliente(null);
	cli.setNome("Amandha Machado");
	cli.setCpfOuCnpj("554893780");
	cli.setEmail("amandha4@.com.br");
	clienteRepo.save(cli);
}


//Listar Cliente
@Test
public void ListaCliente() {
	List<Cliente> list = clienteRepo.findAll();
	assertThat(list).size().isGreaterThan(0);
	}

//Listar pelo ID
@Test 
public void idCliente() {
	Cliente cliente = clienteRepo.findById(1).get();
	assertEquals("Bibor", cliente.getNome());
}

//Update do cliente
@Test
public void updateCliente() {
	Cliente cliente = clienteRepo.findById(1).get();
	cliente.setNome("Bibor da Silva");
	clienteRepo.save(cliente);
	assertNotEquals("Bibor", cliente.getNome());
}


//Deletar 
@Test
public void deleteCliente() {
	clienteRepo.deleteById(2);
	assertThat(clienteRepo.existsById(2));
}
}