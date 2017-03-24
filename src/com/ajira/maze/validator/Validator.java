/**
 * 
 */
package com.ajira.maze.validator;

import com.ajira.model.Coordinate;
import com.ajira.model.Vector;

/**
 * The Class Validator.
 *
 * @author Chinnadurai Venkatesan
 */
public abstract class Validator {

	/**
	 * Validate.
	 *
	 * @param coordinate
	 *            the coordinate
	 * @return true, if successful
	 */
	public abstract boolean validate(Coordinate coordinate);

	/**
	 * Checks if is null.
	 *
	 * @param vector
	 *            the vector
	 * @return true, if is null
	 */
	public boolean isNull(Vector vector) {

		if (vector == null || vector.getCoordinate() == null || vector.getDirection() == null)
			return true;
		return false;

	}
}
