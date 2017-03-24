package com.ajira.model;

/**
 * The Class Vector.
 *
 * @author Chinnadurai Venkatesan
 */
public class Vector {

	/** The coordinate. */
	private Coordinate coordinate;

	/** The direction. */
	private Direction direction;

	/**
	 * Instantiates a new vector.
	 *
	 * @param coordinate
	 *            the coordinate
	 * @param direction
	 *            the direction
	 */
	public Vector(Coordinate coordinate, Direction direction) {
		if (coordinate == null || direction == null)
			throw new NullPointerException("coordinate or direction cannot be null");
		this.coordinate = coordinate;
		this.direction = direction;
	}

	/**
	 * Gets the coordinate.
	 *
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return coordinate.toString() + " " + direction;
	}

}
