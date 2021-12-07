package com.amandhamachado.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;


import com.amandhamachado.senai.domain.Cliente;
import com.amandhamachado.senai.domain.Estado;
import com.amandhamachado.senai.domain.enuns.TipoCliente;
import com.amandhamachado.senai.repositories.ClienteRepository;
import com.amandhamachado.senai.repositories.EstadoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		Estado est1 = new Estado(null,"Minas Gerais", null);
		Estado est2 = new Estado(null,"São Paulo", null);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cliente cli1 = new Cliente(null,"Amandha Machado", "1123455670", "amandhamm.com.br",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("22324778008", "11233599087"));
		clienteRepository.saveAll (Arrays.asList(cli1));
				
	}

}
