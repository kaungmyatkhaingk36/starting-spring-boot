package jp.co.blisstock.appv3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// TODO: change table name to match with your table
@Table(name = "person_profile")
public class Profile {
    @Id
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private String email;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
