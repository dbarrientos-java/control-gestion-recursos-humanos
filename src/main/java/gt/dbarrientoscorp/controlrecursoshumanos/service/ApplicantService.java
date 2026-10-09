package main.java.gt.dbarrientoscorp.controlrecursoshumanos.service;

import java.sql.SQLException;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.Applicant;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.repository.ApplicantRepository;


/**
 *
 * @author dbarrientosElProXddxd:v
 */


public class ApplicantService {
    
    private final ApplicantRepository aRepository;

    public ApplicantService(ApplicantRepository aRepository) {
        this.aRepository = aRepository;
    }
    
    public boolean registerApplicant(String name, String lastname,
            String email, String phone, int age, String country,
            String city, String municipal, String number_house) throws SQLException {
        if (name == null || name.trim().isEmpty() 
                || lastname == null || lastname.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()
                || age == 0 || country == null || country.trim().isEmpty()
                || city == null || city.trim().isEmpty()
                || municipal == null || municipal.trim().isEmpty()
                || number_house == null || number_house.trim().isEmpty()
                ) {
            System.out.println("No se puede ingresar campos vacios");
            return false;
        } 
        
        Applicant newApp = new Applicant(
                UUID.randomUUID().toString(),
                name.trim(),
                lastname.trim(),
                email.trim(),
                phone.trim(),
                UUID.randomUUID().toString(),
                age,
                country.trim(),
                city.trim(),
                municipal.trim(),
                number_house.trim()
                
        );
        
        return aRepository.save(newApp);
    }
    
    public ObservableList<Applicant> getApplicantList() throws SQLException {
        return FXCollections.observableArrayList( aRepository.applicantList());
    }
    
    public boolean deleteApplicant(String id_applicant) throws SQLException{
        if (id_applicant == null || id_applicant.trim().isEmpty()){
            System.out.println("el id del applicant es nulo o está vacio");
            return false;
        }else{
            return aRepository.delete(id_applicant);
        }
    }
    
     public boolean updateApplicant(Applicant app) throws SQLException {
         String id_app = app.getId_applicant();
        if (  id_app == null ){
            System.out.println("el id del Applicant está vacio o el applicant no existe");
            return false;
        } 
        return aRepository.update(app);
        
     }
    
}
