package br.edu.fateczl.crud_cliente_maven.controller;

import br.edu.fateczl.crud_cliente_maven.model.Cliente;
import br.edu.fateczl.crud_cliente_maven.persistence.ClienteDAO;
import br.edu.fateczl.crud_cliente_maven.persistence.GenericDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public ClienteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String cmd = request.getParameter("botao");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String limite = request.getParameter("limite_credito");
        String dt_nasc = request.getParameter("data_nasc");

        String saida = "";
        String erro = "";
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();

        if (!cmd.equalsIgnoreCase("listar"))
            cliente.setCpf(cpf);
        if (cmd.equalsIgnoreCase("cadastrar") || cmd.equalsIgnoreCase("alterar"))
        {
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setLimite_credito(Double.parseDouble(limite));
            cliente.setDt_nasc(Date.valueOf(dt_nasc));
        }

        try
        {
            if (cmd.equalsIgnoreCase("cadastrar"))
            {
                saida = inserirCliente(cliente);
                cliente = new Cliente();
            }
            if (cmd.equalsIgnoreCase("alterar"))
            {
                saida = alterarCliente(cliente);
                cliente = new Cliente();
            }
            if (cmd.equalsIgnoreCase("excluir"))
            {
                saida = excluirCliente(cliente);
                cliente = new Cliente();
            }
            if (cmd.equalsIgnoreCase("buscar"))
                cliente = buscarCliente(cliente);
            if (cmd.equalsIgnoreCase("listar"))
                clientes = listarClientes();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            erro = e.getMessage();
        }
        finally
        {
            request.setAttribute("saida", saida);
            request.setAttribute("erro", erro);
            request.setAttribute("cliente", cliente);
            request.setAttribute("clientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
            rd.forward(request, response);

        }

    }

    private String inserirCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        GenericDAO gdao = new GenericDAO();
        ClienteDAO clienteDAO = new ClienteDAO(gdao);
        return clienteDAO.insert(cliente);
    }

    private String alterarCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        GenericDAO gdao = new GenericDAO();
        ClienteDAO clienteDAO = new ClienteDAO(gdao);
        return clienteDAO.update(cliente);
    }

    private String excluirCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        GenericDAO gdao = new GenericDAO();
        ClienteDAO clienteDAO = new ClienteDAO(gdao);
        return clienteDAO.delete(cliente);
    }

    private Cliente buscarCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        GenericDAO gdao = new GenericDAO();
        ClienteDAO clienteDAO = new ClienteDAO(gdao);
        return clienteDAO.find(cliente);
    }

    private List<Cliente> listarClientes() throws SQLException, ClassNotFoundException
    {
        List<Cliente> clientes;

        GenericDAO gdao = new GenericDAO();
        ClienteDAO clienteDAO = new ClienteDAO(gdao);
        clientes = clienteDAO.list();

        return clientes;
    }
}