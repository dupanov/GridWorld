/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */
import java.awt.Color;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;


/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new UnboundedGrid());
        Bug redBug = new Bug();
        world.add(redBug);
        redBug.canMove();
        world.show();

        System.out.println(redBug.getLocation());
        world.add(new Bug());
        world.add(new Rock());

        for(int i=0; i<1000; i++) {
            moveBug(redBug, 10);
            randomBug(redBug, 10);
        }
    }

    public static void moveBug(Bug bug, int nTimes){
        for(int i=0; i<=nTimes; i++) {
            if (bug.canMove()) {
                bug.move();
            } else {
                bug.turn();
            }
        }
    }

    public static void randomBug(Bug bug, int mTimes){
     for(int i=0; i<=mTimes; i++){
        int degree = 0;
       double rand = 4*Math.random();
           switch ((int)rand){
               case 0:
                   degree = 0;
                   break;
               case 1:
                   degree =  90;
                   break;
               case 2:
                   degree =  180;
                   break;
               case 3:
                   degree =  270;
                   break;
               default: break;
           }
       bug.setDirection(degree);
    }
    }


}