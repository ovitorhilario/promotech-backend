package com.promotech.api.controllers;

import com.promotech.api.domain.coupon.dto.CouponRequestDTO;
import com.promotech.api.domain.coupon.dto.CouponUpdateDTO;
import com.promotech.api.domain.user.User;
import com.promotech.api.services.CouponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/list-all")
    ResponseEntity<Object> listAll() {
        return ResponseEntity.ok(couponService.listAll());
    }

    @GetMapping("/list-from-user/{id}")
    ResponseEntity<Object> listFromUser(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(couponService.listFromUser(id));
    }

    @PostMapping("/create")
    ResponseEntity<Object> create(Authentication auth, @RequestBody @Valid CouponRequestDTO dto) {
        User user = (User) auth.getPrincipal();
        return ResponseEntity.ok(couponService.create(dto, user));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Object> update(Authentication auth, @RequestBody @Valid CouponUpdateDTO dto, @PathVariable(name = "id") UUID id) throws IllegalAccessException {
        User user = (User) auth.getPrincipal();
        return ResponseEntity.ok(couponService.update(dto, id, user));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> delete(Authentication auth, @PathVariable UUID id) {
        User user = (User) auth.getPrincipal();
        couponService.delete(id, user);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<Object> handleDeniedException(final IllegalAccessException ex) {
        return new ResponseEntity("Access Denied", HttpStatus.UNAUTHORIZED);
    }
}
