/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.servicios;

import com.vinosCosas.sistemaProveedores.entidades.Pedido;
import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import com.vinosCosas.sistemaProveedores.repositorios.PedidoRepo;
import com.vinosCosas.sistemaProveedores.repositorios.ProveedorRepo;
import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blasd
 */
@Service
public class PedidoServicio {
    
    @Autowired
    private PedidoRepo pedidoRepo;
    
    @Autowired
    private ProveedorRepo proveRepo;
   
    
    
    @Transactional
    public void ingresarPedido (Long proveedorId, Double monto){
        
        Date fechaRecpcion = new Date();
        Optional<Proveedor> respuesta = proveRepo.findById(proveedorId);
        Proveedor proveedor = respuesta.get();
        
        proveedor.setSaldo(proveedor.getSaldo()+monto);
        
        Pedido pedido = new Pedido();
        
        pedido.setMonto(monto);
        pedido.setProveedor(proveedor);
        pedido.setFechaRecepcion(fechaRecpcion);
        
        proveRepo.save(proveedor);
        pedidoRepo.save(pedido);

    }
        
}
    
