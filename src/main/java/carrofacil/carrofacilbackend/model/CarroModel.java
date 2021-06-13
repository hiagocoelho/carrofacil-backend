package carrofacil.carrofacilbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "carro")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, length = 50)
    private Integer ano;

    @Column(nullable = false, length = 50)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private ModeloModel modelo;

    public CarroModel() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ModeloModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloModel modelo) {
        this.modelo = modelo;
    }
}
