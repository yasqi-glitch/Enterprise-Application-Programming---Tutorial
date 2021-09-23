package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai) { pegawaiDb.save(pegawai);}

    @Override
    public PegawaiModel getPegawaiByPegawaiId(Long idPegawai){
        return pegawaiDb.getById(idPegawai);
    }

    @Override
    public PegawaiModel updatePegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
        return pegawai;
    }

    @Override
    public void deletePegawaiByID(Long noPegawai){
        pegawaiDb.deleteById(noPegawai);
    }
}
