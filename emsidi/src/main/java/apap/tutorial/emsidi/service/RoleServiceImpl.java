package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}