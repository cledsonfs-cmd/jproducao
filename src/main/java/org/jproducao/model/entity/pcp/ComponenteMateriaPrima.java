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
public class ComponenteMateriaPrima{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_componente")
	private Componente componente;

	@ManyToOne
	@JoinColumn(name = "id_materia_prima")
	private MateriaPrima materiaPrima;

	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;

	@Column
	private Double quantidade;

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
