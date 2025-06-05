package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.MovimientoInventario;
import com.alexander.sistema_cerro_verde_backend.repository.compras.MovimientoInventarioRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.IMovimientoInventarioService;

@Service
public class MovimientoInventariosService implements IMovimientoInventarioService {

    @Autowired
    private MovimientoInventarioRepository repoMovimientoInventario;

    @Override
    public List<MovimientoInventario> buscarTodos() {
        return repoMovimientoInventario.findAll();
    }

    @Override
    public void guardar(MovimientoInventario movimientoInventario) {
        repoMovimientoInventario.save(movimientoInventario);
    }

    @Override
    public void modificar(MovimientoInventario movimientoInventario) {
        repoMovimientoInventario.save(movimientoInventario);
    }

    @Override
    public Optional<MovimientoInventario> buscarId(Integer idMovimientoInventario) {
        return repoMovimientoInventario.findById(idMovimientoInventario);
    }

    @Override
    public void eliminar(Integer idMovimientoInventario) {
        repoMovimientoInventario.deleteById(idMovimientoInventario);
    }
}
