package javabeans;

import java.util.Date;

public class Personnes {

	private Integer idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private Date dateNaissancePersonne;
	
	public Personnes(String nomPersonne, String prenomPersonne, Date dateNaissancePersonne) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.dateNaissancePersonne = dateNaissancePersonne;
	}

	public Personnes() {
		super();
	}

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public Date getDateNaissancePersonne() {
		return dateNaissancePersonne;
	}

	public void setDateNaissancePersonne(Date dateNaissancePersonne) {
		this.dateNaissancePersonne = dateNaissancePersonne;
	}	
	
}
