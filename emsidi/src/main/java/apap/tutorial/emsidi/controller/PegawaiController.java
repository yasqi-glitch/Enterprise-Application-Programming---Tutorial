package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import  apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if (cabang.getListPegawai().size() < 3){
            pegawai.setCabang(cabang);
            model.addAttribute("noCabang", noCabang);
            model.addAttribute("pegawai", pegawai);
            return "form-add-pegawai";
        }
        return "error-page";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai, Model model
    ){

        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
        //}
    }

    @GetMapping("/pegawai/update/{noCabang}/{noPegawai}")
    public String updatePegawaiForm(@PathVariable Long noPegawai,@PathVariable Long noCabang, Model model){
        try {
            CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
            LocalTime waktuBuka = cabang.getWaktuBuka();
            LocalTime waktuTutup = cabang.getWaktuTutup();
            LocalTime waktuNow = LocalTime.now();
            PegawaiModel pegawai = pegawaiService.getPegawaiByPegawaiId(noPegawai);
            if(
                    !(waktuNow.compareTo(waktuBuka) >0 && waktuTutup.compareTo(waktuBuka) <0 && waktuNow.compareTo(waktuTutup)>0)
            ) {
                model.addAttribute("noCabang", cabang);
                model.addAttribute("pegawai", pegawai);
                return "form-update-pegawai";
            }
            else {
                return "update-dilarang";
            }
        }
        catch (Exception e){
            return "update-dilarang";
        }
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
        pegawaiService.updatePegawai(pegawai);
        model.addAttribute("pegawai", pegawai.getNoPegawai());
        return "update-pegawai";
    }

    @GetMapping("/pegawai/delete/{noCabang}/{noPegawai}")
    public String deletePegawai(@PathVariable Long noPegawai, @PathVariable Long noCabang, Model model){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        LocalTime waktuBuka = cabang.getWaktuBuka();
        LocalTime waktuTutup = cabang.getWaktuTutup();
        LocalTime waktuNow = LocalTime.now();
        if( !(waktuNow.compareTo(waktuBuka) >0 && waktuTutup.compareTo(waktuBuka) <0 && waktuNow.compareTo(waktuTutup)>0)){
            PegawaiModel pegawai = pegawaiService.getPegawaiByPegawaiId(noPegawai);
            model.addAttribute("pegawai", pegawai.getNoPegawai());
            pegawaiService.deletePegawaiByID(noPegawai);
            return "pegawai-delete";
        }
        return "error-page";
    }



}
