/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.servicios;

import com.vinosCosas.sistemaProveedores.entidades.Pago;
import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import com.vinosCosas.sistemaProveedores.repositorios.PagoRepo;
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
public class PagoServicio {
    
     @Autowired
    private PagoRepo pagoRepo;
     @Autowired
     private ProveedorRepo proveRepo;
    
    @Transactional
    public void crearPago(Long proveedorId, Double monto){
        Date fechaPago = new Date();
         Optional<Proveedor> respuesta = proveRepo.findById(proveedorId);
         Proveedor proveedor = respuesta.get();
         proveedor.setSaldo(proveedor.getSaldo()-monto);
         
        Pago pago = new Pago();
        
        pago.setProveedor(proveedor);
        pago.setMontoPago(monto);
        pago.setFechaPago(fechaPago);
        
     //   proveRepo.save(proveedor);
        pagoRepo.save(pago);
    }
    
    @Transactional
    public void modificarPago(Long pagoId, Double monto, Long proveedorId, Date fecha){
        
        Optional<Pago> respuestaPago = pagoRepo.findById(pagoId);
        Pago pago = respuestaPago.get();
        
         Optional<Proveedor> respuestaProve = proveRepo.findById(proveedorId);
         Proveedor proveedor = respuestaProve.get();
        
        pago.setProveedor(proveedor);
        pago.setMontoPago(monto);
        pago.setFechaPago(fecha);
        
         pagoRepo.save(pago);
        
    }
}
