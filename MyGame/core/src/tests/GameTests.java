package tests;
import static org.junit.Assert.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;

import com.smart.game.GameScreen;
import com.smart.game.MyGame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
public class GameTests {
    GameScreen gameScreen;
    MyGame game;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        final HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        game=new MyGame();
        gameScreen=new GameScreen(game);
        new HeadlessApplication(game, config);
    }

    @Test
    public void test1() {
        assertTrue(true);
    }
}
