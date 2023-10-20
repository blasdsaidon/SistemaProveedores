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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Date stringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaFormateadaDate = null;
         try {
             fechaFormateadaDate = formato.parse(fecha);
         } catch (ParseException ex) {
             Logger.getLogger(PagoServicio.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return fechaFormateadaDate;
    }
    public Date formateaFecha(Date fecha) {
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    
        // Formatea la fecha actual como una cadena en el formato deseado
        String fechaFormateada = formato.format(fecha);

        // Crea un nuevo objeto Date a partir de la cadena formateada
        Date fechaFormateadaDate = null;
         try {
             fechaFormateadaDate = formato.parse(fechaFormateada);
         } catch (ParseException ex) {
             Logger.getLogger(PagoServicio.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return fechaFormateadaDate;
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
