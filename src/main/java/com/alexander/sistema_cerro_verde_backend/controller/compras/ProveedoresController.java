package com.alexander.sistema_cerro_verde_backend.controller.compras;

import java.util.Collections;
import java.util.HashMap;
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

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;
import com.alexander.sistema_cerro_verde_backend.service.compras.jpa.ApiRuc;
import com.alexander.sistema_cerro_verde_backend.service.compras.jpa.ProveedorService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProveedoresController {

    @Autowired
    private ProveedorService serviceProveedores;
    @Autowired
    private ApiRuc api;

    @GetMapping("/proveedores")
    public List<Proveedor> buscarTodos() { //Listar todos los proveedores
        return serviceProveedores.buscarTodos(); 
    }

    @GetMapping("/proveedoresActivos")
    public List<Proveedor> buscarActivos() {
        return serviceProveedores.buscarActivos();
    }

    @PostMapping("/proveedores")
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        serviceProveedores.guardar(proveedor);
        return proveedor;
    }
    @PutMapping("/proveedores")
    public Proveedor modificar(@RequestBody Proveedor proveedor) {
        serviceProveedores.modificar(proveedor);
        return proveedor;
    }
    @GetMapping("/proveedores/{id}")
    public Optional<Proveedor> buscarId(@PathVariable("id") String ruc_proveedor) {
        return serviceProveedores.buscarId(ruc_proveedor);
    }
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") String ruc_proveedor){
        serviceProveedores.eliminar(ruc_proveedor);
        return ResponseEntity.ok(Collections.singletonMap("mensaje", "Proveedor eliminado"));
    }
    @GetMapping("/ruc/{id}")
    public ResponseEntity<Map<String, String>> buscarRuc(@PathVariable("id") String ruc) {
        String resultado = api.consumirApi(ruc);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("datos", resultado);
        return ResponseEntity.ok(respuesta);
    } 
}