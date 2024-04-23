package eu.jeaneudes.xebia.test;

import eu.jeaneudes.xebia.Rectangle;
import org.junit.Assert;
import org.junit.Test;


public class RectangleTest {

    @Test
    public void testPointInRectangle() {
        Rectangle rectangle = new Rectangle(3, 3);
        Assert.assertTrue(rectangle.isPointInSurface(1,1));
    }

    @Test
    public void testPointOutOfRectangle() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assert.assertFalse(rectangle.isPointInSurface(6, 6));
        Assert.assertFalse(rectangle.isPointInSurface(6,4));
        Assert.assertFalse(rectangle.isPointInSurface(4,6));
        Assert.assertFalse(rectangle.isPointInSurface(-1,-1));
        Assert.assertFalse(rectangle.isPointInSurface(-1,1));
        Assert.assertFalse(rectangle.isPointInSurface(1,-1));

    }

    @Test
    public void testPointInBorderOfRectangle() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assert.assertTrue(rectangle.isPointInSurface(0, 0));
        Assert.assertTrue(rectangle.isPointInSurface(0,5));
        Assert.assertTrue(rectangle.isPointInSurface(5,5));
        Assert.assertTrue(rectangle.isPointInSurface(2,5));
    }

}
