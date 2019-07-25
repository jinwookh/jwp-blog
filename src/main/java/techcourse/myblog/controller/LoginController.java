package techcourse.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import techcourse.myblog.domain.User;
import techcourse.myblog.exception.LoginFailException;
import techcourse.myblog.exception.UserNotExistException;
import techcourse.myblog.service.LoginService;
import techcourse.myblog.service.dto.LoginDTO;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm(String loginError, Model model) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute LoginDTO loginDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        try {
            User user = loginService.getLoginUser(loginDTO);
            session.setAttribute("user", user);
            return new RedirectView("/");
        } catch (UserNotExistException | LoginFailException e) {
            redirectAttributes.addAttribute("loginError", e.getMessage());
            return new RedirectView("/login");
        }
    }
}
