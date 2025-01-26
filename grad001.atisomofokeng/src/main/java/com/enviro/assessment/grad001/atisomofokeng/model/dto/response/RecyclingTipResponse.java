package com.enviro.assessment.grad001.atisomofokeng.model.dto.response;

/**
 * DTO (Data Transfer Object) for Recycling Tip responses.
 * Encapsulates the data to be returned to the client for recycling tips,
 * including the associated waste category.
 */
public class RecyclingTipResponse {

  // Unique identifier of the recycling tip
  private Long id;

  // Description of the recycling tip
  private String recyclingTip;

  // Name of the associated waste category
  private String wasteCategoryName;

  /**
   * Constructor for creating a complete RecyclingTipResponse with all fields.
   *
   * @param id                the unique identifier of the recycling tip.
   * @param tipDescription    the description or content of the recycling tip.
   * @param wasteCategoryName the name of the associated waste category.
   */
  public RecyclingTipResponse(Long id, String tipDescription, String wasteCategoryName) {
    this.id = id;
    this.recyclingTip = tipDescription;
    this.wasteCategoryName = wasteCategoryName;
  }

  /**
   * Constructor for creating a RecyclingTipResponse without an associated category name.
   *
   * @param id             the unique identifier of the recycling tip.
   * @param tipDescription the description or content of the recycling tip.
   */
  public RecyclingTipResponse(Long id, String tipDescription) {
    this.id = id;
    this.recyclingTip = tipDescription;
  }

  // Getters and Setters

  /**
   * Gets the unique identifier of the recycling tip.
   *
   * @return the ID of the recycling tip.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the unique identifier of the recycling tip.
   *
   * @param id the ID to set.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the description of the recycling tip.
   *
   * @return the recycling tip description.
   */
  public String getRecyclingTip() {
    return recyclingTip;
  }

  /**
   * Sets the description of the recycling tip.
   *
   * @param recyclingTip the recycling tip description to set.
   */
  public void setRecyclingTip(String recyclingTip) {
    this.recyclingTip = recyclingTip;
  }

  /**
   * Gets the name of the associated waste category.
   *
   * @return the waste category name.
   */
  public String getWasteCategoryName() {
    return wasteCategoryName;
  }

  /**
   * Sets the name of the associated waste category.
   *
   * @param wasteCategoryName the waste category name to set.
   */
  public void setWasteCategoryName(String wasteCategoryName) {
    this.wasteCategoryName = wasteCategoryName;
  }
}
