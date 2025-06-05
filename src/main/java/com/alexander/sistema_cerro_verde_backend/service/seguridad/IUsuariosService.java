package com.alexander.sistema_cerro_verde_backend.service.seguridad;
import java.util.List;

import com.alexander.sistema_cerro_verde_backend.entity.seguridad.Usuario;
public interface IUsuariosService {
    public Usuario guardarUsuario(Usuario usuario) throws Exception;
    public Usuario guardarUsuarioConPermisos(Usuario usuario) throws Exception; 
    public Usuario obtenerUsuario(String username);
    public void eliminarUsuario(Integer id);
    public Usuario actualizarUsuario( Usuario usuarioActualizado) throws Exception;
    public List<Usuario> obtenerTodosUsuarios();
    public boolean existeUsuario(String username);
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public List<String> obtenerPermisosPorUsuarioId(Integer id) throws Exception;

    
    public void cambiarContraseña(Integer id, String nuevaContraseña) throws Exception;
}
    
