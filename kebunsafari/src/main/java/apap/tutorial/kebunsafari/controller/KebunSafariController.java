package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
        @RequestParam (value ="id", required = true) String idKebunSafari,
        @RequestParam (value="nama", required = true) String namaKebunSafari,
        @RequestParam (value ="alamat", required = true) String alamat,
        @RequestParam (value ="noTelepon", required = true) String noTelepon,
        Model model)

    {
        //Membuat Objek Kebun Safari
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        //Memanggil service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        //Menambahkan variabel kebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn template html yang dipakai
        return  "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        //Mendapatkan list seluruh objek Kebun Safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        //Menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        //Mereturn template html yang dipakai
        return  "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value = "id", required = true) String idKebunSafari, Model model){
        //Mendapatkan objek kebun safari sesuai ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //Menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn template html yang dipakai
        return  "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/view/{nomor}")
    public String lihatKebun(@PathVariable("nomor") String nomor, Model model){


        if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) == null){
            return  "error-kbs";
        }
        else if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) != null){
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(nomor);

            //ngeadd utk dirender ke thymeleaf
            model.addAttribute("kebunSafari", kebunSafari);

            return "view-kbs";
        }
        else{
            return  "error-kbs";
        }
    }

    @RequestMapping("/kebun-safari/update/{nomor}")
    public String updateKBS(@PathVariable("nomor") String nomor, @RequestParam(value = "noTelepon", required = true) String noTelepon, Model model){


        if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) == null){
            return  "error-kbs";
        }
        else if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) != null){
            //KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(nomor);

            KebunSafariModel kebunSafariUpdate = kebunSafariService.getKebunSafariByIdKebunSafari(nomor);
            //set no telp
            kebunSafariUpdate.setNoTelepon(noTelepon);

            //ngeadd utk dirender ke thymeleaf
            model.addAttribute("kebunSafari", kebunSafariUpdate);

            return "view-kbs";
        }
        else{
            return  "error-kbs";
        }
    }

    @RequestMapping("/kebun-safari/delete/{nomor}")
    public String deleteKBS(@PathVariable("nomor") String nomor, Model model){

        if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) == null){
            return  "error-kbs";
        }
        else if(kebunSafariService.getKebunSafariByIdKebunSafari(nomor) != null){
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(nomor);

            KebunSafariModel kebunSafariHapus = kebunSafariService.deleteKebunSafari(kebunSafari);

            //ngeadd utk dirender ke thymeleaf
            model.addAttribute("kebunSafari", kebunSafariHapus);

            return "delete-kbs";
        }
        else{
            return  "error-kbs";
        }
    }








}
