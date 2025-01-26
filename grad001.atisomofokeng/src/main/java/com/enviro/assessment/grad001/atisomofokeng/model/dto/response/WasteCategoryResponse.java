package com.enviro.assessment.grad001.atisomofokeng.model.dto.response;

import java.util.List;

/**
 * DTO (Data Transfer Object) representing a Waste Category response.
 * Encapsulates data about a specific waste category, including its associated
 * recycling tips and disposal guidelines.
 */
public class WasteCategoryResponse {

  // Unique identifier for the waste category
  private Long id;

  // Name of the waste category
  private String wasteCategory;

  // List of associated recycling tips for this category
  private List<RecyclingTipResponse> recyclingTips;

  // List of associated disposal guidelines for this category
  private List<DisposalGuidelineResponse> disposalGuidelines;

  /**
   * Full constructor to initialize all fields.
   *
   * @param id                  the unique identifier of the waste category
   * @param wasteCategory       the name of the waste category
   * @param recyclingTips       a list of recycling tips associated with the category
   * @param disposalGuidelines  a list of disposal guidelines associated with the category
   */
  public WasteCategoryResponse(Long id, String wasteCategory, List<RecyclingTipResponse> recyclingTips, List<DisposalGuidelineResponse> disposalGuidelines) {
    this.wasteCategory = wasteCategory;
    this.id = id;
    this.recyclingTips = recyclingTips;
    this.disposalGuidelines = disposalGuidelines;
  }

  /**
   * Minimal constructor for initializing a WasteCategoryResponse with only
   * essential fields.
   *
   * @param id            the unique identifier of the waste category
   * @param wasteCategory the name of the waste category
   */
  public WasteCategoryResponse(Long id, String wasteCategory) {
    this.id = id;
    this.wasteCategory = wasteCategory;
  }

  // Getters and setters

  /**
   * Retrieves the name of the waste category.
   *
   * @return the name of the waste category
   */
  public String getWasteCategory() {
    return wasteCategory;
  }

  /**
   * Updates the name of the waste category.
   *
   * @param wasteCategory the new name of the waste category
   */
  public void setWasteCategory(String wasteCategory) {
    this.wasteCategory = wasteCategory;
  }

  /**
   * Retrieves the list of recycling tips associated with this waste category.
   *
   * @return a list of recycling tips
   */
  public List<RecyclingTipResponse> getRecyclingTips() {
    return recyclingTips;
  }

  /**
   * Sets the list of recycling tips associated with this waste category.
   *
   * @param recyclingTips a list of recycling tips
   */
  public void setRecyclingTips(List<RecyclingTipResponse> recyclingTips) {
    this.recyclingTips = recyclingTips;
  }

  /**
   * Retrieves the list of disposal guidelines associated with this waste category.
   *
   * @return a list of disposal guidelines
   */
  public List<DisposalGuidelineResponse> getDisposalGuidelines() {
    return disposalGuidelines;
  }

  /**
   * Sets the list of disposal guidelines associated with this waste category.
   *
   * @param disposalGuidelines a list of disposal guidelines
   */
  public void setDisposalGuidelines(List<DisposalGuidelineResponse> disposalGuidelines) {
    this.disposalGuidelines = disposalGuidelines;
  }

  /**
   * Retrieves the unique identifier of the waste category.
   *
   * @return the unique identifier
   */
  public Long getId() {
    return id;
  }

  /**
   * Updates the unique identifier of the waste category.
   *
   * @param id the new unique identifier
   */
  public void setId(Long id) {
    this.id = id;
  }
}
