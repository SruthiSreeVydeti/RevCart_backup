package com.revcart.delivery.controller;

import com.revcart.delivery.entity.DeliveryAgent;
import com.revcart.delivery.repository.DeliveryAgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/delivery-agent")
@RequiredArgsConstructor
public class DeliveryAgentController {

    private final DeliveryAgentRepository agentRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        DeliveryAgent agent = agentRepository.findByEmail(email);
        
        if (agent != null && agent.getPassword().equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("agent", agent);
            response.put("token", "delivery-token-" + agent.getId());
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody DeliveryAgent agent) {
        if (agentRepository.findByEmail(agent.getEmail()) != null) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Email already exists"));
        }
        
        agent.setActive(true);
        DeliveryAgent savedAgent = agentRepository.save(agent);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("agent", savedAgent);
        response.put("token", "delivery-token-" + savedAgent.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAgent> getAgent(@PathVariable Long id) {
        return agentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeliveryAgent> updateAgentStatus(@PathVariable Long id, @RequestParam String status) {
        return agentRepository.findById(id)
                .map(agent -> {
                    agent.setStatus(status);
                    return ResponseEntity.ok(agentRepository.save(agent));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAgentOrders() {
        return ResponseEntity.ok(java.util.Collections.emptyList());
    }
}
