package apap.tutorial.emsidi.service;
import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> getUserList();
    void deleteUser(UserModel user);
    UserModel getUserByUsername(String noUser);

    UserModel  resetPassword(UserModel user, String passwordold, String passwordnew, String confirm);
    UserModel getUserById(String id);
}
