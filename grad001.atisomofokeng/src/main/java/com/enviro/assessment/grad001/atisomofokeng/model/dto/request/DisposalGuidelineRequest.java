package com.enviro.assessment.grad001.atisomofokeng.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO (Data Transfer Object) for creating or updating a disposal guideline.
 * Encapsulates the necessary data to create or modify a disposal guideline entry.
 */
public class DisposalGuidelineRequest {

  /**
   * Description of the disposal guideline.
   * This field is mandatory and cannot be blank.
   */
  @NotBlank(message = "Tip description must not be blank.")
  private String disposalGuideline;

  /**
   * ID of the associated waste category.
   * This field is mandatory and cannot be null.
   */
  @NotNull(message = "Waste category ID must not be null.")
  private Long wasteCategoryId;

  /**
   * Retrieves the description of the disposal guideline.
   *
   * @return the disposal guideline description
   */
  public String getDisposalGuideline() {
    return disposalGuideline;
  }

  /**
   * Retrieves the ID of the associated waste category.
   *
   * @return the waste category ID
   */
  public Long getWasteCategoryId() {
    return wasteCategoryId;
  }
}
