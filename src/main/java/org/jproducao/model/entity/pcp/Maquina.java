package org.jproducao.model.entity.pcp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maquina{
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100)
	private String descricao;

	@Column(length = 255)
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "id_setor")
	private Setor setor;

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