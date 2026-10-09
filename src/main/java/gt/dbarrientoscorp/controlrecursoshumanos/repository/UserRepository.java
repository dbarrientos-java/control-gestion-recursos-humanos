package main.java.gt.dbarrientoscorp.controlrecursoshumanos.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.config.DataBaseConnection;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.Rol;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.User;

/**
 *
 * @author dbarrientos
 */

public class UserRepository {
   
    public User findByUsername(String username) {
        String sql = "select * from user where username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, username);
            
            try (ResultSet rs = pstm.executeQuery()) {
                
                if (rs.next()) {
                    return new User(
                    rs.getString("id_usuario"),
                    rs.getString("username"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    rs.getString("id_rol")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
        return null;
    }
    
    public boolean register(User usuario) {
        String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, usuario.getId_user());
            pstm.setString(2, usuario.getUsername());
            pstm.setString(3, usuario.getLastname());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getPassword_hash());
            pstm.setString(6, usuario.getId_rol());
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
            return false;
        }
    }
    
     public Rol findById(String id_rol) {
        String sql = "select * from rol where id_rol = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, id_rol);
            
            try (ResultSet rs = pstm.executeQuery()) {
                
                if (rs.next()) {
                    return new Rol(
                    rs.getString("id_rol"),
                    rs.getString("rol"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
        return null;
    }
    
    public List<Rol> getAllRoles() {
        List<Rol> lista = new ArrayList<>();
        String sql = "select * from rol";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new Rol(
                    rs.getString("id_rol"),
                    rs.getString("rol")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
        return lista;
    }

    
}


