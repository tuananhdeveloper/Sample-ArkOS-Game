package com.tuananh.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Sprite sprite;
    private Music music;
    private Color clearColor;

    @Override
    public void create() {
        clearColor = Color.BLUE;
        batch = new SpriteBatch();
        image = new Texture("gdx-sdl2.png");
        sprite = new Sprite(image);
        sprite.setSize(400, 400);
        float x = (Gdx.app.getGraphics().getWidth() - sprite.getWidth()) /2;
        float y = (Gdx.app.getGraphics().getHeight() - sprite.getHeight()) /2;
        sprite.setPosition(x, y);

        music = Gdx.audio.newMusic(Gdx.files.internal("audio.mp3"));

        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Keys.ENTER:
                        if (music.isPlaying()) {
                            music.pause();
                        }
                        else {
                            music.play();
                        }
                        break;
                    case Keys.BUTTON_X:
                        clearColor = Color.BLUE;
                        break;
                    case Keys.BUTTON_Y:
                        clearColor = Color.GREEN;
                        break;
                    case Keys.BUTTON_B:
                        clearColor = Color.YELLOW;
                        break;
                    case Keys.DPAD_UP:
                        Gdx.app.log(Main.class.getName(), "DPAD_UP");
                        break;
                    case Keys.DPAD_DOWN:
                        Gdx.app.log(Main.class.getName(), "DPAD_DOWN");
                        break;
                    case Keys.DPAD_LEFT:
                        Gdx.app.log(Main.class.getName(), "DPAD_LEFT");
                        break;
                    case Keys.DPAD_RIGHT:
                        Gdx.app.log(Main.class.getName(), "DPAD_RIGHT");
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void render() {
        ScreenUtils.clear(clearColor);
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        music.dispose();
    }
}
