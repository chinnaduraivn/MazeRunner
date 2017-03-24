package com.ajira.maze.validator;

import com.ajira.model.Coordinate;

/**
 * The Class MatrixMazeValidator.
 *
 * @author Chinnadurai Venkatesan
 */
public class MatrixMazeValidator extends Validator {

	/** The upper boundary. */
	private Coordinate upperBoundary;

	/**
	 * Instantiates a new matrix maze validator.
	 *
	 * @param upperBoundary
	 *            the upper boundary
	 */
	public MatrixMazeValidator(Coordinate upperBoundary) {
		if (upperBoundary == null)
			throw new NullPointerException("Given upperBoundary cannot be null");
		this.upperBoundary = upperBoundary;
	}

	/**
	 * Validate.
	 *
	 * @param coordinate
	 *            the coordinate
	 * @return true, if successful
	 */
	@Override
	public boolean validate(Coordinate coordinate) {

		if (coordinate == null)
			return false;

		boolean upperBoundaryCondition = upperBoundary.getX() >= coordinate.getX()
				& upperBoundary.getY() >= coordinate.getY();
		boolean lowerBoundaryCondition = 1 <= coordinate.getX() & 1 <= coordinate.getY();

		return upperBoundaryCondition & lowerBoundaryCondition;
	}

}
