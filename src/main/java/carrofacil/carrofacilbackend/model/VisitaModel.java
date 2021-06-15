package carrofacil.carrofacilbackend.model;


import javax.persistence.*;

@Entity
@Table(name = "visita")
public class VisitaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cpf;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 18)
    private String data;

    @Column(nullable = false, length = 80)
    private String carro;

    public VisitaModel() {}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }
}
