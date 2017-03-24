package com.ajira.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ajira.maze.validator.Validator;
import com.ajira.model.Coordinate;
import com.ajira.model.Runner;
import com.ajira.model.Vector;

/**
 * The Class Maze.
 *
 * @author Chinnadurai Venkatesan
 */
public abstract class Maze {

	/** The validator. */
	private Validator validator;

	/** The obstacles. */
	private Set<Coordinate> obstacles;

	/** The visited vectors. */
	private List<Vector> visitedVectors;

	/** The runner. */
	private Runner runner;

	/**
	 * Instantiates a new maze.
	 *
	 * @param validator
	 *            the validator
	 * @param runner
	 *            the runner
	 */
	public Maze(Validator validator, Runner runner) {
		this.validator = validator;
		this.runner = runner;
		this.visitedVectors = new ArrayList<>();
		obstacles = new HashSet<>();
	}

	/**
	 * Adds the obstacle.
	 *
	 * @param coordinate
	 *            the coordinate
	 */
	public void addObstacle(Coordinate coordinate) {
		if (validator.validate(coordinate) || !runner.getCurrentPosition().getCoordinate().equals(coordinate))
			obstacles.add(coordinate);
		else {
			throw new IllegalArgumentException("Given Coordinate is not valid.");
		}
	}

	/**
	 * Adds the obstacle.
	 *
	 * @param coordinates
	 *            the coordinates
	 */
	public void addObstacle(Set<Coordinate> coordinates) {
		for (Coordinate coordinate : coordinates)
			if (validator.validate(coordinate) || !runner.getCurrentPosition().getCoordinate().equals(coordinate))
				obstacles.add(coordinate);
			else {
				throw new IllegalArgumentException("Given Coordinate is not valid.");
			}
	}

	/**
	 * Removes the obstacle.
	 *
	 * @param coordinate
	 *            the coordinate
	 */
	public void removeObstacle(Coordinate coordinate) {
		if (obstacles.contains(coordinate))
			obstacles.remove(coordinate);

	}

	/**
	 * Gets the all obstacles.
	 *
	 * @return the all obstacles
	 */
	public Set<Coordinate> getAllObstacles() {
		return Collections.unmodifiableSet(obstacles);
	}

	/**
	 * Can move to.
	 *
	 * @param vector
	 *            the vector
	 * @return true, if successful
	 */
	private boolean canMoveTo(Vector vector) {
		if (validator.isNull(vector) && !validator.validate(vector.getCoordinate()))
			return false;
		return !obstacles.contains(vector.getCoordinate());
	}

	/**
	 * Move to.
	 *
	 * @param vector
	 *            the vector
	 */
	public void moveTo(Vector vector) {
		if (!canMoveTo(vector))
			return;
		runner.setCurrentPosition(vector);
		visitedVectors.add(vector);
	}

	/**
	 * Gets the validator.
	 *
	 * @return the validator
	 */
	public Validator getValidator() {
		return validator;
	}

	/**
	 * Gets the visited path.
	 *
	 * @return the visitedCoordinate
	 */
	public List<Vector> getVisitedPath() {
		return Collections.unmodifiableList(visitedVectors);
	}

	/**
	 * Gets the runner.
	 *
	 * @return the runner
	 */
	public Runner getRunner() {
		return runner;
	}

}
