package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    void deletePegawaiByID(Long noPegawai);
    PegawaiModel updatePegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByPegawaiId(Long noPegawai);
}
