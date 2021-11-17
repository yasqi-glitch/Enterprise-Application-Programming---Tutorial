package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {
    RoleModel findByRole(String role);
    Optional<RoleModel> findById(Long id);
}
