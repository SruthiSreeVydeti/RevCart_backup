package com.revcart.user.controller;

import com.revcart.user.entity.Address;
import com.revcart.user.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<List<Address>> getUserAddresses(@RequestParam Long userId) {
        return ResponseEntity.ok(addressRepository.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressRepository.save(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
