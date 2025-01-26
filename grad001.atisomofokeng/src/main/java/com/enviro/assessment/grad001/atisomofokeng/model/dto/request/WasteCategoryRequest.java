package com.enviro.assessment.grad001.atisomofokeng.model.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO (Data Transfer Object) for creating or updating a waste category.
 * Encapsulates the necessary data to create or modify a waste category entry.
 */
public class WasteCategoryRequest {

  @NotBlank(message = "Category name must not be empty.")
  private String categoryName;

  // Getters and setters
  public String getCategoryName() {
    return categoryName;
  }

}
