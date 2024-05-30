package domesticpro.com.domesticpro.entities;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 99,nullable=false )
    private String name;
    @Column(name = "dni", length = 99,nullable=false )
    private int dni;
    @Column(name = "email", length = 99,nullable=false )
    private String email;
    @Column(name = "age", length = 99,nullable=false )
    private int age;
    @Column(name = "district", length = 99,nullable=false )
    private String district;
    @Column(name = "profession", length = 99,nullable=false )
    private String profession;
    @Column(name = "descripcion", length = 99,nullable=false )
    private String descripcion;

    public Empleado() {
    }

    public Empleado(int id, String name, int dni, String email, int age, String district, String profession, String descripcion) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.age = age;
        this.district = district;
        this.profession = profession;
        this.descripcion = descripcion;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
