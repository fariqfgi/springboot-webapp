package lab.phb.datamhs.controller;

import lab.phb.datamhs.entity.DataMahasiswa;
import lab.phb.datamhs.model.DataMahasiswaModel;
import lab.phb.datamhs.services.DataMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private DataMahasiswaService service;

    /* request method get pada url / (root)
        parameter model akan mengirim data ke index.html
        atribut mhs yang nantinya akan kita panggil di halaman index.html */
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("mhs", service.getAllData());
        return "index";
    }

    /* request method get pada url /tambah
        dan memanggil tambah-mhs.html
     */
    @GetMapping("/tambah")
    public String tampilkanTambahForm(Model model) {
        model.addAttribute("mhs", new DataMahasiswaModel());
        return "tambah-mhs";
    }

    @PostMapping("/simpan")
    public String simpan(DataMahasiswaModel mhs) {
        service.save(service.convertToEntity(mhs));
        return "redirect:/";
    }

    // method edit
    @GetMapping("/ubah/{nim}")
    public String edit(@PathVariable("nim") String nim, Model model) {
        Optional<DataMahasiswa> result = service.findByID(nim);
        if(result.isPresent()) {
            DataMahasiswa data = result.get();
            model.addAttribute("mhs", data);
            return "edit-mhs";
        } else {
            return "redirect:/";
        }
    }

    // method hapus
    @GetMapping("/hapus/{nim}")
    public String hapus(@PathVariable("nim") String nim) {
        service.removeById(nim);
        return "redirect:/";
    }

}