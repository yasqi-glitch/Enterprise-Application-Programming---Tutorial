package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.repository.CabangDB;
import apap.tutorial.emsidi.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabangServiceImpl implements CabangService {

    @Autowired
    CabangDB cabangDB;


    @Autowired
    MenuDB menuDb;

    @Override
    public void addCabang(CabangModel cabang){

        for (MenuModel menu : cabang.getListMenu()) {
            MenuModel menuModel = menuDb.getById(menu.getNoMenu());
            if(menuModel.getListCabang() == null){
                menuModel.setListCabang(new ArrayList<>());
            }
            menuModel.getListCabang().add(cabang);
        }
        cabangDB.save(cabang);
    }

    @Override
    public  void updateCabang(CabangModel cabang){
        cabangDB.save(cabang);
    }

    @Override
    public List<CabangModel> getCabangList() { return  cabangDB.findAll();}

    @Override
    public List<CabangModel> getCabangListSorted() {
        return cabangDB.findAllByOrderByNamaCabang();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang){
        Optional<CabangModel> cabang = cabangDB.findByNoCabang(noCabang);
        if (cabang.isPresent()){
            return  cabang.get();
        }
        return null;
    }

    @Override
    public void deleteCabang(Long cabang){
        cabangDB.deleteById(cabang);
    }



}
