package backend;

public class Instituicao {
    private String nome;
    private String cnpj;
    private String tempoDoProjeto;
    private int telefone;
    private int celular;
    private int cep;
    private int numeroCasa;
    private String estado;
    private String bairro;
    private String rua;
    private String cidade;
    private String descricao;
    private String complementoDoEndereco;
    private String precisoDe;
    

    // Construtor que recebe todos os atributos
    public Instituicao(String nome, String cnpj, String tempoDoProjeto, int telefone, int celular, int cep, int numeroCasa,
                       String estado, String bairro, String rua, String cidade, String descricao, String complementoDoEndereco, String precisoDe) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.tempoDoProjeto = tempoDoProjeto;
        this.telefone = telefone;
        this.celular = celular;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.cidade = cidade;
        this.descricao = descricao;
        this.complementoDoEndereco = complementoDoEndereco;
        this.precisoDe = precisoDe;
    }
    
    // Getters e Setters para cada atributo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTempoDoProjeto() {
        return tempoDoProjeto;
    }

    public void setTempoDoProjeto(String tempoDoProjeto) {
        this.tempoDoProjeto = tempoDoProjeto;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getCEP() {
        return cep;
    }

    public void setCEP(int cep) {
        this.cep = cep;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComplementoDoEndereco() {
        return complementoDoEndereco;
    }

    public void setComplementoDoEndereco(String complementoDoEndereco) {
        this.complementoDoEndereco = complementoDoEndereco;
    }

    public String getPrecisoDe() {
        return precisoDe;
    }

    public void setPrecisoDe(String precisoDe) {
        this.precisoDe = precisoDe;
    }
}
