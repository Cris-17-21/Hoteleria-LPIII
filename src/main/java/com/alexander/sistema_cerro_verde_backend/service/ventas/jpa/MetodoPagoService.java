package com.alexander.sistema_cerro_verde_backend.service.ventas.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.MetodoPago;
import com.alexander.sistema_cerro_verde_backend.repository.ventas.MetodoPagoRepository;
import com.alexander.sistema_cerro_verde_backend.service.ventas.IMetodoPagoService;

@Service
public class MetodoPagoService implements IMetodoPagoService {

    @Autowired
    private MetodoPagoRepository repoMetodo;

    @Override
    public List<MetodoPago> buscarTodos() { //Listar todos los métodos de pago
        return repoMetodo.findAll();
    }

    @Override
    public List<MetodoPago> buscarActivos() { //Listar los métodos de pago activos
        return repoMetodo.findActive();
    }

    @Override
    public Optional<MetodoPago> buscarPorId(Integer id) { //Buscar método de pago por el ID
        return repoMetodo.findById(id);
    }

    @Override
    public void registrar(MetodoPago metodo) { //Registrar método de pago
        repoMetodo.save(metodo);
    }

    @Override
    public void modificar(MetodoPago metodo) { //Modificar el método de pago
        repoMetodo.save(metodo);
    }

    @Override
    public void eliminar(Integer id) { //Eliminar el método de pago por el ID
        repoMetodo.deleteById(id);
    }
}
