package com.amandhamachado.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amandhamachado.senai.domain.Endereco;
import com.amandhamachado.senai.repositories.EnderecoRepository;



@SpringBootTest
public class EnderecoTest {

	@Autowired
	EnderecoRepository enderecoRepo;

	@Test
	void Cliente () {
		Endereco end = new Endereco();
		end.setId(1);
		end.setBairro("Jardins");
        end.getLogradouro();
        end.setNumero("120");
        end.setComplemento("");
		end.setCep("1123740");
		enderecoRepo.save(end);
	}


	//Listar Cliente
	@Test
	public void ListaEndereco() {
		List<Endereco> list = enderecoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		}

	//Listar pelo ID
	@Test 
	public void id() {
		Endereco endereco = enderecoRepo.findById(1).get();
		assertEquals("Jardins", endereco.getBairro());
	}

	//Update do cliente
	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepo.findById(1).get();
		endereco.setBairro("Jardins Silvestre");
		enderecoRepo.save(endereco);
		assertNotEquals("Jardins", endereco.getBairro());
	}


	//Deletar 
	@Test
	public void deleteEndereco() {
		enderecoRepo.deleteById(2);
		assertThat(enderecoRepo.existsById(2));
	}
	}
