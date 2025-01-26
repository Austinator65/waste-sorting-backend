package com.enviro.assessment.grad001.atisomofokeng.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * DTO (Data Transfer Object) for creating or updating a recycling tip.
 * Encapsulates the necessary data to create or modify a recycling tip entry.
 */
public class RecyclingTipRequest {

  @NotBlank(message = "Tip description must not be blank.")
  private String recyclingTip;

  @NotNull(message = "Waste category ID must not be null.")
  private Long wasteCategoryId;

  // Getters and Setters
  public String getRecyclingTip() {
    return recyclingTip;
  }

  public Long getWasteCategoryId() {
    return wasteCategoryId;
  }

}
