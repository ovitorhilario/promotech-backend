package com.promotech.api.domain.coupon;

import com.promotech.api.domain.user.dto.UserPreviewDTO;

import java.time.Instant;
import java.util.UUID;

public record CouponResponseDTO(UUID id, String title, String description, String code, String link_url, Boolean is_expired, Instant created_at, UserPreviewDTO user) {
}