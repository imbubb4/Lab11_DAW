package tecsup.edu.pe.lab11_heredia_daw.controller;

import tecsup.edu.pe.lab11_heredia_daw.model.Medicamento;
import tecsup.edu.pe.lab11_heredia_daw.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository repo;

    @GetMapping
    public List<Medicamento> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Medicamento guardar(@RequestBody Medicamento medicamento) {
        return repo.save(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamento actualizar(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        medicamento.setId(id);
        return repo.save(medicamento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Medicamento obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con id: " + id));
    }

}
