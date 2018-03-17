package repositorios;


import java.sql.SQLException;
import java.util.List;

import entidades.Pessoa;

public interface PessoaDAO {
    public void salvar(Pessoa pessoa) throws SQLException;
    public void alterar(Pessoa pessoa) throws SQLException;
    public void remover(Pessoa pessoa) throws SQLException;
    public Pessoa pesquisar(String cpf) throws SQLException;
    public List<Pessoa> recuperarTodos() throws SQLException;
}