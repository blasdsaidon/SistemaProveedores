/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.servicios;

import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import com.vinosCosas.sistemaProveedores.repositorios.ProveedorRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blasd
 */
   

@Service
public class ProveedorServicio {
    
     @Autowired
    private ProveedorRepo proveRepo;
    
    @Transactional
    public void crearProveedor(String nombre){
        
        Proveedor proveedor = new Proveedor();
        
        proveedor.setNombre(nombre);
        
        proveRepo.save(proveedor);
    }
    
    @Transactional
    public List<Proveedor> mostraProve(){
        List<Proveedor> proveeLista = proveRepo.findAll();
        
        return proveeLista;
    }
}
