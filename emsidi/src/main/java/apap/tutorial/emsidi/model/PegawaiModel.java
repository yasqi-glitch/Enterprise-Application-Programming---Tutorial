package apap.tutorial.emsidi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pegawai")
public class PegawaiModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noPegawai;

    @NotNull
    @Size(max = 30)
    @Column(name= "nama_pegawai", nullable = false)
    private String namaPegawai;

    @NotNull
    @Column(name="jenis_kelamin", nullable = false)
    private int jenisKelamin;

    //Relasi dengan CabangModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "noCabang", referencedColumnName = "noCabang", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CabangModel cabang;
}
