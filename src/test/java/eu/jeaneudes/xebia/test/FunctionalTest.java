package eu.jeaneudes.xebia.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import eu.jeaneudes.xebia.Mower;
import eu.jeaneudes.xebia.MowerControl;
import eu.jeaneudes.xebia.Orientation;
import eu.jeaneudes.xebia.Rectangle;
import eu.jeaneudes.xebia.Surface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test permettant de valider le scénario proposé.
 */
public class FunctionalTest {

    private Surface surface;

    @Before
    public void init() {
        surface = new Rectangle(5, 5);
    }

    /**
     * validation du scénario de test 1.
     */
    @Test
    public void testMower1() {
        Mower mower = new Mower(1, 2, Orientation.N, surface);
        mower.turnLeft();
        mower.advance();
        mower.turnLeft();
        mower.advance();
        mower.turnLeft();
        mower.advance();
        mower.turnLeft();
        mower.advance();
        mower.advance();
        Assert.assertEquals(mower.getX(), 1);
        Assert.assertEquals(mower.getY(), 3);
        Assert.assertEquals(mower.getOrientation(), Orientation.N);
    }

    /**
     * validation du scénario de test 2.
     */
    @Test
    public void testMower2() {
        Mower mower = new Mower(3, 3, Orientation.E, surface);
        mower.advance();
        mower.advance();
        mower.turnRight();
        mower.advance();
        mower.advance();
        mower.turnRight();
        mower.advance();
        mower.turnRight();
        mower.turnRight();
        mower.advance();
        Assert.assertEquals(mower.getX(), 5);
        Assert.assertEquals(mower.getY(), 1);
        Assert.assertEquals(mower.getOrientation(), Orientation.E);
    }

    /**
     * validation du scénarion complet avec prise en compte du fichier,
     * initialisation de la surface à explorer,
     *
     * @throws IOException
     */
    @Test
    public void testMowerWithFile() throws IOException {

        MowerControl control = new MowerControl();

        InputStream inputStream = getClass().getResourceAsStream("/useCase1.txt");
        Assert.assertNotNull(inputStream);

        InputStreamReader inputStreamReader ;
        BufferedReader bufferedReader = null;

        try {

            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String surfaceLine = bufferedReader.readLine();

            Rectangle rectangle = control.initializeSurface(surfaceLine);
            Assert.assertNotNull(rectangle);

            String initializeMowerLine = bufferedReader.readLine();
            String exploreSurfaceLine = bufferedReader.readLine();
            Mower mower = control.initializeMower(initializeMowerLine, rectangle);
            control.exploreSurface(exploreSurfaceLine, mower);
            Assert.assertEquals(mower.getX(), 1);
            Assert.assertEquals(mower.getY(), 3);
            Assert.assertEquals(mower.getOrientation(), Orientation.N);

            initializeMowerLine = bufferedReader.readLine();
            exploreSurfaceLine = bufferedReader.readLine();
            mower = control.initializeMower(initializeMowerLine, rectangle);
            control.exploreSurface(exploreSurfaceLine, mower);
            Assert.assertEquals(mower.getX(), 5);
            Assert.assertEquals(mower.getY(), 1);
            Assert.assertEquals(mower.getOrientation(), Orientation.E);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }

}
