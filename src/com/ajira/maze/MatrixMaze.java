package com.ajira.maze;

import com.ajira.maze.validator.MatrixMazeValidator;
import com.ajira.maze.validator.Validator;
import com.ajira.model.Coordinate;
import com.ajira.model.Runner;


/**
 * The Class MatrixMaze.
 *
 * @author Chinnadurai Venkatesan
 */
public class MatrixMaze extends Maze {

	/**
	 * Gets the maze.
	 *
	 * @param upperBoundary
	 *            the upper boundary
	 * @param runner
	 *            the runner
	 * @return the maze
	 */
	public static Maze getMaze(Coordinate upperBoundary, Runner runner) {
		if (upperBoundary == null || runner == null)
			throw new NullPointerException("Given Coordinate or Runner cannot be null");
		Validator validator = new MatrixMazeValidator(upperBoundary);
		return new MatrixMaze(validator, runner);

	}

	/**
	 * Instantiates a new matrix maze.
	 *
	 * @param validator
	 *            the validator
	 * @param runner
	 *            the runner
	 */
	private MatrixMaze(Validator validator, Runner runner) {
		super(validator, runner);
	}

}
