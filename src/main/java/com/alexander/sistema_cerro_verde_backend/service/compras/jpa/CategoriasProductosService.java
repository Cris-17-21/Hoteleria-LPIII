package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Categoria;
import com.alexander.sistema_cerro_verde_backend.repository.compras.CategoriasProductosRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.ICategoriasProductosService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CategoriasProductosService implements ICategoriasProductosService{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoriasProductosRepository repoCategoriasProductos;

    @Override
    public List<Categoria> buscarTodos(){ //Buscar todas las categorias
        return repoCategoriasProductos.findAll();
    }

    @Override
    public List<Categoria> buscarActivos(){ //Buscar las categorias con estado = 1
        return repoCategoriasProductos.findActive();
    }

    @Override
    @Transactional
    public void guardar (Categoria categoriaproducto){ //Guardar categoria
        Optional<Categoria> existente = repoCategoriasProductos.findByNombreIgnoreCase(categoriaproducto.getNombre());
        if(existente.isPresent()){
            Categoria cp = existente.get();
            if(cp.getEstado() == 0){
                cp.setEstado(1);
                cp.setNombre(categoriaproducto.getNombre());
                entityManager.merge(cp);
            } else {
                repoCategoriasProductos.save(categoriaproducto);
            }
        } else {
            categoriaproducto.setEstado(1);
            repoCategoriasProductos.save(categoriaproducto);
        }
    }

    @Override
    public void modificar(Categoria categoriaproducto){ //Modificar la categoria
        repoCategoriasProductos.save(categoriaproducto);
    }

    @Override
    public Optional<Categoria> buscarId(Integer id_categoria){ //Buscar por id la categoria
        return repoCategoriasProductos.findById(id_categoria);
    }

    @Override
    public void eliminar(Integer id_categoria){ //Eliminar la categoria
        repoCategoriasProductos.deleteById(id_categoria);
    }
}