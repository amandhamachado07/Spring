package com.amandhamachado.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amandhamachado.senai.domain.Estado;
import com.amandhamachado.senai.repositories.EstadoRepository;




@SpringBootTest
public class EstadoTest {
	@Autowired
	EstadoRepository estadoRepo;

	@Test
	void Estado () {
		Estado est = new Estado();
		est.setId(1);
		est.setNome("Minas Gerais");
        est.setCidades(null);
        estadoRepo.save(est);
	}


	//Listar Cliente
	@Test
	public void ListaEstado() {
		List<Estado> list = estadoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		}

	//Listar pelo ID
	@Test 
	public void id() {
		Estado estado = estadoRepo.findById(1).get();
		assertEquals("Minas", estado.getNome());
	}

	//Update do cliente
	@Test
	public void updateEstado() {
		Estado estado = estadoRepo.findById(1).get();
		estado.setNome("Minas Gerais");
		estadoRepo.save(estado);
		assertNotEquals("Minas", estado.getNome());
	}



	//Deletar 
	@Test
	public void deleteEstado() {
		estadoRepo.deleteById(2);
		assertThat(estadoRepo.existsById(2));
	}
	}






