package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.PlantacaoDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Plantacao;

public class PlantacaoDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Plantacao p = new Plantacao();

		SimpleDateFormat brasil = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = brasil.parse("2014-10-10");

		//brasil.format(d1);// converte date para String

		p.setData_plantio(d1);// para o banco tem que mandar Date
		p.setArea(20F);
		
		Planta pa = new Planta();
		Cliente c = new Cliente();
		
		pa.setIdplanta(1L);
		c.setIdcliente(2L);
		
		p.setCliente_idcliente(c);
		p.setPlanta_idplanta(pa);


		PlantacaoDAO dao = new PlantacaoDAO();
		dao.inserir(p);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Plantacao p = new Plantacao();
		p.setIdplantacao(5l);

		PlantacaoDAO dao = new PlantacaoDAO();

		dao.excluir(p);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Plantacao p = new Plantacao();

		SimpleDateFormat brasil = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = brasil.parse("2014-10-10");

		p.setIdplantacao(7L);
		p.setData_plantio(d1);
		p.setArea(12F);
		
		Planta pa = new Planta();
		Cliente c = new Cliente();
		
		pa.setIdplanta(3L);
		c.setIdcliente(2L);
		
		p.setCliente_idcliente(c);
		p.setPlanta_idplanta(pa);
				
		PlantacaoDAO dao = new PlantacaoDAO();
		dao.atualizar(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		PlantacaoDAO dao = new PlantacaoDAO();
		
		ArrayList<Plantacao> lista = dao.listar();
		
		for(Plantacao p : lista){
			
			
			System.out.println("\nID plantação: "+p.getIdplantacao());
			System.out.println("Data de plantio: "+p.getData_plantio());
			System.out.println("Area: "+p.getArea());
			
			System.out.println("\nID cliente: "+p.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+p.getCliente_idcliente().getNome());
			System.out.println("Celular: "+p.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+p.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+p.getCliente_idcliente().getCpf());
			System.out.println("RG: "+p.getCliente_idcliente().getRg());
			System.out.println("Email: "+p.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+p.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+p.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID planta: "+p.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+p.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+p.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+p.getPlanta_idplanta().getTmax());
			System.out.println("TOT: "+p.getPlanta_idplanta().getTot());
			System.out.println("IC: "+p.getPlanta_idplanta().getIc());
			System.out.println("UC: "+p.getPlanta_idplanta().getUc());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Plantacao plan = new Plantacao();

		plan.setIdplantacao(6L);

		PlantacaoDAO dao = new PlantacaoDAO();

		ArrayList<Plantacao> lista = dao.listarPorId(plan);

		for(Plantacao p : lista){
			

			System.out.println("\nID plantação: "+p.getIdplantacao());
			System.out.println("Data de plantio: "+p.getData_plantio());
			System.out.println("Area: "+p.getArea());
			
			System.out.println("\nID cliente: "+p.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+p.getCliente_idcliente().getNome());
			System.out.println("Celular: "+p.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+p.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+p.getCliente_idcliente().getCpf());
			System.out.println("RG: "+p.getCliente_idcliente().getRg());
			System.out.println("Email: "+p.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+p.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+p.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID planta: "+p.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+p.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+p.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+p.getPlanta_idplanta().getTmax());
			System.out.println("TOT: "+p.getPlanta_idplanta().getTot());
			System.out.println("IC: "+p.getPlanta_idplanta().getIc());
			System.out.println("UC: "+p.getPlanta_idplanta().getUc());
			
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void listarPorIDcliente() throws SQLException {

		Plantacao plan = new Plantacao();
		Cliente c = new Cliente();
		
		c.setIdcliente(3L);
		plan.setCliente_idcliente(c);
		
		PlantacaoDAO dao = new PlantacaoDAO();

		ArrayList<Plantacao> lista = dao.listarPorIdcliente(plan);

		for(Plantacao p : lista){
			
		
			System.out.println("\nID plantação: "+p.getIdplantacao());
			System.out.println("Data de plantio: "+p.getData_plantio());
			System.out.println("Area: "+p.getArea());
			
			System.out.println("\nID cliente: "+p.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+p.getCliente_idcliente().getNome());
			System.out.println("Celular: "+p.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+p.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+p.getCliente_idcliente().getCpf());
			System.out.println("RG: "+p.getCliente_idcliente().getRg());
			System.out.println("Email: "+p.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+p.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+p.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID planta: "+p.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+p.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+p.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+p.getPlanta_idplanta().getTmax());
			System.out.println("TOT: "+p.getPlanta_idplanta().getTot());
			System.out.println("IC: "+p.getPlanta_idplanta().getIc());
			System.out.println("UC: "+p.getPlanta_idplanta().getUc());
			
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {

		Plantacao plan = new Plantacao();

		plan.setIdplantacao(6l);

		PlantacaoDAO dao = new PlantacaoDAO();

		Plantacao p = dao.pesquisar(plan);


		System.out.println("\nID plantação: "+p.getIdplantacao());
		System.out.println("Data de plantio: "+p.getData_plantio());
		System.out.println("Area: "+p.getArea());
		
		System.out.println("\nID cliente: "+p.getCliente_idcliente().getIdcliente());
		System.out.println("Nome: "+p.getCliente_idcliente().getNome());
		System.out.println("Celular: "+p.getCliente_idcliente().getCelular());
		System.out.println("Endereço: "+p.getCliente_idcliente().getEndereco());
		System.out.println("CPF: "+p.getCliente_idcliente().getCpf());
		System.out.println("RG: "+p.getCliente_idcliente().getRg());
		System.out.println("Email: "+p.getCliente_idcliente().getEmail());
		System.out.println("Senha: "+p.getCliente_idcliente().getSenha());
		System.out.println("CNPJ: "+p.getCliente_idcliente().getCnpj());
	
		System.out.println("\nID planta: "+p.getPlanta_idplanta().getIdplanta());
		System.out.println("Nome: "+p.getPlanta_idplanta().getNome());
		System.out.println("Tmin: "+p.getPlanta_idplanta().getTmin());
		System.out.println("Tmax: "+p.getPlanta_idplanta().getTmax());
		System.out.println("TOT: "+p.getPlanta_idplanta().getTot());
		System.out.println("IC: "+p.getPlanta_idplanta().getIc());
		System.out.println("UC: "+p.getPlanta_idplanta().getUc());
		
		System.out.println("\n********** ********** **********");
	}
}
