package repositorios;

import entidades.Pessoa;

import java.util.ArrayList;

public class PessoaFakeRepository {

    private ArrayList<Pessoa> data = new ArrayList<Pessoa>();

    public void save(Pessoa pessoa){
        data.add(pessoa);
    }

    public void delete(String cpf){
        for (Pessoa pessoa : data) {
            if (pessoa.getCpf().equals(cpf)) {
                data.remove(pessoa);
            }
        }
    }


    public ArrayList<Pessoa> findAll() {
        return data;
    }
}
