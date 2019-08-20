package br.com.acc.slc.vo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe responsavel por modelar a entidade morador
 * 
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:11:55
 */
@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String cel;
    private String email;
    private Calendar dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "nivel2_id")
    private Nivel2 nivel2;

    public Morador() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	this.rg = rg;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getCel() {
	return cel;
    }

    public void setCel(String cel) {
	this.cel = cel;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Calendar getDataDeNascimento() {
	return dataDeNascimento;
    }

    public void setDataDeNascimento(Calendar dataDeNascimento) {
	this.dataDeNascimento = dataDeNascimento;
    }

    public Nivel2 getNivel2() {
	return nivel2;
    }

    public void setNivel2(Nivel2 nivel2) {
	this.nivel2 = nivel2;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Morador other = (Morador) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
