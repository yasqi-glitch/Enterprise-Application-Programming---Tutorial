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
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai, Model model
    ){
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }

    @GetMapping("/pegawai/update/{noCabang}/{noPegawai}")
    public String updatePegawaiForm(@PathVariable Long noPegawai,@PathVariable Long noCabang, Model model){
        try {
            CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
//            LocalTime waktuBuka = cabang.getWaktuBuka();
//            LocalTime waktuTutup = cabang.getWaktuTutup();
            LocalTime now = LocalTime.now();
            PegawaiModel pegawai = pegawaiService.getPegawaiByPegawaiId(noPegawai);
            if(
                    now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())) {
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
//        LocalTime waktuBuka = cabang.getWaktuBuka();
//        LocalTime waktuTutup = cabang.getWaktuTutup();
        LocalTime now = LocalTime.now();
        if( now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            PegawaiModel pegawai = pegawaiService.getPegawaiByPegawaiId(noPegawai);
            model.addAttribute("pegawai", pegawai.getNoPegawai());
            pegawaiService.deletePegawaiByID(noPegawai);
            return "pegawai-delete";
        }
        return "error-page";
    }

    @PostMapping("/pegawai/delete")
    public String deletePegawaiSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        LocalTime now = LocalTime.now();
        if(now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            for(PegawaiModel pegawai: cabang.getListPegawai()){
                pegawaiService.removePegawai(pegawai);
            }
            model.addAttribute("noCabang", cabang.getNoCabang());
            return "delete-pegawai";
        }
        return "error-cannot-delete";
    }



}
