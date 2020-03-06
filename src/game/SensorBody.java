package game;

import city.cs.engine.*;

public class SensorBody extends DynamicBody implements SensorListener {

    private Shape boxShape = new BoxShape(0.2f, 0.2f);

    public SensorBody(World world) {

        super(world); Sensor sensor = new Sensor(this, boxShape);
        Fixture ghostly = new GhostlyFixture(this, boxShape);
        sensor.addSensorListener(this);
        this.setGravityScale(0);

    }


    public void beginContact(SensorEvent sensorEvent) {

        System.out.println("i sense HIM hes HERE!");

    }


    public void endContact(SensorEvent sensorEvent) {

        System.out.println("I NEED TO DESTROY HIM");

    }

}
