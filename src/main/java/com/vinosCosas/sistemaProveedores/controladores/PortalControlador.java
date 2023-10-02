/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.controladores;

import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import com.vinosCosas.sistemaProveedores.servicios.PagoServicio;
import com.vinosCosas.sistemaProveedores.servicios.PedidoServicio;
import com.vinosCosas.sistemaProveedores.servicios.ProveedorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
        proveServicio.CrearProveedor(nombre);
        
        return "redirect:/";
    }
    
    @PostMapping("/registraPago")
    public String registraPago(Long proveId, Double monto){
        pagoServicio.CrearPago(proveId, monto);
        
        return "redirect:/";
    }
    
    @PostMapping("/registraPedido")
    public String registarPedido(Long proveId, Double monto){
        pedidoServicio.ingresarPedido(proveId, monto);
        
        return "redirect:/";
    }
}
