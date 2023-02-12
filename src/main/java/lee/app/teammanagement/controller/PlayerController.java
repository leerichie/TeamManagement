package lee.app.teammanagement.controller;

import lee.app.teammanagement.model.Player;
import lee.app.teammanagement.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
}
