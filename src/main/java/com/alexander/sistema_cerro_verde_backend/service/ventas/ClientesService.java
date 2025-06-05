package com.alexander.sistema_cerro_verde_backend.service.ventas;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Cliente;

public interface ClientesService {

    List<Cliente> buscarTodos(); //Listar todos los clientes

    List<Cliente> buscarActivos(); //Listar categorias activos

    Optional<Cliente> buscarPorId(Integer id); //Buscar cliente por Id

    void guardar(Cliente cliente); //Guarda cliente

    void modificar(Cliente cliente); //Modificar cliente

    void eliminar(Integer id); //Eliminar cliente por Id
}
