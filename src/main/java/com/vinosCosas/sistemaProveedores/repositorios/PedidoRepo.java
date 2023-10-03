/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.repositorios;

import com.vinosCosas.sistemaProveedores.entidades.Pedido;
import com.vinosCosas.sistemaProveedores.entidades.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blasd
 */
@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Long> {
        
    
}
