package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Agence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Employe> employes;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Vehicule> vehicules;
