package com.texoit.goldenraspberryawards.indicadosvencedores.model;

import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "movie")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @javax.persistence.Id @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "generator", strategy = "uuid2")
    @Column(name = "ID", nullable = false)
    private UUID id;
    @Column(name="year")
    private Integer year;
    @Column(name="title")
    private String title;
    @Column(name="studios")
    private String studios;
    @Column(name="producers")
    private String producers;
    @Column(name="winner")
    private Boolean winner;
}
