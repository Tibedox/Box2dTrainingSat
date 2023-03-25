package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Wall {
    Body body;

    Wall(World world, float x, float y, float width, float height) {
        // Create our body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        // Set its world position
        bodyDef.position.set(new Vector2(x, y));

        // Create a body from the definition and add it to the world
        body = world.createBody(bodyDef);

        // Create a polygon shape
        PolygonShape box = new PolygonShape();
        // Set the polygon shape as a box which is twice the size of our view port and 20 high
        // (setAsBox takes half-width and half-height as arguments)
        box.setAsBox(width/2, height/2);
        // Create a fixture from our polygon shape and add it to our ground body
        body.createFixture(box, 0.0f);
        // Clean up after ourselves
        box.dispose();
    }
}
