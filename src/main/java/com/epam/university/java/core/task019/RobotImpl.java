package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

     private RobotPosition robotPosition = new RobotPositionImpl(0, 0);
     private int moveDirection = 1;


    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        robotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case TURN_RIGHT: {
                moveDirection = ++moveDirection;
                break;
            }
            case TURN_LEFT: {
                moveDirection = --moveDirection;
                break;
            }
            case MOVE_FORWARD: {
                RobotPosition newPosition = getRobotPositionAndDirection(getPosition());
                setPosition(newPosition);
                break;
            }
            default: break;
        }
    }

    public RobotPosition getRobotPositionAndDirection(RobotPosition position) {
        int positionX = position.getX();
        int positionY = position.getY();

        switch (moveDirection) {
            case 1: {
                positionY++;
                break;
            }
            case 2: {
                positionX++;
                break;
            }
            case 3: {
                positionY--;
                break;
            }
            case 4: {
                positionX--;
                break;
            }
            default: break;
        }

        return new RobotPositionImpl(positionX, positionY);
    }
}
