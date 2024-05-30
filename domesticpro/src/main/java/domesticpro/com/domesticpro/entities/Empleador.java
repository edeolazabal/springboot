package domesticpro.com.domesticpro.entities;


import javax.persistence.*;

@Entity
@Table(name = "empleadores")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 99,nullable=false )
    private String name;
    @Column(name = "email", length = 99,nullable=false )

    private String email;
    @Column(name = "age", length = 99,nullable=false )

    private int age;
    @Column(name = "district", length = 99,nullable=false )

    private String district;
    @Column(name = "dni", length = 99,nullable=false )
    private int dni;


    public Empleador() {
    }

    public Empleador(int id, String name, String email, int age, String district, int dni) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.district = district;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
