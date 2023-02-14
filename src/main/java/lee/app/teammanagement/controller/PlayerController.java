package lee.app.teammanagement.controller;

import lee.app.teammanagement.exception.ResourceNotFoundException;
import lee.app.teammanagement.model.Player;
import lee.app.teammanagement.repository.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
//        if (playerRepository.existsById(player.getId())) {
//            throw new RuntimeException(player + " already exists!");
//        }
        return playerRepository.save(player);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Player with " + id + " not found"));
        return ResponseEntity.ok(player);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Player with " + id + " not found"));
        player.setName(playerDetails.getName());
        player.setPosition(playerDetails.getPosition());
        player.setEmailId(playerDetails.getEmailId());

        Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayer);
    }
    @DeleteMapping("players/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePlayer(@PathVariable Long id){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Player with " + id + " not found"));
        playerRepository.delete(player);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Successfully deleted - ", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
