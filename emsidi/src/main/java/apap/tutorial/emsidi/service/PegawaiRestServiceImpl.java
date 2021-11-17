package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDB;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.rest.CabangDetail;
import apap.tutorial.emsidi.rest.PrediksiUmur;
import apap.tutorial.emsidi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public void deletePegawai(Long noPegawai) {

        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawaiDb.delete(pegawai);
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());

        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return  pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if(pegawai.isPresent()){
            return pegawai.get();

        }
        else {
            throw new NoSuchElementException();
        }
        //return pegawaiDb.getById(noPegawai).get;
    }

    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.cabangURL).build();
    }

    @Override
    public PegawaiModel prediksiUmurPegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        LocalTime now = LocalTime.now();
        //System.out.println(noPegawai);
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        String namaPegawai = pegawai.getNamaPegawai();
       // System.out.println(namaPegawai);


        String namaPegawaiSplit = namaPegawai.split(" ")[0];
        CabangModel cabang = pegawai.getCabang();

        //Integer age = this.webClient.get().uri("?name=" + namaPegawaiSplit).retrieve()
               // .bodyToMono(PrediksiUmur.class).block().getAge();

        if( now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())  ){

            System.out.println("TEST");
            final String uri = "https://api.agify.io/?name=" + String.valueOf(pegawai.getNamaPegawai().split(" ")[0]);
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);

            Integer age= Integer.parseInt(result.split(",")[1].substring(6, result.split(",")[1].length()));
            pegawai.setUmur(age);
            //System.out.println(age);
             pegawaiDb.save(pegawai);
        } else {
          throw new UnsupportedOperationException("Tidak bisa");
        }
        //System.out.println( pegawaiDb.findByNoPegawai(noPegawai).get());
        return pegawaiDb.findByNoPegawai(noPegawai).get();

    }

    @Override
    public List<PegawaiModel> pegawaiGender(int gender) {
        List<PegawaiModel> staffs = pegawaiDb.findAll();
        List<PegawaiModel> listGender = new ArrayList<>();

        for(PegawaiModel staff : staffs){
            if(staff.getJenisKelamin() == gender){
                listGender.add(staff);
            }
        }
        return  listGender;

    }
}
