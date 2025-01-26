package com.enviro.assessment.grad001.atisomofokeng.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * Entity class representing a Recycling Tip.
 * Maps to the "recycling_tips" table in the database.
 */
@Entity
@Table(name = "recycling_tips")
public class RecyclingTip {

  // Primary key for the RecyclingTip table, with auto-generated values.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Column to store the recycling tip text.
  // Validation ensures the tip is not blank.
  @NotBlank(message = "Tip must not be blank.")
  private String recyclingTip;

  // Many-to-one relationship with the WasteCategory entity.
  // Fetch type is LAZY to optimize performance, avoiding loading the entire WasteCategory unless explicitly accessed.
  // The relationship is mandatory (nullable = false), with "category_id" as the foreign key.
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private WasteCategory wasteCategory;

  /**
   * Default no-argument constructor.
   * Required by JPA for entity instantiation.
   */
  public RecyclingTip() {}

  /**
   * Constructor for initializing the entity with a tip and waste category.
   * Primarily used for testing or object creation in service layers.
   *
   * @param tip The recycling tip text.
   * @param wasteCategory The associated waste category.
   */
  public RecyclingTip(String tip, WasteCategory wasteCategory) {
    this.recyclingTip = tip;
    this.wasteCategory = wasteCategory;
  }

  /**
   * Retrieves the ID of the recycling tip.
   *
   * @return The ID of the tip.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the recycling tip.
   *
   * @param id The ID to set for the tip.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Retrieves the recycling tip text.
   *
   * @return The text of the recycling tip.
   */
  public String getRecyclingTip() {
    return recyclingTip;
  }

  /**
   * Sets the recycling tip text.
   *
   * @param tip The text to set for the recycling tip.
   */
  public void setRecyclingTip(String tip) {
    this.recyclingTip = tip;
  }

  /**
   * Retrieves the associated waste category.
   *
   * @return The WasteCategory entity linked to this tip.
   */
  public WasteCategory getWasteCategory() {
    return wasteCategory;
  }

  /**
   * Sets the waste category associated with this tip.
   *
   * @param wasteCategory The WasteCategory entity to associate with this tip.
   */
  public void setWasteCategory(WasteCategory wasteCategory) {
    this.wasteCategory = wasteCategory;
  }
}
