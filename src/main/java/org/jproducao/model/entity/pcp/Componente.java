package org.jproducao.model.entity.pcp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Componente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 10)
	@NotEmpty(message = "{campo.codigo_componente.obrigatorio}")
	private String codigo;

	@Column(length = 100)
	private String descricao;

	@Column(name = "data_criacao",updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	@Column(name = "data_update")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate update;

	@PrePersist
	public void prePersist(){
		setData(LocalDate.now());
		setUpdate(LocalDate.now());
	}
	
}
