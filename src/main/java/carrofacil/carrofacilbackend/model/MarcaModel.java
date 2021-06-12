package carrofacil.carrofacilbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "marca")
public class MarcaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private Set<ModeloModel> modelo;

    public MarcaModel() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
