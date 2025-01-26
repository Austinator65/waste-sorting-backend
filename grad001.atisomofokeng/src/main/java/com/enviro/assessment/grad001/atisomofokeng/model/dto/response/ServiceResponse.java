package com.enviro.assessment.grad001.atisomofokeng.model.dto.response;

import java.net.URI;

/**
 * Generic DTO (Data Transfer Object) for encapsulating service responses.
 * Provides a standardized structure to return both the data and its location (if applicable).
 *
 * @param <T> the type of the response data being encapsulated.
 */
public class ServiceResponse<T> {

  // The response data of generic type T
  private T response;

  // The URI location of the resource, if applicable
  private URI location;

  /**
   * Constructor to create a ServiceResponse with the provided data and location.
   *
   * @param response the actual data or response to be encapsulated.
   * @param location the URI of the created or updated resource, or null if not applicable.
   */
  public ServiceResponse(T response, URI location) {
    this.response = response;
    this.location = location;
  }

  /**
   * Gets the encapsulated response data.
   *
   * @return the response data of type T.
   */
  public T getResponse() {
    return response;
  }

  /**
   * Gets the URI location of the resource.
   *
   * @return the URI location, or null if not applicable.
   */
  public URI getLocation() {
    return location;
  }
}
