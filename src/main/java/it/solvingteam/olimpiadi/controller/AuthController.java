package it.solvingteam.olimpiadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.solvingteam.olimpiadi.dto.UtenteSigninMessageDTO;
import it.solvingteam.olimpiadi.service.UtenteService;

@Controller
@RequestMapping("auth")
public class AuthController {

//    @Autowired
//    private UtenteService userService;

//    @Autowired
//    private UtenteSignupMessageValidator userSignupMessageValidator;

//    @GetMapping("signup")
//    public String signup(Model model) {
//        model.addAttribute("userSignupModel", new UtenteSignupMessageDto());
//        return "auth/signup";
//    }

//    @PostMapping("signup")
//    public String signup(@Valid @ModelAttribute("userSignupModel") UtenteSignupMessageDto userSignupMessageDto, BindingResult bindingResult) throws RoleNotFoundException {
//        userSignupMessageValidator.validate(userSignupMessageDto, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "auth/signup";
//        } else {
//            userService.signup(userSignupMessageDto);
//            return "redirect:/auth/signin";
//        }
//    }

    @GetMapping("signin")
    public String signin(Model model) {
        model.addAttribute("utenteSigninDTO", new UtenteSigninMessageDTO());
        return "auth/signin";
    }

}
