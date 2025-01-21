package com.promotech.api.domain.promotion.dto;

import com.promotech.api.domain.category.dto.CategoryPreviewDTO;
import com.promotech.api.domain.store.dto.StorePreviewDTO;
import com.promotech.api.domain.user.dto.UserPreviewDTO;

import java.util.Date;
import java.util.UUID;

public record PromotionResponseDTO(UUID id, String title, String description, Float price, String img_url, String link_url, Date created_at, CategoryPreviewDTO category, UserPreviewDTO user, StorePreviewDTO store) {
}
