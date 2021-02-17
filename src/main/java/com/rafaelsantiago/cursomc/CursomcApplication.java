package com.rafaelsantiago.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelsantiago.cursomc.domain.Categoria;
import com.rafaelsantiago.cursomc.domain.Cidade;
import com.rafaelsantiago.cursomc.domain.Cliente;
import com.rafaelsantiago.cursomc.domain.Endereco;
import com.rafaelsantiago.cursomc.domain.Estado;
import com.rafaelsantiago.cursomc.domain.Produto;
import com.rafaelsantiago.cursomc.domain.enums.TipoCliente;
import com.rafaelsantiago.cursomc.repositories.CategoriaRepository;
import com.rafaelsantiago.cursomc.repositories.CidadeRepository;
import com.rafaelsantiago.cursomc.repositories.ClienteRepository;
import com.rafaelsantiago.cursomc.repositories.EnderecoRepository;
import com.rafaelsantiago.cursomc.repositories.EstadoRepository;
import com.rafaelsantiago.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRep;
	@Autowired
	private CidadeRepository cidRep;
	@Autowired
	private EstadoRepository estRep;
	@Autowired
	private EnderecoRepository endRep;
	@Autowired
	private ClienteRepository cliRep;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",20.00);
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","11111111111",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 203","Jardim","38777034",cli1,c1);
		Endereco e2 = new Endereco(null,"Av Matos","105","Sala 800","Centro","38777012",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		System.out.println("*****************************************************************");
		System.out.println(est1.getCidades());
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		System.out.println("*****************************************************************");
		System.out.println(cat1.getProdutos());
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		catRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
		estRep.saveAll(Arrays.asList(est1,est2));
		cidRep.saveAll(Arrays.asList(c1,c2,c3));
		cliRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(e1,e2));
	}

}
