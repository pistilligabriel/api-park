package br.com.demoparkapi.model;

import br.com.demoparkapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final Long serializable = 1L;

    @Id
    @Column(name="CODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name="USUARIO", nullable = false, unique = true)
    private String usuario;

    @Column(name="SENHA", nullable = false, length = 6)
    private String senha;

    @Column(name="ROLE", length = 13)
    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENTE;

    @Column(name="CRIADO_POR")
    private String criadoPor;

    @Column(name="EDITADO_POR")
    private String editadoPor;

    @Column(name="CRIADO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime criadoEm;

    @Column(name="EDITADO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime editadoEm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codigo, usuario.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", codigo=" + codigo +
                ", role=" + role +
                '}';
    }
}
