package com.alexander.sistema_cerro_verde_backend.controller.compras;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Categoria;
import com.alexander.sistema_cerro_verde_backend.service.compras.jpa.CategoriaService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoriasProductosController {

    @Autowired
    private CategoriaService serviceCategoriasProductos;

    @GetMapping("/categoriasproductos")
    public List<Categoria> buscarTodos(){
        return serviceCategoriasProductos.buscarTodos(); //findAll
    }

    @GetMapping("/categoriasproductosactivos")
    public List<Categoria> buscarActivos() {
        return serviceCategoriasProductos.buscarActivos();
    }

    @PostMapping("/categoriasproductos")
    public Categoria guardar (@RequestBody Categoria categoriaproducto){
        serviceCategoriasProductos.guardar(categoriaproducto);
        return categoriaproducto;
    }

    @PutMapping("/categoriasproductos")
    public Categoria modificar(@RequestBody Categoria categoriaproducto) {
        serviceCategoriasProductos.modificar(categoriaproducto);
        return categoriaproducto;
    }

    @GetMapping("/categoriasproductos/{id}")
    public Optional<Categoria> buscarId(@PathVariable("id") Integer id_categoria) {
        return serviceCategoriasProductos.buscarId(id_categoria);
    }

    @DeleteMapping("/categoriasproductos/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") Integer id_categoria){
        serviceCategoriasProductos.eliminar(id_categoria);
        return ResponseEntity.ok(Collections.singletonMap("mensaje", "Categoria eliminado"));
    }
}