package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.service.UserService;
import apap.tutorial.emsidi.service.RoleService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalTime;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";

    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value="/lihat-all")
    public String lihatSemuaUser(Model model){
        List<UserModel> daftarUser = userService.getUserList();

        model.addAttribute("daftarUser", daftarUser);

        return "viewall-user";
    }

    @GetMapping("/delete/{uname}")
    public String deleteUser(@PathVariable String uname, Model model){
        UserModel user = userService.getUserByUsername(uname);
        userService.deleteUser(user);
        return "redirect:/";

    }

    @GetMapping("/update/{id}")
    public String updateUserPasswordForm(@PathVariable String id, Model model){
        UserModel user = userService.getUserById(id);
        if (user == null){
            return "error-page";
        }
        else {
            String passwordold = "";String passwordnew = ""; String acc= "";
            model.addAttribute("user", user);
            model.addAttribute("acc", acc);
            model.addAttribute("passwordnew", passwordnew);
            model.addAttribute("passwordold", passwordold);
            return "form-update-password";
        }
    }

    @PostMapping("/update")
    public String updateUserPasswordSubmit(
            @ModelAttribute UserModel user,
            @RequestParam ("passwordold") String passwordold,
            @RequestParam ("passwordbaru") String passwordnew,
            @RequestParam ("konfirmasi") String konfirmasi,
            Model model
    ){
        UserModel updatedPass = userService.resetPassword(user, passwordold, passwordnew, konfirmasi);
        model.addAttribute("updatedPass", updatedPass);
        return "home";
    }


}