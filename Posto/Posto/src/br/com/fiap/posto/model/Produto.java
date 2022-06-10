package br.com.fiap.posto.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String preco;
	private float stars;
	private String plug;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}


	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public String getTipoPlug() {
		return plug;
	}

	public void setTipoPlug(String plug) {
		this.plug = plug;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", rua=" + rua + ", numero=" + numero +", bairro=" + bairro +", cidade=" + cidade +", estado=" + estado +", preço=" + preco +", avaliação=" + Float.toString(stars) +", Plugs=" + plug +"]";
	}

	public Vector<String> getData(){
		Vector<String> data = new Vector<String>();
		//data.add(Long.toString(id));
		data.add(nome);
		data.add(rua);
		data.add(numero);
		data.add(bairro);
		data.add(cidade);
		data.add(estado);
		data.add(preco);
		data.add(Float.toString(stars));
		data.add(plug);

		return data;
	}
		
}
