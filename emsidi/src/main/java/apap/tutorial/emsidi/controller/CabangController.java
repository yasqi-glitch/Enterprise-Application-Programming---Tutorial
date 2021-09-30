package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CabangController {
    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;
    @Qualifier("menuServiceImpl")
    @Autowired
    private MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        model.addAttribute("cabang", new CabangModel());
        return  "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang, Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("listMenu", menuService.getListMenu());
        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang, Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/lihat")
    public String lihatSemuaCabang(Model model){
        List<CabangModel> daftarCabang = cabangService.getCabangList();
        //sources code inspirasi https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
         daftarCabang.sort(
                 (cabang1, cabang2) -> cabang1.getNamaCabang().compareTo(cabang2.getNamaCabang())
         );
        model.addAttribute("daftarCabang", daftarCabang);

        return "viewall-cabangnew";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabang(@PathVariable Long noCabang, Model model){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
//        LocalTime waktuBuka = cabang.getWaktuBuka();
//        LocalTime waktuTutup = cabang.getWaktuTutup();
        LocalTime now = LocalTime.now();

        if (cabang.getListPegawai().isEmpty()){
            if( now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
                //model.addAttribute("pegawai", cabang.getNoCabang());
                cabangService.deleteCabang(noCabang);
                return "cabang-delete";
            }
            else{
               return "error-page";
            }
       }
        return "error-page";
    }

    //Latihan no 3

    @PostMapping(value = "/cabang/add", params = {"add"})
    public String addRowMenu(@ModelAttribute CabangModel cabang, Model model){
        if(cabang.getListMenu() == null || cabang.getListMenu().size()==0){
            cabang.setListMenu(new ArrayList<MenuModel>());
        }
        List<MenuModel> listMenu2 = menuService.getListMenu();
            cabang.getListMenu().add(new MenuModel());
            model.addAttribute("cabang", cabang);
            model.addAttribute("menu", listMenu2);
            return "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"remove"})
    public String removeRowMenu(@ModelAttribute CabangModel cabang,
                                Model model,
                                @RequestParam("remove") int Idxhapus)
    {
        List<MenuModel> listMenu = menuService.getListMenu();
        cabang.getListMenu().remove(Idxhapus);
        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", listMenu);
        return  "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"sub"})
    private String menuSubmitForm(@ModelAttribute CabangModel cabang, Model model){
        //int jumlahMenu = cabang.getListMenu().size();
        model.addAttribute("namaMenu", cabang.getNamaCabang());
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());


        //apaya
        return "add-cabang";

    }





}
