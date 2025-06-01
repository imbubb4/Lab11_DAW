package tecsup.edu.pe.lab11_heredia_daw.repository;

import tecsup.edu.pe.lab11_heredia_daw.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
