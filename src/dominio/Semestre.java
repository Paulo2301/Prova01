package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semestre implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private Integer ano;
	private Integer periodo;
	
	public Semestre() {
	}
	
	public Semestre(Integer id, Integer ano, Integer periodo) {
		super();
		this.id = id;
		this.ano = ano;
		this.periodo = periodo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", ano=" + ano + ", periodo=" + periodo + "]";
	}
	
	

}
