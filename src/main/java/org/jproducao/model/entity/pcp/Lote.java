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
    private Long id;

    @Column(length = 7)
    private String codigo;

    @Column(length = 255)
    private String observacao;

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
