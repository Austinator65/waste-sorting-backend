package com.enviro.assessment.grad001.atisomofokeng.model.dto.response;

/**
 * DTO for sending response data of a disposal guideline.
 */
public class DisposalGuidelineResponse {

  private Long id;  // The unique ID of the disposal guideline
  private String disposalGuideline;  // The disposal guideline text
  private String wasteCategoryName;  // The name of the associated waste category

  // Constructor
  public DisposalGuidelineResponse(Long id, String disposalGuideline, String wasteCategoryName) {
    this.id = id;
    this.disposalGuideline = disposalGuideline;
    this.wasteCategoryName = wasteCategoryName;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public String getDisposalGuideline() {
    return disposalGuideline;
  }

  public String getWasteCategoryName() {
    return wasteCategoryName;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setDisposalGuideline(String disposalGuideline)
  {
    this.disposalGuideline = disposalGuideline;
  }

  public void setWasteCategoryName(String wasteCategoryName)
  {
    this.wasteCategoryName = wasteCategoryName;
  }
}
