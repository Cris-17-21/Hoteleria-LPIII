package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.DetalleCompra;
import com.alexander.sistema_cerro_verde_backend.repository.compras.DetalleCompraRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.IDetalleCompraService;

@Service
public class DetalleCompraService implements IDetalleCompraService {

    @Autowired
    private DetalleCompraRepository repoDetalleCompra;

    @Override
    public List<DetalleCompra> buscarTodos() {
        return repoDetalleCompra.findAll();
    }

    @Override
    public void guardar(DetalleCompra detalleCompra) {
        repoDetalleCompra.save(detalleCompra);
    }

    @Override
    public void modificar(DetalleCompra detalleCompra) {
        repoDetalleCompra.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompra> buscarId(Integer idDetalleCompra) {
        return repoDetalleCompra.findById(idDetalleCompra);
    }

    @Override
    public void eliminar(Integer idDetalleCompra) {
        repoDetalleCompra.deleteById(idDetalleCompra);
    }
}
