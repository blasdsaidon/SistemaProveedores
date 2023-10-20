/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.controladores;

import com.vinosCosas.sistemaProveedores.entidades.Pago;
import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import com.vinosCosas.sistemaProveedores.servicios.PagoServicio;
import com.vinosCosas.sistemaProveedores.servicios.PedidoServicio;
import com.vinosCosas.sistemaProveedores.servicios.ProveedorServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class PortalControlador {
  
    @Autowired
    private ProveedorServicio proveServicio;
    @Autowired
    private PagoServicio pagoServicio;
    @Autowired
    private PedidoServicio pedidoServicio;
    
    
    @GetMapping("/")
    public String inicio(ModelMap modelo){
        List<Proveedor> listaProve = proveServicio.mostraProve();
        
        modelo.addAttribute("listaProve", listaProve);
    return "inicio.html";
}
    @PostMapping("/registraProve")
    public String registraProve(String nombre){
        System.out.println(nombre);
        proveServicio.crearProveedor(nombre);
        
        return "redirect:/";
    }
    
    @PostMapping("/registraPago")
    public String registraPago(Long proveId, Double monto) throws ParseException{
        pagoServicio.crearPago(proveId, monto);
        
        return "redirect:/";
    }
    
   

    
    @PostMapping("/registraPedido")
    public String registarPedido(Long proveId, Double monto){
        pedidoServicio.ingresarPedido(proveId, monto);
        
        return "redirect:/";
    }
    
    @GetMapping("/proveedor/{id}")
    public String detalleProveedor(@PathVariable Long id, ModelMap model) {
        Proveedor proveedor = proveServicio.getOne(id);
        
            model.addAttribute("proveedor", proveedor);
            return "vistaProve.html";
        }
    
    @GetMapping("/modificarPago/{id}")
    public String modificarPago(@PathVariable Long id, ModelMap model){
        Pago pago = pagoServicio.getOne(id);
        List<Proveedor> listaProve = proveServicio.mostraProve();
        
        model.addAttribute("listaProve", listaProve);
        model.addAttribute("pago", pago);
        
        return "modificarPago.html";
    }
    
    @PostMapping("/actualizarPago/{id}")
    public String actualizaPago(Long pagoId, Long proveId, Double monto, String fechaPagoS) throws ParseException{
        System.out.println("----------------------"+fechaPagoS);
        
       pagoServicio.modificarPago(pagoId, monto, proveId, fechaPagoS);
       
       return"redirect:/";
    }
}  
    

