package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Contrat contrat;
}
