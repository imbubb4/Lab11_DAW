package tecsup.edu.pe.lab11_heredia_daw.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private int stock;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "tipo_medic_id")
    @JsonBackReference
    private TipoMedic tipoMedic;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public TipoMedic getTipoMedic() { return tipoMedic; }
    public void setTipoMedic(TipoMedic tipoMedic) { this.tipoMedic = tipoMedic; }
}
