
package main.java.gt.dbarrientoscorp.controlrecursoshumanos.model;

/**
 *
 * @author dbarrientos
 */
public class Applicant {
    
    private String id_applicant;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String id_addres;
    private int age;
    
    private String country;
    private String city;
    private String muncipal;
    private String number_house;

    public Applicant() {
    }

    public Applicant(String id_applicant, String name, String lastname, String email, String phone, String id_addres, int age, String country, String city, String muncipal, String number_house) {
        this.id_applicant = id_applicant;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.id_addres = id_addres;
        this.age = age;
        this.country = country;
        this.city = city;
        this.muncipal = muncipal;
        this.number_house = number_house;
    }

    public String getId_applicant() {
        return id_applicant;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getId_addres() {
        return id_addres;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getMuncipal() {
        return muncipal;
    }

    public String getNumber_house() {
        return number_house;
    }

    public void setId_applicant(String id_applicant) {
        this.id_applicant = id_applicant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId_addres(String id_addres) {
        this.id_addres = id_addres;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMuncipal(String muncipal) {
        this.muncipal = muncipal;
    }

    public void setNumber_house(String number_house) {
        this.number_house = number_house;
    }

    
    
    
    
    
}
