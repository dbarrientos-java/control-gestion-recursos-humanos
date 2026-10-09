package main.java.gt.dbarrientoscorp.controlrecursoshumanos.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.config.DataBaseConnection;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.Applicant;

/**
 *
 * @author dbarrientos
 */


public class ApplicantRepository {


    public List<Applicant> applicantList() throws SQLException {
        List<Applicant> lista = new ArrayList<>();
        String sql = "SELECT a.id_applicant, a.name, a.lastname, a.email, a.phone, a.id_addres, a.age, ad.country, ad.city, ad.municipal, ad.number_house\n" +
                     "from applicant as a \n" +
                     "INNER JOIN addres as ad ON a.id_addres = ad.id_addres";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Applicant emp = new Applicant(
                        rs.getString("id_applicant"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("id_addres"),
                        rs.getInt("age"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("municipal"),
                        rs.getString("number_house")
                );
                lista.add(emp);
            }
        }
        return lista;
    }

    public boolean save(Applicant app) throws SQLException {
        String sql = " INSERT INTO addres Values(?, ?, ?, ?, ? );\n" +
                     " INSERT INTO applicant Values(? ,? ,? ,? ,? ,? ,? );";

        String id_addres = (app.getId_addres() != null && !app.getId_addres().isEmpty())
                ? app.getId_addres()
                : UUID.randomUUID().toString();
        
         String id_applicant = (app.getId_applicant() != null && !app.getId_applicant().isEmpty())
                ? app.getId_applicant()
                : UUID.randomUUID().toString();


        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
               
           ps.setString(1, id_addres);
           ps.setString(2, app.getCountry());
           ps.setString(3, app.getCity());
           ps.setString(4, app.getMuncipal());
           ps.setString(5, app.getNumber_house());
           ps.setString(6, id_applicant);
           ps.setString(7, app.getName());
           ps.setString(8, app.getLastname());
           ps.setString(9, app.getEmail());
           ps.setString(10, app.getPhone());
           ps.setInt(11, app.getAge());
           return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Applicant app) throws SQLException {
        String sql = "UPDATE addres SET  country = ?, city = ?, municipal = ?, number_house = ?  WHERE id_addres = ?;\n" +
                     "UPDATE applicant SET name = ?, lastname = ?, email = ?, phone = ?, id_addres = ?, age = ? WHERE id_applicant = ?";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, app.getCountry());
            ps.setString(2, app.getCity());
            ps.setString(3, app.getMuncipal());
            ps.setString(4, app.getNumber_house());
            ps.setString(5, app.getId_addres());
            
            ps.setString(6, app.getName());
            ps.setString(7, app.getLastname());
            ps.setString(8, app.getEmail());
            ps.setString(9, app.getPhone());
            ps.setInt(10, app.getAge());
            ps.setString(11, app.getId_applicant());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String id_applicant) throws SQLException {
        String sql = "DELETE FROM applicant WHERE id_applicant = ?";
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id_applicant
            );
            return ps.executeUpdate() > 0;
        }
    }

 
}
    

