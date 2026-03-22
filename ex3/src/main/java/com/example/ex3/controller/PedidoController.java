package com.example.ex3.controller;

import com.example.ex3.entity.Pedido;
import com.example.ex3.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> request = pedidoService.listarTodos();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido save = pedidoService.salvar(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.atualizar(id, pedido));
    }
}
