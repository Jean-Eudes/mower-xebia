package eu.jeaneudes.xebia.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import eu.jeaneudes.xebia.*;

/**
 *
 */
public class MowerTest {

    private Surface surface;

    @Before
    public void init() {
        surface = mock(Surface.class);
        when(surface.isPointInSurface(anyInt(), anyInt())).thenReturn(true);
    }

    @Test
    public void testDefaultConstructor() {
        Mower mower = new Mower(surface);
        Assert.assertEquals(mower.getX(), 0);
        Assert.assertEquals(mower.getY(), 0);
        Assert.assertSame(mower.getOrientation(), Orientation.N);
    }

    @Test
    public void testAdvanceInNorth() {
        Mower mower = new Mower(surface);
        mower.advance();
        Assert.assertEquals(mower.getX(), 0);
        Assert.assertEquals(mower.getY(), 1);
        Assert.assertSame(mower.getOrientation(), Orientation.N);
    }

    @Test
    public void testAdvanceInEst() {
        Mower mower = new Mower(0, 0, Orientation.E, surface);
        mower.advance();
        Assert.assertEquals(mower.getX(), 1);
        Assert.assertEquals(mower.getY(), 0);
        Assert.assertSame(mower.getOrientation(), Orientation.E);
    }

    @Test
    public void testAdvanceInWest() {
        Mower mower = new Mower(2, 2, Orientation.W, surface);
        mower.advance();
        Assert.assertEquals(mower.getX(), 1);
        Assert.assertEquals(mower.getY(), 2);
        Assert.assertSame(mower.getOrientation(), Orientation.W);
    }

    @Test
    public void testAdvanceInSouth() {
        Mower mower = new Mower(2, 2, Orientation.S, surface);
        mower.advance();
        Assert.assertEquals(mower.getX(), 2);
        Assert.assertEquals(mower.getY(), 1);
        Assert.assertSame(mower.getOrientation(), Orientation.S);
    }

    @Test
    public void testTurnLeft() {
        Mower mower = new Mower(surface);
        Assert.assertSame(mower.getOrientation(), Orientation.N);
        mower.turnLeft();
        Assert.assertSame(mower.getOrientation(), Orientation.W);
        mower.turnLeft();
        Assert.assertSame(mower.getOrientation(), Orientation.S);
        mower.turnLeft();
        Assert.assertSame(mower.getOrientation(), Orientation.E);
        mower.turnLeft();
        Assert.assertSame(mower.getOrientation(), Orientation.N);
    }

    @Test
    public void testTurnRight() {
        Mower mower = new Mower(surface);
        Assert.assertSame(mower.getOrientation(), Orientation.N);
        mower.turnRight();
        Assert.assertSame(mower.getOrientation(), Orientation.E);
        mower.turnRight();
        Assert.assertSame(mower.getOrientation(), Orientation.S);
        mower.turnRight();
        Assert.assertSame(mower.getOrientation(), Orientation.W);
        mower.turnRight();
        Assert.assertSame(mower.getOrientation(), Orientation.N);
    }
    
    @Test
    public void testAdvanceOutOfSurface () {
    	Surface surfaceWhereMowerCantAdvance = mock(Surface.class);
        when(surfaceWhereMowerCantAdvance.isPointInSurface(anyInt(), anyInt())).thenReturn(false);

        // on initialise la tondeuse au point (0,0), orientée vers le nord.
        Mower mower = new Mower(surfaceWhereMowerCantAdvance);
        mower.advance();
        Assert.assertEquals(mower.getX(), 0);
        Assert.assertEquals(mower.getY(), 0);
        Assert.assertSame(mower.getOrientation(), Orientation.N);
    }

}
