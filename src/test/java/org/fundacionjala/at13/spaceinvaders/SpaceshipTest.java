package org.fundacionjala.at13.spaceinvaders;

import static org.junit.Assert.*;

import java.lang.annotation.Target;

import org.junit.Test;

public class SpaceshipTest{

    @Test
    public void itShouldShootABullet(){
        int lowerXLimit = 0;
        int upperXLimit = 10;
        int positionInitialX = 5;
        int positionInitialY = 6;
        Spaceship spaceship = new Spaceship(positionInitialX,positionInitialY,lowerXLimit,upperXLimit);
        Bullet bulletShootBySpaceship = spaceship.shoot();
        Bullet bullet=new Bullet(spaceship);
        assertTrue(bullet.getPositionX() == bulletShootBySpaceship.getPositionX());
        assertTrue(bullet.getPositionY() == bulletShootBySpaceship.getPositionY());
        assertTrue(bullet.getBulletExist() == bulletShootBySpaceship.getBulletExist());
    }

    @Test
    public void itShouldIncreaseScore(){
        int lowerXLimit = 0;
        int upperXLimit = 50;
        int positionInitialX = 32;
        int positionInitialY = 7;
        Spaceship spaceship = new Spaceship(positionInitialX,positionInitialY,lowerXLimit,upperXLimit);
        int scoreValue = spaceship.VALUE;
        int actualValue = spaceship.getScore();
        spaceship.increaseScore();
        int posteriorValue = spaceship.getScore();
        assertEquals(actualValue + scoreValue, posteriorValue);
    }
    @Test
    public void itShouldReturnNumbersLife() {
        int lowerXLimit=0;
        int upperXLimit=42;
        int positionInitSpaceshipX = 4;
        int positionInitSpaceshipY = 0;
        Spaceship spaceship = new Spaceship(positionInitSpaceshipX, positionInitSpaceshipY,lowerXLimit,upperXLimit);
        assertEquals(3,spaceship.getNumbersLife());
    }
}