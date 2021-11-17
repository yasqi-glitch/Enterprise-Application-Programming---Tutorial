package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getUserList() { return  userDb.findAll();}

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public UserModel getUserByUsername(String uname) {
        UserModel user = userDb.findByUsername(uname);
//        if (user.isPresent()){
            return  user;
//        }
//        return null;
    }

    @Override
    public UserModel resetPassword(UserModel user, String passwordold, String passwordnew, String confirm) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Boolean isPasswordMatch = passwordEncoder.matches(passwordold, user.getPassword());

        if (isPasswordMatch == true) {
            if (passwordnew.equals(confirm)) {
                user.setPassword(encrypt(passwordnew));
                userDb.save(user);
            }
        }
        return user;
    }

    @Override
    public UserModel getUserById(String id) {
        Optional<UserModel> user = userDb.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
