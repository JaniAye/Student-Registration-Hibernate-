package ik.ijse.StudentReg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student implements SuperEntity {

    @Id
    private String id;
    private String Stdname;
    private String address;
    private int contact;
    private String dob;
    private String gender;
    @OneToMany(mappedBy = "student" )
    private List<Registration> registrations;

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String Stdname, String address, int contact, String dob, String gender, List<Registration> registrations) {
        this.setId(id);
        this.setName(Stdname);
        this.setAddress(address);
        this.setContact(contact);
        this.setDob(dob);
        this.setGender(gender);
        this.setRegistrations(registrations);
    }

    public Student() {
    }

    public Student(String id, String Stdname, String address, int contact, String dob, String gender) {
        this.setId(id);
        this.setName(Stdname);
        this.setAddress(address);
        this.setContact(contact);
        this.setDob(dob);
        this.setGender(gender);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Stdname;
    }

    public void setName(String Stdname) {
        this.Stdname = Stdname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
