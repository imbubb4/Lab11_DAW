package tecsup.edu.pe.lab11_heredia_daw.controller;

import tecsup.edu.pe.lab11_heredia_daw.model.TipoMedic;
import tecsup.edu.pe.lab11_heredia_daw.repository.TipoMedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoMedicController {

    @Autowired
    private TipoMedicRepository repo;

    @GetMapping
    public List<TipoMedic> listar() {
        return repo.findAll();
    }

    @PostMapping
    public TipoMedic guardar(@RequestBody TipoMedic tipo) {
        return repo.save(tipo);
    }

    @PutMapping("/{id}")
    public TipoMedic actualizar(@PathVariable Long id, @RequestBody TipoMedic tipo) {
        tipo.setId(id);
        return repo.save(tipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/{id}")
    public TipoMedic obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoMedic no encontrado con id: " + id));
    }

}
