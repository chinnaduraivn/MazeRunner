package com.ajira.utility;

import com.ajira.model.Coordinate;
import com.ajira.model.Direction;
import com.ajira.model.Vector;

/**
 * The Class VectorUtility.
 *
 * @author Chinnadurai Venkatesan
 */
public class VectorUtility {

	/** The vector utility. */
	private static VectorUtility vectorUtility;

	/**
	 * Instantiates a new vector utility.
	 */
	private VectorUtility() {
	}

	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static VectorUtility getinstance() {
		if (vectorUtility == null)
			vectorUtility = new VectorUtility();
		return vectorUtility;
	}

	/**
	 * Gets the right vector.
	 *
	 * @param vector
	 *            the vector
	 * @return the right vector
	 */
	public Vector getRightVector(Vector vector) {
		if (vector != null && isNull(vector))
			return vector;
		Coordinate currentCoordinate = vector.getCoordinate();
		Coordinate nextCoordinate = null;
		Direction direction = null;
		if (vector.getDirection() == Direction.North) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
			direction = Direction.East;
		} else if (vector.getDirection() == Direction.East) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
			direction = Direction.South;
		} else if (vector.getDirection() == Direction.South) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
			direction = Direction.West;
		} else if (vector.getDirection() == Direction.West) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
			direction = Direction.North;
		}
		return new Vector(nextCoordinate, direction);
	}

	/**
	 * Gets the left vector.
	 *
	 * @param vector
	 *            the vector
	 * @return the left vector
	 */
	public Vector getLeftVector(Vector vector) {
		if (vector != null && isNull(vector))
			return vector;
		Coordinate currentCoordinate = vector.getCoordinate();
		Coordinate nextCoordinate = null;
		Direction direction = null;
		if (vector.getDirection() == Direction.North) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
			direction = Direction.West;
		} else if (vector.getDirection() == Direction.East) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
			direction = Direction.North;
		} else if (vector.getDirection() == Direction.South) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
			direction = Direction.East;
		} else if (vector.getDirection() == Direction.West) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
			direction = Direction.South;
		}
		return new Vector(nextCoordinate, direction);
	}

	/**
	 * Gets the forward vector.
	 *
	 * @param vector
	 *            the vector
	 * @return the forward vector
	 */
	public Vector getForwardVector(Vector vector) {
		if (vector != null && isNull(vector))
			return vector;
		Coordinate currentCoordinate = vector.getCoordinate();
		Coordinate nextCoordinate = null;
		Direction direction = null;
		if (vector.getDirection() == Direction.North) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
			direction = Direction.North;
		} else if (vector.getDirection() == Direction.East) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
			direction = Direction.East;
		} else if (vector.getDirection() == Direction.South) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
			direction = Direction.South;
		} else if (vector.getDirection() == Direction.West) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
			direction = Direction.West;
		}
		return new Vector(nextCoordinate, direction);
	}

	/**
	 * Gets the backward vector.
	 *
	 * @param vector
	 *            the vector
	 * @return the backward vector
	 */
	public Vector getBackwardVector(Vector vector) {
		if (vector != null && isNull(vector))
			return vector;
		Coordinate currentCoordinate = vector.getCoordinate();
		Coordinate nextCoordinate = null;
		Direction direction = null;
		if (vector.getDirection() == Direction.North) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
			direction = Direction.South;
		} else if (vector.getDirection() == Direction.East) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
			direction = Direction.West;
		} else if (vector.getDirection() == Direction.South) {
			nextCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
			direction = Direction.North;
		} else if (vector.getDirection() == Direction.West) {
			nextCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
			direction = Direction.East;
		}
		return new Vector(nextCoordinate, direction);
	}

	/**
	 * Checks if is null.
	 *
	 * @param vector
	 *            the vector
	 * @return true, if is null
	 */
	private boolean isNull(Vector vector) {

		if (vector.getCoordinate() == null || vector.getDirection() == null)
			return true;
		return false;

	}

}
