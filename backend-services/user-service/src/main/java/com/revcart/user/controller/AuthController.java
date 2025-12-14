package com.revcart.user.controller;

import com.revcart.user.dto.*;
import com.revcart.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        try {
            System.out.println("Signup request: " + request);
            AuthResponse response = authService.signup(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            System.err.println("Signup error: " + e.getMessage());
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest request) {
        try {
            System.out.println("Signin attempt: " + request.getEmail());
            AuthResponse response = authService.signin(request);
            System.out.println("Signin successful");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("Signin error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("Token is valid");
    }
    
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        authService.verifyOtp(email, otp);
        return ResponseEntity.ok().body("{\"message\":\"Email verified successfully\"}");
    }
    
    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestParam String email) {
        authService.resendOtp(email);
        return ResponseEntity.ok().body("{\"message\":\"OTP sent successfully\"}");
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        authService.sendPasswordResetOtp(email);
        return ResponseEntity.ok().body("{\"message\":\"OTP sent to your email\"}");
    }
    
    @PostMapping("/verify-reset-otp")
    public ResponseEntity<?> verifyResetOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = authService.verifyPasswordResetOtp(email, otp);
        if (valid) {
            return ResponseEntity.ok().body("{\"message\":\"OTP verified\",\"valid\":true}");
        }
        return ResponseEntity.badRequest().body("{\"message\":\"Invalid OTP\",\"valid\":false}");
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        authService.resetPassword(email, newPassword);
        return ResponseEntity.ok().body("{\"message\":\"Password reset successfully\"}");
    }

    @PostMapping("/oauth2/google")
    public ResponseEntity<AuthResponse> googleLogin(@RequestBody String credential) {
        return ResponseEntity.ok(authService.googleLogin(credential));
    }
}
