package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaPrestamo;

    @Future
    @Column(nullable = false)
    private LocalDate fechaDevolucion;

    @ManyToMany
    private List<Libro> libros;

    @ManyToOne
    private Usuario usuario;

    public Prestamo(int codigo, LocalDateTime fechaPrestamo, LocalDate fechaDevolucion) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }


}
