package com.example.jpah2demo;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private int idade;
    @Column
    private String email;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefones_id")
    private List<Telefone> listaDeTelefones;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecos_id")
    private List<Endereco> listaDeEndereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, int idade, String email, List<Telefone> listaDeTelefones, List<Endereco> listaDeEndereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.listaDeTelefones = listaDeTelefones;
        this.listaDeEndereco = listaDeEndereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getListaDeTelefones() {
        return listaDeTelefones;
    }

    public void setListaDeTelefones(List<Telefone> listaDeTelefones) {
        this.listaDeTelefones = listaDeTelefones;
    }

    public List<Endereco> getListaDeEndereco() {
        return listaDeEndereco;
    }

    public void setListaDeEndereco(List<Endereco> listaDeEndereco) {
        this.listaDeEndereco = listaDeEndereco;
    }
}
