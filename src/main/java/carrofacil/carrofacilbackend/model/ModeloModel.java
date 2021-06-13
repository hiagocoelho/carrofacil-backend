package carrofacil.carrofacilbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "modelo")
public class ModeloModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private MarcaModel marca;

    @OneToMany(mappedBy = "modelo")
    private Set<CarroModel> carro;

    public ModeloModel() {}

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

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }
}
