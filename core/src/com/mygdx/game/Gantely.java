package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;

public class Gantely {
    public Gantely(World world, Body bodyA, Body bodyB) {
        /*DistanceJointDef defJoint = new DistanceJointDef ();
        defJoint.length = 5;
        defJoint.initialize(bodyA, bodyB, new Vector2(1, 5), new Vector2(1, 5));*/
        FrictionJointDef defJoint = new FrictionJointDef ();
        defJoint.maxForce = 10.1f;
        defJoint.maxTorque = 10.1f;
        defJoint.initialize(bodyA, bodyB, new Vector2(0,0));


        //DistanceJoint joint = (DistanceJoint) world.createJoint(defJoint); // Returns subclass Joint.
        world.createJoint(defJoint);

    }
}
