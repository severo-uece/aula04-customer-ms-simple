package br.uece.ees.aom.aula04.customerms.model;

public class SimpleCustomer {

    private static Long ID_SEQUENCE = 1L;

    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private Boolean ativo;

    public SimpleCustomer(String nome, Integer idade, String email){
        this.id = ID_SEQUENCE++;
        this.nome = nome;
        this.idade = idade;
        this.email =email;
        this.ativo = Boolean.TRUE;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s, %d anos %s", this.id, this.nome, this.idade, this.ativo ? "" : " /INATIVO/");
    }
}