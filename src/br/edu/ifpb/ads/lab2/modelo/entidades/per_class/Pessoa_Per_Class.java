package br.edu.ifpb.ads.lab2.modelo.entidades.per_class;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "PER_CLASS_PESSOA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa_Per_Class implements Serializable {

    @TableGenerator(name = "SEQUENCIA_PESSOA",
            table = "PER_CLASS_GERADOR_SEQUENCIAIS",
            pkColumnName = "PRIMARY_KEY",
            valueColumnName = "VALOR_SEQUENCIAL_COLUNA_PK")

    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCIA_PESSOA")
    private long id;
    @Column(name = "NOME_PESSOA")
    private String nome;
    @Column(name = "MATRICULA_PESSOA")
    private long matricula;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa_Per_Class\nId: ");
		builder.append(id);
		builder.append("\nNome: ");
		builder.append(nome);
		builder.append("\nMatricula: ");
		builder.append(matricula);
		return builder.toString();
	}

}
