package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;

public class Gantely {
    public Gantely(World world, Body b0, Body b1) {
        DistanceJointDef defJoint = new DistanceJointDef ();
        defJoint.length = 5;
        defJoint.initialize(b0, b1, new Vector2(1, 5), new Vector2(1, 5));

        DistanceJoint joint = (DistanceJoint) world.createJoint(defJoint); // Returns subclass Joint.
    }
}
