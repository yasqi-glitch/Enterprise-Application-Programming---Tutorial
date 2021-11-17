package apap.tutorial.emsidi.service;


import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.rest.CabangDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    void deletePegawai(Long noPegawai);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
   PegawaiModel prediksiUmurPegawai(Long noPegawai, PegawaiModel updatePegawai);
    List<PegawaiModel> pegawaiGender(int gender);


}
