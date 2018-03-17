package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Pessoa {
	
	@Id
	@Column
	private String cpf;
	@Column
	private String nome;

}
