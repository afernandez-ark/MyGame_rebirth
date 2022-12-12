package com.smart.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.smart.game.models.Player;

public class GameScreen implements Screen {
    final MyGame game;
    Texture img;
    ProgressBar healthBar;
    float healBarWidth = 200;
    float healBarHeight = 20;

    BitmapFont font;

    Player player;

    Skin healthSkin, skin;
    Stage stage;
    Texture mana, defense, attack, speed;

    public GameScreen(final MyGame game) {
        this.game = game;
        this.img = new Texture("gameback.png");
        speed = new Texture("stats/speed.png");
        defense = new Texture("stats/defense.png");
        attack = new Texture("stats/attack.png");
        mana = new Texture("stats/mana.png");

        player = new Player(100, 50, 1, 10, 5);

        font = new BitmapFont();

        stage = new Stage();

        healthSkin = new Skin(Gdx.files.internal("skins/skin.json"));
        skin = new Skin(Gdx.files.internal("skins/newskin.json"));

        healthBar = new ProgressBar(0.0f, 100.0f, 1f, false, healthSkin);
        healthBar.setValue(player.getHealth());
        healthBar.getStyle().knobBefore.setLeftWidth(100);
        healthBar.setAnimateDuration(0.25f);
        healthBar.setBounds(Constants.GAME_WIDTH - healBarWidth - 50, Constants.GAME_HEIGHT - healBarHeight - 20, healBarWidth, healBarHeight);
        stage.addActor(healthBar);

        TextButton backBtn = new TextButton("Back", skin);
        backBtn.setBounds(Constants.GAME_WIDTH - 50, healthBar.getY() - 100, 50, 50);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        });
        stage.addActor(backBtn);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Screen#render(float)
     */
    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //draw background
        game.batch.begin();
        game.batch.draw(img, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        game.batch.end();

        //draw health bar
        stage.draw();
        stage.act();

        game.batch.begin();
        font.draw(game.batch, player.getHealth() + "/" + player.getMaxHealth(),
                healthBar.getX() + 30, healthBar.getY() - 5);
        game.batch.draw(new Texture(Gdx.files.internal("stats/health.png")),
                healthBar.getX() - 50, healthBar.getY() - 30, 70, 70);

        game.batch.draw(speed, 5, Constants.GAME_HEIGHT - 60, 40, 50);
        font.draw(game.batch, player.getSpeed() + "", 50, Constants.GAME_HEIGHT - 60 + 25);
        game.batch.draw(attack, 5, Constants.GAME_HEIGHT - 130, 35, 50);
        font.draw(game.batch, player.getMagicAttack() + "", 50, Constants.GAME_HEIGHT - 130 + 25);
        game.batch.draw(defense, 5, Constants.GAME_HEIGHT - 190, 40, 50);
        font.draw(game.batch, player.getDefense() + "", 50, Constants.GAME_HEIGHT - 190 + 25);
        game.batch.draw(mana, 5, Constants.GAME_HEIGHT - 250, 40, 50);
        font.draw(game.batch, player.getMaxMana() + "", 50, Constants.GAME_HEIGHT - 250 + 25);
        game.batch.end();


    }


    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        stage.dispose();
    }

}
