package com.enviro.assessment.grad001.atisomofokeng.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Disposal Guideline.
 * Maps to the "disposal_guidelines" table in the database.
 */
@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

  // Primary key for the DisposalGuideline table, with auto-generated values.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Column to store the disposal guideline text, cannot be null and has a max length of 255 characters.
  @Column(nullable = false, length = 255)
  private String disposalGuideline;

  // Many-to-one relationship with the WasteCategory entity.
  // Fetch type is LAZY to avoid fetching the related WasteCategory unless explicitly needed.
  // The relationship is mandatory (nullable = false), and "category_id" is the foreign key column.
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private WasteCategory wasteCategory;

  /**
   * Default no-argument constructor.
   * Required by JPA for entity instantiation.
   */
  public DisposalGuideline() {
  }

  /**
   * Constructor for initializing the entity with a guideline and waste category.
   * Primarily used for testing or object creation in service layers.
   *
   * @param disposalGuideline The disposal guideline text.
   * @param wasteCategory The associated waste category.
   */
  public DisposalGuideline(String disposalGuideline, WasteCategory wasteCategory) {
    this.disposalGuideline = disposalGuideline;
    this.wasteCategory = wasteCategory;
  }

  /**
   * Sets the waste category associated with this guideline.
   *
   * @param wasteCategory The WasteCategory entity.
   */
  public void setWasteCategory(WasteCategory wasteCategory) {
    this.wasteCategory = wasteCategory;
  }

  /**
   * Sets the disposal guideline text.
   *
   * @param disposalGuideline The text of the disposal guideline.
   */
  public void setDisposalGuideline(String disposalGuideline) {
    this.disposalGuideline = disposalGuideline;
  }

  /**
   * Retrieves the ID of the disposal guideline.
   *
   * @return The ID of the guideline.
   */
  public Long getId() {
    return id;
  }

  /**
   * Retrieves the disposal guideline text.
   *
   * @return The text of the guideline.
   */
  public String getDisposalGuideline() {
    return disposalGuideline;
  }

  /**
   * Retrieves the associated waste category.
   *
   * @return The WasteCategory entity linked to this guideline.
   */
  public WasteCategory getWasteCategory() {
    return wasteCategory;
  }
}
