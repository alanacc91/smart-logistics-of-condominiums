package br.com.acc.slc.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe reponsavel por modelar a entidade Nivel2
 *
 * @author Alan Cristian Cardoso | alan.acc91@gmail.com 12 de ago de 2019 |
 *         20:07:59
 */
public class Nivel2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "nivel1_id")
    private Nivel1 nivel1;
    private String andar;

    public Nivel2() {
	super();

	this.nivel1 = new Nivel1();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public Nivel1 getNivel1() {
	return nivel1;
    }

    public void setNivel1(Nivel1 nivel1) {
	this.nivel1 = nivel1;
    }

    public String getAndar() {
	return andar;
    }

    public void setAndar(String andar) {
	this.andar = andar;
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
	Nivel2 other = (Nivel2) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
