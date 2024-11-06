package backend;

import java.util.ArrayList;
import java.util.List;

public class CadastroDeInstituicao<T extends Instituicao> {
    private String tipo;
    private List<T> instituicoes = new ArrayList<>();

    public CadastroDeInstituicao(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Validação de CNPJ
    private boolean isCNPJValido(String cnpj) {
        // Garante que tenha 14 dígitos
        String cnpjValidacao = String.format("%014d", Long.parseLong(cnpj));
        if (cnpjValidacao.length() != 14) {
            return false;
        }

        // Validação dos dígitos verificadores
        int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int somaValidacaoCNPJ = 0;
        for (int i = 0; i < 12; i++) {
            somaValidacaoCNPJ += Character.getNumericValue(cnpjValidacao.charAt(i)) * peso1[i];
        }
        int restoValidacaoCNPJ = somaValidacaoCNPJ % 11;
        int digito1 = (restoValidacaoCNPJ < 2) ? 0 : 11 - restoValidacaoCNPJ;

        somaValidacaoCNPJ = 0;
        for (int i = 0; i < 13; i++) {
            somaValidacaoCNPJ += Character.getNumericValue(cnpjValidacao.charAt(i)) * peso2[i];
        }
        restoValidacaoCNPJ = somaValidacaoCNPJ % 11;
        int digito2 = (restoValidacaoCNPJ < 2) ? 0 : 11 - restoValidacaoCNPJ;

        return digito1 == Character.getNumericValue(cnpjValidacao.charAt(12)) && digito2 == Character.getNumericValue(cnpjValidacao.charAt(13));
    }

    // Verificar se o CNPJ já existe na lista
    private boolean isCNPJDuplicado(String cnpj) {
        for (T instituicao : instituicoes) {
            if (instituicao.getCNPJ().equals(cnpj)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarInstituicao(T instituicao) {
        if (isCNPJDuplicado(instituicao.getCNPJ())) {
            System.out.println("Erro: CNPJ já existe no sistema.");
        } else if (!isCNPJValido(instituicao.getCNPJ())) {
            System.out.println("Erro: CNPJ inválido.");
        } else {
            instituicoes.add(instituicao);
            System.out.println("Instituição adicionada com sucesso!");
        }
    }

    // Listar todas as instituições
    public List<T> listaInstituicoes() {
        return instituicoes;
    }

    // Buscar pela instituição pelo CNPJ
    public T buscarInstituicaoPorCNPJ(String cnpjBusca) {
        for (T instituicao : instituicoes) {
            if (instituicao.getCNPJ().equals(cnpjBusca)) {
                return instituicao;
            }
        }
        return null;
    }

    public boolean atualizarInstituicao(String cnpjAtualizar, T novaInstituicao) {
        T instituicao = buscarInstituicaoPorCNPJ(cnpjAtualizar);
        if (instituicao != null) {
            if (!isCNPJValido(novaInstituicao.getCNPJ())) {
                System.out.println("Erro: Novo CNPJ inválido.");
                return false;
            } else if (!cnpjAtualizar.equals(novaInstituicao.getCNPJ()) && isCNPJDuplicado(novaInstituicao.getCNPJ())) {
                System.out.println("Erro: Novo CNPJ já existe no sistema.");
                return false;
            }
            // Atualizar dados da instituição
            instituicao.setNome(novaInstituicao.getNome());
            instituicao.setCNPJ(novaInstituicao.getCNPJ());
            instituicao.setTempoDoProjeto(novaInstituicao.getTempoDoProjeto());
            instituicao.setTelefone(novaInstituicao.getTelefone());
            instituicao.setCelular(novaInstituicao.getCelular());
            instituicao.setRua(novaInstituicao.getRua());
            instituicao.setCEP(novaInstituicao.getCEP());
            instituicao.setNumeroCasa(novaInstituicao.getNumeroCasa());
            instituicao.setEstado(novaInstituicao.getEstado());
            instituicao.setBairro(novaInstituicao.getBairro());
            instituicao.setCidade(novaInstituicao.getCidade());
            instituicao.setDescricao(novaInstituicao.getDescricao());
            instituicao.setComplementoDoEndereco(novaInstituicao.getComplementoDoEndereco());
            instituicao.setPrecisoDe(novaInstituicao.getPrecisoDe());
            System.out.println("Instituição atualizada com sucesso!");
            return true;
        } else {
            System.out.println("Instituição com CNPJ " + cnpjAtualizar + " não encontrada.");
            return false;
        }
    }

    public boolean removerInstituicao(String cnpjRemover) {
        T instituicao = buscarInstituicaoPorCNPJ(cnpjRemover);
        if (instituicao != null) {
            instituicoes.remove(instituicao);
            System.out.println("Instituição removida com sucesso!");
            return true;
        } else {
            System.out.println("Instituição com CNPJ " + cnpjRemover + " não encontrada.");
            return false;
        }
    }
}
