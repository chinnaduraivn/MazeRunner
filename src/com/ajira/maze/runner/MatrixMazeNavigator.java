package com.ajira.maze.runner;

import com.ajira.maze.Maze;
import com.ajira.model.Vector;
import com.ajira.utility.VectorUtility;


/**
 * The Class MatrixMazeNavigator.
 *
 * @author Chinnadurai Venkatesan
 */
public class MatrixMazeNavigator implements MazeNavigator {

	/** The vector utility. */
	private VectorUtility vectorUtility;

	/** The maze. */
	private Maze maze;

	/** The path. */
	private String path;

	/**
	 * Instantiates a new matrix maze navigator.
	 *
	 * @param maze
	 *            the maze
	 * @param path
	 *            the path
	 */
	public MatrixMazeNavigator(Maze maze, String path) {
		if (maze == null || path == null || path.length() < 1)
			throw new NullPointerException("Maze or Path cannot be null");
		this.vectorUtility = VectorUtility.getinstance();
		this.maze = maze;
		this.path = path;

	}

	/**
	 * Navigate.
	 */
	public void navigate() {
		Vector vector = null;
		for (char move : path.toCharArray()) {
			if (move == 'F' || move == 'f')
				vector = vectorUtility.getForwardVector(maze.getRunner().getCurrentPosition());
			else if (move == 'R' || move == 'r')
				vector = vectorUtility.getRightVector(maze.getRunner().getCurrentPosition());
			else if (move == 'L' || move == 'l')
				vector = vectorUtility.getLeftVector(maze.getRunner().getCurrentPosition());
			else if (move == 'B' || move == 'b')
				vector = vectorUtility.getBackwardVector(maze.getRunner().getCurrentPosition());

			maze.moveTo(vector);

		}

	}

	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

}
