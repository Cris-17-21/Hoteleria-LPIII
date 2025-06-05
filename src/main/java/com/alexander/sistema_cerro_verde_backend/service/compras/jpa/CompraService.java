package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Compra;
import com.alexander.sistema_cerro_verde_backend.entity.compras.MovimientoInventario;
import com.alexander.sistema_cerro_verde_backend.entity.compras.ProductoXSucursal;
import com.alexander.sistema_cerro_verde_backend.repository.compras.CompraRepository;
import com.alexander.sistema_cerro_verde_backend.repository.compras.MovimientoInventarioRepository;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProductoRepository;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProductoXSucursalRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.ICompraService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private CompraRepository repoCompra;

    @Autowired
    private ProductoRepository repoProducto;

    @Autowired
    private ProductoXSucursalRepository repoProductoXSucursal;

    @Autowired
    private MovimientoInventarioRepository repoMovimientoInventario;

    @Override
    public List<Compra> buscarTodos() {
        return repoCompra.findAll();
    }

    @Override
    public void guardar(Compra compra) {
        Compra compraGuardada = repoCompra.save(compra);

        //Recorremos cada DetalleCompra
        compraGuardada.getDetalleCompra().forEach(det -> {

            //Encontramos el producto por cada DetalleCompra
            Integer prodId = det.getProducto().getIdProducto();
            var producto = repoProducto.findById(prodId)
                    .orElseThrow(() -> new EntityNotFoundException("Producto no existe"));

            //Pasamos de la UnidadMedida a Unidades
            int equi = producto.getUnidadMedida().getEquivalencia();
            int incremento = (int) (det.getCantidad() * equi);

            //Guardamos los movimientos en Inventario
            MovimientoInventario movimiento = new MovimientoInventario();
            movimiento.setProducto(producto);
            movimiento.setTipoMovimiento("Entrada");
            movimiento.setFecha(compra.getFechaCompra());
            movimiento.setCompra(compraGuardada);
            movimiento.setCantidad(incremento);
            repoMovimientoInventario.save(movimiento);

            //Incrementamos el stock de producto 
            ProductoXSucursal productoXSucursal = producto.getProductoXSucursal().stream()
                .filter(pxs -> pxs.getSucursal().getIdSucursal().equals(compra.getSucursal().getIdSucursal()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Producto no registrado en esta sucursal"));
            productoXSucursal.setStock(productoXSucursal.getStock() + incremento);
            repoProductoXSucursal.save(productoXSucursal);
        });
    }

    @Override
    public void modificar(Compra compra) {
        repoCompra.save(compra);
    }

    @Override
    public Optional<Compra> buscarId(Integer id_compra) {
        return repoCompra.findById(id_compra);
    }

    @Override
    public void eliminar(Integer id_compra) {
        repoCompra.deleteById(id_compra);
    }
}
