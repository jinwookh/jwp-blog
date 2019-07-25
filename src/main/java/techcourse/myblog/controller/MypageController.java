package techcourse.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import techcourse.myblog.domain.User;
import techcourse.myblog.service.UserService;
import techcourse.myblog.service.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MypageController {
    private final UserService userService;

    public MypageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        setUserToModelBySession(model, session);
        return "mypage";
    }

    @PostMapping("/mypage")
    public String updateProfile(@ModelAttribute UserDTO userDTO, HttpServletRequest request) {
        User user = userService.update(userDTO);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/mypage";
    }

    @GetMapping("/mypage/edit")
    public String myPageEdit(HttpSession session, Model model) {
        setUserToModelBySession(model, session);
        return "mypage-edit";
    }

    private void setUserToModelBySession(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
    }
}
