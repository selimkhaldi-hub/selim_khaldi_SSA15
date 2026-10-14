package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne
    @JoinColumn(name = "idAgence")
    private Agence agence;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Maintenance> maintenances;

    @ManyToMany
    @JoinTable(
        name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "idVehicule"),
        inverseJoinColumns = @JoinColumn(name = "idEquipement")
    )
    @ToString.Exclude
    private List<Equipement> equipements;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reservation> reservations;

}
