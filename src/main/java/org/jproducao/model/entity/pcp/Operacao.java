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
public class Operacao{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_processo")
	private Processo processo;

	@Column
	private Integer ordinal;

	@Column(length = 100)
	private String descricao;

	@Column
	private double tempo;

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