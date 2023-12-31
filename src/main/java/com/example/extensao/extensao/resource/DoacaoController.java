package com.example.extensao.extensao.resource;

import com.example.extensao.extensao.model.Doacao;
import com.example.extensao.extensao.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/doacao")
public class DoacaoController extends AbstractController {

    @Autowired
    DoacaoService doacaoService;

    @PostMapping
    public Doacao createDoacao(@RequestBody Doacao doacao) {
        return doacaoService.saveDoacao(doacao);
    }

    @GetMapping
    public List<Doacao> getDoacaoList() {
        return doacaoService.findAll();
    }

    @GetMapping("{idDoacao}")
    public ResponseEntity<Doacao> getDoacaoByID(@PathVariable("idDoacao") Long idDoacao) throws Exception {
        return ResponseEntity.ok(doacaoService.getById(idDoacao).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping("{idDoacao}")
    public Doacao updateDoacao(@RequestBody Doacao doacao) {
        return doacaoService.updateDoacao(doacao);
    }

    @DeleteMapping("{idDoacao}")
    public ResponseEntity deleteById(@PathVariable("idDoacao") Long idDoacao) throws Exception {
        try {
            doacaoService.deleteDoacao(idDoacao);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

}
