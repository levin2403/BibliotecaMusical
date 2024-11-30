/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmn.negocio;

import com.bdm.excepciones.DAOException;
import com.bmd.daoInterfaces.IUsuarioDAO;
import com.bmn.dto.UsuarioDTO;
import com.bmn.excepciones.BOException;
import com.bmn.interfaces.IActualizarUsuarioBO;
import com.bmn.singletonUsuario.UsuarioST;
import com.bmn.utilerias.Hasher;

/**
 *
 * @author skevi
 */
public class ActualizarUsuarioBO implements IActualizarUsuarioBO{
    
    private IUsuarioDAO usuarioDAO;
    private Hasher hasher;

    public ActualizarUsuarioBO(IUsuarioDAO usuarioDAO, Hasher hasher) {
        this.usuarioDAO = usuarioDAO;
        this.hasher = hasher;
    }

    @Override
    public void ActualizarUsuario(UsuarioDTO usuario) throws BOException {
        verificarCamposVacios(usuario);
        verificarFormatoCorreo(usuario);
        verificarDisponibilidadCorreo(usuario);
        hashearContrasena(usuario);
        agregarId(usuario);
        procesarActualizarUsuario(usuario);
    }
    
    private void verificarCamposVacios(UsuarioDTO usuario) throws BOException {
        if (usuario.getNombre().isEmpty()) {
            throw new BOException("Porfavor rellene el campo de 'Nombre'");
        }
        if (usuario.getCorreo().isEmpty()) {
            throw new BOException("Porfavor rellene el campo de 'Correo'");
        }
        if (usuario.getContrasena().isBlank()) {
            throw new BOException("Porfavor rellene el campo de 'Correo'");
        }
        if (usuario.getImagenPerfil().isEmpty()) {
            throw new BOException("Porfavor rellene el campo de 'Correo'");
        }
    }
    
    private void verificarFormatoCorreo(UsuarioDTO usuario) throws BOException {
        if (!usuario.getCorreo().matches("^[\\w.%+-]+@gmail\\.com$")) {
            throw new BOException("Se debe de incluir @gmail al "
                    + "final del correo");
        }
    }
    
    private void verificarDisponibilidadCorreo(UsuarioDTO usuario) throws BOException {
        try{
            if (!usuarioDAO.verificarExistenciaCorreo(usuario.getCorreo())) {
                throw new BOException("El correo proporcionado ya se encuentra "
                        + "ocupado por otro usuario");
            }
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }
    
    private void hashearContrasena(UsuarioDTO usuario) throws BOException {
        
        String contrasena = usuario.getContrasena();
        
        usuario.setContrasena(hasher.hashPassword(contrasena));
        
    }
    
    private void agregarId (UsuarioDTO usuario) throws BOException {
        String id = UsuarioST.getInstance().getId();
        
        usuario.setId(id);
    }
    
    private void procesarActualizarUsuario(UsuarioDTO usuario) throws BOException  {
//        try{
//            //convertimos de dto a entidad
//            
//            //guardamos en la persistencia
//            
//        }
//        catch(){
//            
//        }
    }
    
}
