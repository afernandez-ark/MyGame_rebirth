package com.smart.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayScreen implements Screen {
    private MyGame game;
    private Texture background;
    private BitmapFont font;
    private Skin skin;
    private FreeTypeFontGenerator generator;
    private Stage stage;

    public PlayScreen(final MyGame game) {
        this.game = game;

        background = new Texture("play-back.jpg");
        skin = new Skin(Gdx.files.internal("skins/newskin.json"));

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 40;
        font = generator.generateFont(parameter);

        stage = new Stage();

        Table table = new Table();
        for (int i = 1; i <= 5; i++) {
            final TextButton button = new TextButton("Level " + i, skin);
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    dispose();
                    game.setScreen(new GameScreen(game));
                }
            });

            table.add(button);
            if (i % 5 == 0) {
                table.row();
            }
        }
        table.setBounds(350, 200, 600, 400);
        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //draw background
        game.batch.begin();
        game.batch.draw(background, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        font.draw(game.batch, "Select a Level",
                (int) (Constants.GAME_WIDTH / 2) - 80, Constants.GAME_HEIGHT);

        stage.draw();
        stage.act();

        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        generator.dispose();
        font.dispose();
        background.dispose();
    }
}
