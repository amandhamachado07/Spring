package com.amandhamachado.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amandhamachado.senai.domain.Cidade;
import com.amandhamachado.senai.repositories.CidadeRepository;




@SpringBootTest
public class CidadeTest {
	@Autowired
	CidadeRepository cidadeRepo;

	@Test
	void Cidade () {
		Cidade cid = new Cidade();
		cid.setId(1);
		cid.setNome("Uberlândia");
        cid.setEstado(null);
        cidadeRepo.save(cid);
	}


	//Listar Cliente
	@Test
	public void ListaCidade() {
		List<Cidade> list = cidadeRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		}

	//Listar pelo ID
	@Test 
	public void id() {
		Cidade cidade = cidadeRepo.findById(1).get();
		assertEquals("Uberlândia", cidade.getNome());
	}

	//Update do cliente
	@Test
	public void updateCidade() {
		Cidade cidade = cidadeRepo.findById(1).get();
		cidade.setNome("Uberlândia");
		cidadeRepo.save(cidade);
		assertNotEquals("Uberlandia", cidade.getNome());
	}


	//Deletar 
	@Test
	public void deleteCidade() {
		cidadeRepo.deleteById(2);
		assertThat(cidadeRepo.existsById(2));
	}
	}



