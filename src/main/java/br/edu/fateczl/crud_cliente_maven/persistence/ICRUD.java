package br.edu.fateczl.crud_cliente_maven.persistence;

import java.sql.SQLException;
import java.util.List;

public interface ICRUD<T>
{
    public String insert (T t)	throws SQLException, ClassNotFoundException;
    public String update (T t)	throws SQLException, ClassNotFoundException;
    public String delete (T t)    throws SQLException, ClassNotFoundException;
    public T find (T t)         throws SQLException, ClassNotFoundException;
    public List<T> list ()    	    throws SQLException, ClassNotFoundException;
}
