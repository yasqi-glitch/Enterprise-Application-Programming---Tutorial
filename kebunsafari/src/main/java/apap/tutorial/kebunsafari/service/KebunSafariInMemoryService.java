package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

    //Constructor
    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public  void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return  listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari) {
        for (KebunSafariModel  kbs: listKebunSafari) {
            if(kbs.getIdKebunSafari().equalsIgnoreCase(idKebunSafari)){
                return kbs;
            }
            else{
                return  null;
            }
        }
        return  null;
    }

    @Override
    public KebunSafariModel deleteKebunSafari(KebunSafariModel idKebunSafari){
        listKebunSafari.remove(idKebunSafari);
        return  idKebunSafari;
    }

}
