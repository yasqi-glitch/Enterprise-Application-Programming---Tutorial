package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);
    void deleteCabang(Long noCabang);
    List<CabangModel> getCabangList();
    List<CabangModel> getCabangListSorted();
    CabangModel getCabangByNoCabang(Long noCabang);
}
