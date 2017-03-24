package com.ajira.model;

/**
 * The Class Coordinates.
 *
 * @author Chinnadurai Venkatesan
 */
public class Coordinate {

	/** The x. */
	private final int x;

	/** The y. */
	private final int y;

	/**
	 * Instantiates a new coordinates.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Coordinate(int x, int y) {

		if (x < 0 || x > Integer.MAX_VALUE || y < 0 || y > Integer.MAX_VALUE)
			throw new IllegalArgumentException("Given x and y should be in the range of 1 - 2147483647");
		if (x == 0 && y == 0)
			throw new IllegalArgumentException("X and Y cannot be zero. Starting coordinate is (1,1)");
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param object
	 *            the object
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (!(object instanceof Coordinate))
			return false;
		Coordinate coordinate = (Coordinate) object;
		return Integer.compare(x, coordinate.getX()) == 0 && Integer.compare(y, coordinate.getY()) == 0;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
