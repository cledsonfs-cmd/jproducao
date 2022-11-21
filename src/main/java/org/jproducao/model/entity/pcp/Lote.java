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
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 7)
    private String codigo;

    @Column(length = 255)
    private String observacao;

    @Column(name = "data_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate update;

    @Column(name = "data_cadastro",updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
        setUpdate(LocalDate.now());
    }
}
