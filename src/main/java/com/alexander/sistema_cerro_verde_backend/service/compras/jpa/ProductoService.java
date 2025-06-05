package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;
import com.alexander.sistema_cerro_verde_backend.entity.compras.ProductoXSucursal;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProductoRepository;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProductoXSucursalRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.IProductoService;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repoProducto;

    @Autowired
    private ProductoXSucursalRepository repoProductoXSucursal;

    @Override
    public List<Producto> buscarTodos(){ //Buscar todos los productos
        return repoProducto.findAll();
    }

    @Override
    public void guardar(Producto producto){ //Guardar producto
        Producto productoGuardado = repoProducto.save(producto);

        //Recorremos cada Sucursal
        productoGuardado.getEmpresa().getSucursal().forEach(suc -> {

            //Registrar el producto en ProductoXSucursal
            ProductoXSucursal productoXSucursal = new ProductoXSucursal();
            productoXSucursal.setProducto(producto);
            productoXSucursal.setSucursal(suc);
            productoXSucursal.setStock(0);
            repoProductoXSucursal.save(productoXSucursal);
        });
    }

    @Override
    public void modificar(Producto producto){ //Modificar productos
        repoProducto.save(producto);
    }
    
    @Override
    public Optional<Producto> buscarId(Integer idProducto){ //Buscar productos por Id
        return repoProducto.findById(idProducto);
    }

    @Override
    public void eliminar(Integer idProducto){ //Eliminar producto
        repoProducto.deleteById(idProducto);
    }
}