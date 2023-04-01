package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGame extends Game {
	public static final float WIDTH = 16, HEIGHT = 9;
	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	World world;
	Box2DDebugRenderer debugRenderer;
	Texture img;

	StaticBodyBox[] block = new StaticBodyBox[3];
	ArrayList<DynamicBodyBall> ball = new ArrayList<>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		touch = new Vector3();
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		img = new Texture("badlogic.jpg");
		block[0] = new StaticBodyBox(world, WIDTH/2, 1, WIDTH, 0.5f);
		block[1] = new StaticBodyBox(world, 1, HEIGHT/2, 0.5f, HEIGHT);
		block[2] = new StaticBodyBox(world, WIDTH-1, HEIGHT/2, 0.5f, HEIGHT);
		for(int i=0; i<10; i++)
			ball.add(new DynamicBodyBall(world, 8+ MathUtils.random(-0.1f, 0.1f), 10+i, 0.3f));

	}

	@Override
	public void render () {
		if(Gdx.input.justTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			System.out.println(""+touch.x+" "+ touch.y);
			for (int i = 0; i < ball.size(); i++) {
				if(ball.get(i).hit(touch.x, touch.y)){
					ball.get(i).body.applyLinearImpulse(0, 1f, ball.get(i).getX(), ball.get(i).getY(), true);
					System.out.println("попали"+touch.x+" "+ touch.y);
				}
			}
		}
		world.step(1/60f, 6, 2);
		ScreenUtils.clear(0, 0, 0, 1);
		debugRenderer.render(world, camera.combined);
		/*camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i=0; i<100; i++)
			batch.draw(img, ball.get(i).body.getPosition().x-0.3f,
					ball.get(i).body.getPosition().y-0.3f, 0.3f*2, 0.3f*2);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
