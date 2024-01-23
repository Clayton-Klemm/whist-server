package com.clayton.whistserver.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.clayton.whistserver.service.LobbyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;


@Controller
public class GameController {

    // This annotation allows Spring to resolve and inject collaborating beans into our bean
    @Autowired
    private LobbyService lobbyService;

    // This annotation ensures that HTTP GET requests are mapped to this method
    @GetMapping("/")
    public String getUserInfo(HttpSession session, Model model) {
        if (session.getAttribute("name") != null) {
            model.addAttribute("name", session.getAttribute("name"));
        }
        return "index";
    }

    @PostMapping("/submitName")
    public String submitName(@RequestParam String name, HttpSession session) {
        session.setAttribute("name", name);
        return "redirect:/lobby";
    }

    @GetMapping("/showCreateLobby")
    public String showCreateLobbyForm(HttpSession session, Model model) {
        model.addAttribute("name", session.getAttribute("name")); // add id, name, to model
        return "createLobby";
    }

    @PostMapping("/createLobby")
    public String handleCreateLobby(@RequestParam String lobbyName, Model model, HttpSession session) {
        lobbyService.createLobby(lobbyName);
        return "sessionQue";
    }

    @GetMapping("/lobby")
    public String showLobbyPage(Model model, HttpSession session) {
        model.addAttribute("lobbies", lobbyService.listLobbies());
        model.addAttribute("name", session.getAttribute("name"));
        return "lobby";
    }

}
