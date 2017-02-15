package com.account.web;

import com.account.model.User;
import com.account.service.SecurityService;
import com.account.service.UserService;
import com.account.validator.UserValidator;
import com.game.game.GameButtons;
import com.game.logistic.Logistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mcgra on 13.02.2017.
 */
@Controller
public class UserController {

    private GameButtons game = GameButtons.getInstance();

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private Logistic logistic;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }


    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView game(@ModelAttribute("step") String s){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(s);
        Boolean bool = logistic.endGame();
        if (!s.equals("")) {
            game.addButton("O", s);
            bool = logistic.endGame();
            if (!bool) {
                String n = logistic.nextStep();
                if (n.equals("No step")) {
                    modelAndView.addObject("end", logistic.getWinner());
                    System.out.println(logistic.getWinner());
                } else {
                    game.addButton("X", n);
                    bool = logistic.endGame();
                }
            }
        }
        if (bool) {
            modelAndView.addObject("end", logistic.getWinner());
            System.out.println(logistic.getWinner());
        }
        modelAndView.setViewName("game");
        return modelAndView;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ModelAndView gameInit() {
        ModelAndView modelAndView = new ModelAndView();
        logistic.reset();
        modelAndView.setViewName("game");
        return modelAndView;
    }
}
