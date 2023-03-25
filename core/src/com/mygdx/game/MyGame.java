package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends Game {
	SpriteBatch batch;
	OrthographicCamera camera;
	World world;
	Box2DDebugRenderer debugRenderer;
	Texture img;

	Wall floor;
	Ball ball;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 16, 9);
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		img = new Texture("badlogic.jpg");
		floor = new Wall(world);
		ball = new Ball(world, 8, 8, 0.5f);
		ball = new Ball(world, 8.1f, 10, 0.4f);
	}

	@Override
	public void render () {
		world.step(1/60f, 6, 2);
		ScreenUtils.clear(0, 0, 0, 1);
		debugRenderer.render(world, camera.combined);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//batch.draw(img, 0, 0, 3, 3);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
