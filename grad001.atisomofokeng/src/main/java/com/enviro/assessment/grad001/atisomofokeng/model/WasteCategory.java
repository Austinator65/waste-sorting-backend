package com.enviro.assessment.grad001.atisomofokeng.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entity class representing a Waste Category.
 * Maps to the "waste_category" table in the database.
 * Each category can have multiple recycling tips and disposal guidelines associated with it.
 */
@Entity
@Table(name = "waste_category")
public class WasteCategory {

  // Primary key for the WasteCategory table, with auto-generated values.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Column for the category name.
  // This field is mandatory (nullable = false) and must be unique across categories.
  @Column(name = "category_name", nullable = false, unique = true)
  private String categoryName;

  // One-to-many relationship with the RecyclingTip entity.
  // The "wasteCategory" field in RecyclingTip is the mappedBy reference.
  // Cascade operations allow automatic propagation of persistence operations (e.g., save, delete).
  // Orphan removal ensures that any RecyclingTip no longer associated with this category is deleted.
  @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RecyclingTip> recyclingTips;

  // One-to-many relationship with the DisposalGuideline entity.
  // The "wasteCategory" field in DisposalGuideline is the mappedBy reference.
  // Cascade and orphan removal are configured similarly to the RecyclingTip relationship.
  @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<DisposalGuideline> disposalGuidelines;

  /**
   * Parameterized constructor for creating a WasteCategory with a specified name.
   *
   * @param categoryName The name of the waste category.
   */
  public WasteCategory(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   * Default no-argument constructor.
   * Required by JPA for entity instantiation.
   */
  public WasteCategory() {}

  // Getters and setters

  /**
   * Retrieves the ID of the waste category.
   *
   * @return The ID of the waste category.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the waste category.
   *
   * @param id The ID to set.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Retrieves the name of the waste category.
   *
   * @return The category name.
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * Sets the name of the waste category.
   *
   * @param categoryName The name to set for the category.
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   * Retrieves the list of recycling tips associated with this category.
   *
   * @return A list of RecyclingTip entities.
   */
  public List<RecyclingTip> getRecyclingTips() {
    return recyclingTips;
  }

  /**
   * Sets the list of recycling tips associated with this category.
   *
   * @param recyclingTips The list of RecyclingTip entities to associate.
   */
  public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
    this.recyclingTips = recyclingTips;
  }

  /**
   * Retrieves the list of disposal guidelines associated with this category.
   *
   * @return A list of DisposalGuideline entities.
   */
  public List<DisposalGuideline> getDisposalGuidelines() {
    return disposalGuidelines;
  }

  /**
   * Sets the list of disposal guidelines associated with this category.
   *
   * @param disposalGuidelines The list of DisposalGuideline entities to associate.
   */
  public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
    this.disposalGuidelines = disposalGuidelines;
  }
}
