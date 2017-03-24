package com.ajira.model;

/**
 * The Class Runner.
 *
 * @author Chinnadurai Venkatesan
 */
public class Runner {

	/** The name. */
	private String name;

	/** The vector. */
	private Vector currentPosition;

	/**
	 * Instantiates a new runner.
	 *
	 * @param name
	 *            the name
	 * @param currentPosition
	 *            the current position
	 */
	public Runner(String name, Vector currentPosition) {

		if (name == null || currentPosition == null)
			throw new NullPointerException("CurrentPosition or name cannot be null");
		this.name = name;
		this.currentPosition = currentPosition;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the current position.
	 *
	 * @return the currentPosition
	 */
	public Vector getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Sets the current position.
	 *
	 * @param currentPosition
	 *            the currentPosition to set
	 */
	public void setCurrentPosition(Vector currentPosition) {
		if (currentPosition == null)
			throw new NullPointerException("Given currentPosition cannot be null");
		this.currentPosition = currentPosition;
	}

}
