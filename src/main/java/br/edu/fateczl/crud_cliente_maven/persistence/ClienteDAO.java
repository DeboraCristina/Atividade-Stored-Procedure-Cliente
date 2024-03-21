package br.edu.fateczl.crud_cliente_maven.persistence;

import br.edu.fateczl.crud_cliente_maven.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ICRUD<Cliente>
{
    GenericDAO gdao;

    public ClienteDAO(GenericDAO gDAO)
    {
        this.gdao = gDAO;
    }

    @Override
    public String insert(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        return execute_storage_procedure("I", cliente);
    }

    @Override
    public String update(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        return execute_storage_procedure("U", cliente);
    }

    @Override
    public String delete(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        return execute_storage_procedure("D", cliente);
    }

    @Override
    public Cliente find(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection connection = gdao.getConnection();
        String sql = "SELECT cpf, nome, email, limite_de_credito, dt_nacimento FROM cliente WHERE cpf = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, cliente.getCpf());

        ResultSet resultSet = p.executeQuery();
        if (resultSet.next())
        {
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setLimite_credito(resultSet.getDouble("limite_de_credito"));
            cliente.setDt_nasc(resultSet.getDate("dt_nacimento"));
        }

        resultSet.close();
        p.close();
        connection.close();
        return cliente;
    }

    @Override
    public List<Cliente> list() throws SQLException, ClassNotFoundException
    {
        List<Cliente> clientes = new ArrayList<>();
        Connection connection = gdao.getConnection();
        String sql = "SELECT cpf, nome, email, limite_de_credito, dt_nacimento FROM cliente";
        PreparedStatement p = connection.prepareStatement(sql);

        ResultSet resultSet = p.executeQuery();
        while (resultSet.next())
        {
            Cliente cliente = new Cliente();
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setLimite_credito(resultSet.getDouble("limite_de_credito"));
            cliente.setDt_nasc(resultSet.getDate("dt_nacimento"));
            clientes.add(cliente);
        }

        resultSet.close();
        p.close();
        connection.close();
        return clientes;
    }

    private String execute_storage_procedure(String modo, Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection c = gdao.getConnection();
        String query = "{CALL sp_crud_cliente (?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement cs = c.prepareCall(query);
        cs.setString(1, modo);
        cs.setString(2, cliente.getCpf());
        cs.setString(3, cliente.getNome());
        cs.setString(4, cliente.getEmail());
        cs.setDouble(5, cliente.getLimite_credito());
        cs.setDate(6, cliente.getDt_nasc());
        cs.registerOutParameter(7, Types.VARCHAR);
        cs.execute();
        String saida = cs.getString(7);

        cs.close();
        c.close();
        return saida;
    }
}
