package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiDb extends JpaRepository<PegawaiModel, Long> {
    //@Override
    PegawaiModel getById(Long noPegawai);
}
