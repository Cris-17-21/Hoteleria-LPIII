package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Categoria;
import com.alexander.sistema_cerro_verde_backend.repository.compras.CategoriaRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private CategoriaRepository repoCategoria;

    @Override
    public List<Categoria> buscarTodos(){ //Buscar todas las categorias
        return repoCategoria.findAll();
    }

    @Override
    public void guardar (Categoria categoria){ //Guardar categoria
        repoCategoria.save(categoria);
    }

    @Override
    public void modificar(Categoria categoria){ //Modificar la categoria
        repoCategoria.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarId(Integer idCategoria){ //Buscar por id la categoria
        return repoCategoria.findById(idCategoria);
    }

    @Override
    public void eliminar(Integer idCategoria){ //Eliminar la categoria
        repoCategoria.deleteById(idCategoria);
    }
}