package br.com.spinapp.junit;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.ServerpinDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Serverpin;

public class ServerpinDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException {
		
		Serverpin s = new Serverpin();
		Cliente c = new Cliente();
		
		
		s.setIp("192.168.100.1");
		s.setMac("40-61-6-CF-1C-E6");
		s.setPorta(3);
		s.setLatitude(23F);
		s.setLongitude(10F);
		s.setAltitude(2F);
		s.setGsm("(12)9876-5432");
			
		c.setIdcliente(2L);
		
		s.setCliente_idcliente(c);


		ServerpinDAO dao = new ServerpinDAO();
		dao.inserir(s);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Serverpin s = new Serverpin();
		s.setIdserver(5l);

		ServerpinDAO dao = new ServerpinDAO();

		dao.excluir(s);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException {

		Serverpin s = new Serverpin();
		Cliente c = new Cliente();
		
		s.setIp("200.168.100.10");
		s.setMac("56-20-10-CF-1C-E6");
		s.setPorta(4);
		s.setLatitude(15F);
		s.setLongitude(1F);
		s.setAltitude(2F);
		s.setGsm("(12) 9876-5432");
			
		c.setIdcliente(1L);
		
		s.setCliente_idcliente(c);


		ServerpinDAO dao = new ServerpinDAO();
		dao.inserir(s);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ServerpinDAO dao = new ServerpinDAO();
		
		ArrayList<Serverpin> lista = dao.listar();
		
		for(Serverpin s : lista){
			
			
			System.out.println("\nID servidor: "+s.getIdserver());
			System.out.println("IP: "+s.getIp());
			System.out.println("Mac: "+s.getMac());
			System.out.println("Porta: "+s.getPorta());
			System.out.println("Latitude: "+s.getLatitude());
			System.out.println("Longitude: "+s.getLongitude());
			System.out.println("Altitude: "+s.getAltitude());
			System.out.println("GSM: "+s.getGsm());
			
			System.out.println("\nID cliente: "+s.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+s.getCliente_idcliente().getNome());
			System.out.println("Celular: "+s.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+s.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+s.getCliente_idcliente().getCpf());
			System.out.println("RG: "+s.getCliente_idcliente().getRg());
			System.out.println("Email: "+s.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+s.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+s.getCliente_idcliente().getCnpj());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Serverpin sp = new Serverpin();

		sp.setIdserver(24L);

		ServerpinDAO dao = new ServerpinDAO();

		ArrayList<Serverpin> lista = dao.listarPorId(sp);

		for(Serverpin s : lista){
			
			
			System.out.println("\nID servidor: "+s.getIdserver());
			System.out.println("IP: "+s.getIp());
			System.out.println("Mac: "+s.getMac());
			System.out.println("Porta: "+s.getPorta());
			System.out.println("Latitude: "+s.getLatitude());
			System.out.println("Longitude: "+s.getLongitude());
			System.out.println("Altitude: "+s.getAltitude());
			System.out.println("GSM: "+s.getGsm());
			
			System.out.println("\nID cliente: "+s.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+s.getCliente_idcliente().getNome());
			System.out.println("Celular: "+s.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+s.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+s.getCliente_idcliente().getCpf());
			System.out.println("RG: "+s.getCliente_idcliente().getRg());
			System.out.println("Email: "+s.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+s.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+s.getCliente_idcliente().getCnpj());
						
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void listarPorIp() throws SQLException {

		Serverpin sp = new Serverpin();
		
		sp.setIp("200.168.100.10");
		
		ServerpinDAO dao = new ServerpinDAO();

		ArrayList<Serverpin> lista = dao.listarPorIp(sp);

		for(Serverpin s : lista){

			System.out.println("\nID servidor: "+s.getIdserver());
			System.out.println("IP: "+s.getIp());
			System.out.println("Mac: "+s.getMac());
			System.out.println("Porta: "+s.getPorta());
			System.out.println("Latitude: "+s.getLatitude());
			System.out.println("Longitude: "+s.getLongitude());
			System.out.println("Altitude: "+s.getAltitude());
			System.out.println("GSM: "+s.getGsm());
			
			System.out.println("\nID cliente: "+s.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+s.getCliente_idcliente().getNome());
			System.out.println("Celular: "+s.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+s.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+s.getCliente_idcliente().getCpf());
			System.out.println("RG: "+s.getCliente_idcliente().getRg());
			System.out.println("Email: "+s.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+s.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+s.getCliente_idcliente().getCnpj());
									
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Serverpin sp = new Serverpin();

		sp.setIdserver(23L);

		ServerpinDAO dao = new ServerpinDAO();

		Serverpin s = dao.pesquisar(sp);


		System.out.println("\nID servidor: "+s.getIdserver());
		System.out.println("IP: "+s.getIp());
		System.out.println("Mac: "+s.getMac());
		System.out.println("Porta: "+s.getPorta());
		System.out.println("Latitude: "+s.getLatitude());
		System.out.println("Longitude: "+s.getLongitude());
		System.out.println("Altitude: "+s.getAltitude());
		System.out.println("GSM: "+s.getGsm());
		
		System.out.println("\nID cliente: "+s.getCliente_idcliente().getIdcliente());
		System.out.println("Nome: "+s.getCliente_idcliente().getNome());
		System.out.println("Celular: "+s.getCliente_idcliente().getCelular());
		System.out.println("Endereço: "+s.getCliente_idcliente().getEndereco());
		System.out.println("CPF: "+s.getCliente_idcliente().getCpf());
		System.out.println("RG: "+s.getCliente_idcliente().getRg());
		System.out.println("Email: "+s.getCliente_idcliente().getEmail());
		System.out.println("Senha: "+s.getCliente_idcliente().getSenha());
		System.out.println("CNPJ: "+s.getCliente_idcliente().getCnpj());
					
		System.out.println("\n********** ********** **********");
	}
}