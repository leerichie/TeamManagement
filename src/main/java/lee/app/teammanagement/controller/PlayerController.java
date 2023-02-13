package lee.app.teammanagement.controller;

import lee.app.teammanagement.model.Player;
import lee.app.teammanagement.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        if(playerRepository.existsById(player.getId())){
            throw new RuntimeException(player + " already exists!");
        }
        return playerRepository.save(player);
    }


}
