package com.ajira.maze.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.ajira.maze.MatrixMaze;
import com.ajira.maze.Maze;
import com.ajira.maze.runner.MatrixMazeNavigator;
import com.ajira.model.Coordinate;
import com.ajira.model.Direction;
import com.ajira.model.Runner;
import com.ajira.model.Vector;

/**
 * The Class Test.
 *
 * @author Chinnadurai Venkatesan
 */
public class TestMaze {

	/** The coordinate. */
	private Coordinate coordinate = null;

	/** The upper boundary. */
	private Coordinate upperBoundary = null;

	/** The obstacles. */
	private Set<Coordinate> obstacles = null;

	/** The current position. */
	private Vector currentPosition = null;

	/** The runner. */
	private Runner runner = null;

	/** The maze. */
	private Maze maze = null;

	/** The navigator. */
	private MatrixMazeNavigator navigator = null;

	/**
	 * Instantiates a new test.
	 */
	public TestMaze() {
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

	}

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		coordinate = new Coordinate(1, 1);
		upperBoundary = new Coordinate(10, 10);
		obstacles = new HashSet<>();
		obstacles.add(new Coordinate(1, 2));
		obstacles.add(new Coordinate(2, 2));
		obstacles.add(new Coordinate(1, 3));
		currentPosition = new Vector(coordinate, Direction.North);
		runner = new Runner("Turtle", currentPosition);
		maze = MatrixMaze.getMaze(upperBoundary, runner);
		maze.addObstacle(obstacles);
		navigator = new MatrixMazeNavigator(maze, "FRFFLFFF");

	}

	/**
	 * Test coordinate with zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCoordinateWithZero() {
		new Coordinate(0, 0);
	}

	/**
	 * Test coordinate.
	 */
	@Test
	public void testCoordinate() {
		assertNotEquals("should not be same Object", new Coordinate(1, 1), new Coordinate(1, 2));
		assertEquals("should be same Object", new Coordinate(1, 1), new Coordinate(1, 1));
	}

	/**
	 * Test vector with null.
	 */
	@Test(expected = NullPointerException.class)
	public void testVectorWithNull() {
		new Vector(null, null);
	}

	/**
	 * Test vector with null coordinate.
	 */
	@Test(expected = NullPointerException.class)
	public void testVectorWithNullCoordinate() {

		new Vector(null, Direction.North);
	}

	/**
	 * Test vector with null direction.
	 */
	@Test(expected = NullPointerException.class)
	public void testVectorWithNullDirection() {
		new Vector(coordinate, null);
	}

	/**
	 * Test vector.
	 */
	@Test
	public void testVector() {
		assertEquals("should be same Object", currentPosition.getCoordinate(), coordinate);
		assertEquals("should be same Object", currentPosition.getDirection(), Direction.North);
	}

	/**
	 * Test runner with null name.
	 */
	@Test(expected = NullPointerException.class)
	public void testRunnerWithNullName() {
		new Runner(null, currentPosition);
	}

	/**
	 * Test runner with null vector.
	 */
	@Test(expected = NullPointerException.class)
	public void testRunnerWithNullVector() {
		new Runner("Turtle", null);
	}

	/**
	 * Test runner.
	 */
	@Test
	public void testRunner() {

		assertEquals("should  be same Object", maze.getRunner(), runner);
		assertEquals("should  be same Object", maze.getRunner().getCurrentPosition(), currentPosition);
		assertEquals("should  be same Object", maze.getRunner().getName(), "Turtle");
		assertNotEquals("should not be same Object", maze.getRunner(), new Runner("Turtle", currentPosition));
	}

	/**
	 * Test matrix maze with null coordinate.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeWithNullCoordinate() {
		MatrixMaze.getMaze(null, runner);
	}

	/**
	 * Test matrix maze with null runner.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeWithNullRunner() {
		MatrixMaze.getMaze(upperBoundary, null);
	}

	/**
	 * Test matrix maze with null.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeWithNull() {
		MatrixMaze.getMaze(null, null);
	}

	/**
	 * Test matrix maze navigator with null path.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeNavigatorWithNullPath() {
		new MatrixMazeNavigator(maze, null);
	}

	/**
	 * Test matrix maze navigator with null maze.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeNavigatorWithNullMaze() {
		new MatrixMazeNavigator(null, "FRFFLFFF");
	}

	/**
	 * Test matrix maze navigator with null.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatrixMazeNavigatorWithNull() {
		new MatrixMazeNavigator(null, null);
	}

	/**
	 * Test matrix maze navigator.
	 */
	@Test
	public void testMatrixMazeNavigator() {
		assertEquals("should  be same Object", navigator.getMaze(), maze);
		assertEquals("should  be same Object", navigator.getPath(), "FRFFLFFF");
		System.out.println("Current Position " + runner.getCurrentPosition());
		System.out.println("------------------Running the Navigator-------------------");
		navigator.navigate();
		System.out.println("Current Position " + runner.getCurrentPosition());
		System.out.println("Visited Path " + navigator.getMaze().getVisitedPath());
		System.out.println("Obstacles after visit " + navigator.getMaze().getAllObstacles());
		System.out.println("------------------End-------------------");

	}
}
