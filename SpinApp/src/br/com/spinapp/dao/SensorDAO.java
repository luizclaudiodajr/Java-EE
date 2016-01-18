package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.factory.ConexaoFactory;

public class SensorDAO {
    public void inserir(Sensor s) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.sensor ");// append juntar
	sql.append(" (equipamento_idequip, tipo_sensor_idtipo) ");
	sql.append(" VALUES (?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, s.getEquipamento_idequip().getIdequip());
	comando.setLong(2, s.getTiposensor_idtipo().getIdtipo());

	comando.executeUpdate();
    }

    public void excluir(Sensor s) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.sensor ");
	sql.append(" WHERE idsensor = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, s.getIdsensor());

	comando.executeUpdate();

    }

    public void atualizar(Sensor s) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.sensor ");
	sql.append(" SET equipamento_idequip = ?, tipo_sensor_idtipo = ? ");
	sql.append(" WHERE idsensor = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, s.getEquipamento_idequip().getIdequip());
	comando.setLong(2, s.getTiposensor_idtipo().getIdtipo());
	comando.setLong(3, s.getIdsensor());

	comando.executeUpdate();
    }

    public ArrayList<Sensor> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idsensor, e.idequip, e.mac, e.latitude, e.longitude, e.altitude, ts.idtipo, ts.descricao, ts.unidade ");
	sql.append(" FROM spin1.sensor s ");
	sql.append(" INNER JOIN spin1.equipamento e ON e.idequip = s.equipamento_idequip ");
	sql.append(" INNER JOIN spin1.tipo_sensor ts ON ts.idtipo = s.tipo_sensor_idtipo ");
	// sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Sensor> lista = new ArrayList<Sensor>();

	while (resultado.next()) {

	    Sensor s = new Sensor();
	    Equipamento e = new Equipamento();
	    TipoSensor ts = new TipoSensor();

	    s.setIdsensor(resultado.getLong("s.idsensor"));

	    e.setIdequip(resultado.getLong("e.idequip"));
	    e.setMac(resultado.getString("e.mac"));
	    e.setLatitude(resultado.getFloat("e.latitude"));
	    e.setLongitude(resultado.getFloat("e.longitude"));
	    e.setAltitude(resultado.getFloat("e.altitude"));

	    ts.setIdtipo(resultado.getLong("ts.idtipo"));
	    ts.setDescricao(resultado.getString("ts.descricao"));
	    ts.setUnidade(resultado.getString("ts.unidade"));

	    s.setEquipamento_idequip(e);
	    s.setTiposensor_idtipo(ts);

	    lista.add(s);

	}
	return lista;
    }

    public ArrayList<Sensor> listarPorId(Sensor se) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idsensor, e.idequip, e.mac, e.latitude, e.longitude, e.altitude, ts.idtipo, ts.descricao, ts.unidade ");
	sql.append(" FROM spin1.sensor s ");
	sql.append(" INNER JOIN spin1.equipamento e ON e.idequip = s.equipamento_idequip ");
	sql.append(" INNER JOIN spin1.tipo_sensor ts ON ts.idtipo = s.tipo_sensor_idtipo ");
	sql.append(" WHERE s.idsensor = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, se.getIdsensor());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Sensor> lista = new ArrayList<Sensor>();

	while (resultado.next()) {

	    Sensor s = new Sensor();
	    Equipamento e = new Equipamento();
	    TipoSensor ts = new TipoSensor();

	    s.setIdsensor(resultado.getLong("s.idsensor"));

	    e.setIdequip(resultado.getLong("e.idequip"));
	    e.setMac(resultado.getString("e.mac"));
	    e.setLatitude(resultado.getFloat("e.latitude"));
	    e.setLongitude(resultado.getFloat("e.longitude"));
	    e.setAltitude(resultado.getFloat("e.altitude"));

	    ts.setIdtipo(resultado.getLong("ts.idtipo"));
	    ts.setDescricao(resultado.getString("ts.descricao"));
	    ts.setUnidade(resultado.getString("ts.unidade"));

	    s.setEquipamento_idequip(e);
	    s.setTiposensor_idtipo(ts);

	    lista.add(s);
	}
	return lista;
    }

    public ArrayList<Sensor> listarPorIdequipamento(Sensor se) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idsensor, e.idequip, e.mac, e.latitude, e.longitude, e.altitude, ts.idtipo, ts.descricao, ts.unidade ");
	sql.append(" FROM spin1.sensor s ");
	sql.append(" INNER JOIN spin1.equipamento e ON e.idequip = s.equipamento_idequip ");
	sql.append(" INNER JOIN spin1.tipo_sensor ts ON ts.idtipo = s.tipo_sensor_idtipo ");
	sql.append(" WHERE e.idequip = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, se.getEquipamento_idequip().getIdequip());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Sensor> lista = new ArrayList<Sensor>();

	while (resultado.next()) {

	    Sensor s = new Sensor();
	    Equipamento e = new Equipamento();
	    TipoSensor ts = new TipoSensor();

	    s.setIdsensor(resultado.getLong("s.idsensor"));

	    e.setIdequip(resultado.getLong("e.idequip"));
	    e.setMac(resultado.getString("e.mac"));
	    e.setLatitude(resultado.getFloat("e.latitude"));
	    e.setLongitude(resultado.getFloat("e.longitude"));
	    e.setAltitude(resultado.getFloat("e.altitude"));

	    ts.setIdtipo(resultado.getLong("ts.idtipo"));
	    ts.setDescricao(resultado.getString("ts.descricao"));
	    ts.setUnidade(resultado.getString("ts.unidade"));

	    s.setEquipamento_idequip(e);
	    s.setTiposensor_idtipo(ts);

	    lista.add(s);
	}
	return lista;
    }

    public Sensor pesquisar(Sensor se) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idsensor, e.idequip, e.mac, e.latitude, e.longitude, e.altitude, ts.idtipo, ts.descricao, ts.unidade ");
	sql.append(" FROM spin1.sensor s ");
	sql.append(" INNER JOIN spin1.equipamento e ON e.idequip = s.equipamento_idequip ");
	sql.append(" INNER JOIN spin1.tipo_sensor ts ON ts.idtipo = s.tipo_sensor_idtipo ");
	sql.append(" WHERE s.idsensor = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, se.getIdsensor());

	ResultSet resultado = comando.executeQuery();

	Sensor retorno = null;

	if (resultado.next()) {

	    retorno = new Sensor();
	    Equipamento e = new Equipamento();
	    TipoSensor ts = new TipoSensor();

	    retorno.setIdsensor(resultado.getLong("s.idsensor"));

	    e.setIdequip(resultado.getLong("e.idequip"));
	    e.setMac(resultado.getString("e.mac"));
	    e.setLatitude(resultado.getFloat("e.latitude"));
	    e.setLongitude(resultado.getFloat("e.longitude"));
	    e.setAltitude(resultado.getFloat("e.altitude"));

	    ts.setIdtipo(resultado.getLong("ts.idtipo"));
	    ts.setDescricao(resultado.getString("ts.descricao"));
	    ts.setUnidade(resultado.getString("ts.unidade"));

	    retorno.setEquipamento_idequip(e);
	    retorno.setTiposensor_idtipo(ts);

	}

	return retorno;
    }
}