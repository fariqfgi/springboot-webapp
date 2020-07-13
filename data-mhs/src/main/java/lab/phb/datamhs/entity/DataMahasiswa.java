package lab.phb.datamhs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// mapping tabel data_mahasiswa
@Table(name = "data_mahasiswa")
@Data
public class DataMahasiswa {

    // mapping kolom pada tabel data_mahasiswa
    @Id @Column(name = "nim")
    private String nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "alamat")
    private String alamat;

}