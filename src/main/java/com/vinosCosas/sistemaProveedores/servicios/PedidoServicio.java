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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        
        Date fechaRecepcion = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    
        // Formatea la fecha actual como una cadena en el formato deseado
        String fecha = formato.format(fechaRecepcion);
        Optional<Proveedor> respuesta = proveRepo.findById(proveedorId);
        Proveedor proveedor = respuesta.get();
        
        proveedor.setSaldo(proveedor.getSaldo()+monto);
        
        Pedido pedido = new Pedido();
        
        pedido.setMonto(monto);
        pedido.setProveedor(proveedor);
        pedido.setFechaRecepcion(fecha);
        
        proveRepo.save(proveedor);
        pedidoRepo.save(pedido);

    }
    
    public Pedido getOne(Long id){
        Pedido pedido = pedidoRepo.getOne(id);
        
        return pedido;
    }
    
    @Transactional
    public void modificarPedido(Long pedidoId, Double monto, Long proveedorId, String fechaS) throws ParseException{
        
        
        
        Optional<Pedido> respuestaPedido = pedidoRepo.findById(pedidoId);
        Pedido pedido = respuestaPedido.get();
        Double montoAnterior = pedido.getMonto();
        
         Optional<Proveedor> respuestaProve = proveRepo.findById(proveedorId);
         Proveedor proveedor = respuestaProve.get();
        
        pedido.setProveedor(proveedor);
        pedido.setMonto(monto);
        pedido.setFechaRecepcion(fechaS);
        proveedor.setSaldo(proveedor.getSaldo()+monto-montoAnterior);
        
        pedidoRepo.save(pedido);
        
    }
        
}
    
