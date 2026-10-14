package domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    @OneToOne
    @JoinColumn(name = "idReservation")
    private Reservation reservation;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    public List<Paiement> paiements;
}
