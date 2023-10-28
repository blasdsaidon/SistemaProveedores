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
public class PagoServicio {
    
     @Autowired
    private PagoRepo pagoRepo;
     @Autowired
     private ProveedorRepo proveRepo;
    
    @Transactional
    public void crearPago(Long proveedorId, Double monto) throws ParseException{
         Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    
        // Formatea la fecha actual como una cadena en el formato deseado
        String fechaS = formato.format(fecha);
    
    
         Optional<Proveedor> respuesta = proveRepo.findById(proveedorId);
         Proveedor proveedor = respuesta.get();
         proveedor.setSaldo(proveedor.getSaldo()-monto);
         
        Pago pago = new Pago();
        
        pago.setProveedor(proveedor);
        pago.setMontoPago(monto);
        pago.setFechaPago(fechaS);
        
     //   proveRepo.save(proveedor);
        pagoRepo.save(pago);
    }
    
    public Pago getOne(Long id){
        Pago pago = pagoRepo.getOne(id);
        
        return pago;
    }
    
    
    @Transactional
    public void modificarPago(Long pagoId, Double monto, Long proveedorId, String fechaS) throws ParseException{
        
        
        
        Optional<Pago> respuestaPago = pagoRepo.findById(pagoId);
        Pago pago = respuestaPago.get();
        Double montoAnterior = pago.getMontoPago();
        
         Optional<Proveedor> respuestaProve = proveRepo.findById(proveedorId);
         Proveedor proveedor = respuestaProve.get();
        
        pago.setProveedor(proveedor);
        pago.setMontoPago(monto);
        pago.setFechaPago(fechaS);
        proveedor.setSaldo(proveedor.getSaldo()-monto+montoAnterior);
        
        pagoRepo.save(pago);
        
    }
}
