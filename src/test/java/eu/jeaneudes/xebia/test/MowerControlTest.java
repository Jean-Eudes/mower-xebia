package eu.jeaneudes.xebia.test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.jeaneudes.xebia.Mower;
import eu.jeaneudes.xebia.MowerControl;
import eu.jeaneudes.xebia.Orientation;
import eu.jeaneudes.xebia.Rectangle;
import eu.jeaneudes.xebia.Surface;

public class MowerControlTest {

	private MowerControl mowerControl;

	private Surface surface;

	@Before
	public void init() {
		mowerControl = new MowerControl();
		surface = mock(Surface.class);
		when(surface.isPointInSurface(anyInt(), anyInt())).thenReturn(true);
	}

	@Test
	public void testInitializeSurface() {
		Rectangle rectangle = mowerControl.initializeSurface("4 5");
		Assert.assertNotNull(rectangle);
		Assert.assertEquals(rectangle.getWidth(), 4);
		Assert.assertEquals(rectangle.getHeight(), 5);
	}

	@Test(expected = RuntimeException.class)
	public void testInitializeSurfaceWithBadNumberOfParameters() {
		mowerControl.initializeSurface("4 5 2");
	}

	@Test(expected = NumberFormatException.class)
	public void testInitializeSurfaceWithString() {
		mowerControl.initializeSurface("2 dftr");
	}

	@Test
	public void testInitializeMower() {
		Mower mower = mowerControl.initializeMower("1 2 S", surface);
		Assert.assertNotNull(mower);
		Assert.assertEquals(mower.getX(), 1);
		Assert.assertEquals(mower.getY(), 2);
		Assert.assertEquals(mower.getOrientation(), Orientation.S);
	}

	@Test(expected = RuntimeException.class)
	public void testInitializeMowerWithBadNumberOfParameters() {
		mowerControl.initializeMower("4 5", surface);
	}

	@Test(expected = NumberFormatException.class)
	public void testInitializeMowerWithString() {
		mowerControl.initializeMower("2 dftr O", surface);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInitializeMowerWithBadOrientation() {
		mowerControl.initializeMower("2 3 A", surface);
	}

	@Test
	public void testExploreSurface() {
		Mower mower = mock(Mower.class);
		mowerControl.exploreSurface("GAGADAA", mower);
		verify(mower, times(2)).turnLeft();
		verify(mower, times(4)).advance();
		verify(mower, times(1)).turnRight();
	}
}
