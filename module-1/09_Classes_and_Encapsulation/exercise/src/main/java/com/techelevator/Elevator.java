package com.techelevator;

public class Elevator {

    private int currentFloor;//	int	X		The current floor that the elevator is on.
    private int numberOfFloors;//	int	X		The number of floors available to the elevator.
    private boolean doorOpen;//


    public Elevator(int numberOfLevels) {

        this.numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        currentFloor = 1;
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {
        doorOpen=true;
    }

   public void closeDoor() {
        doorOpen=false;
    }

   public void goUp(int desiredFloor) {

        if(!doorOpen && desiredFloor<numberOfFloors) {
                currentFloor=desiredFloor;
        }
    }

   public void goDown(int desiredFloor) {
        if(!doorOpen && desiredFloor>1) {
                currentFloor=desiredFloor;
        }

    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", numberOfFloors=" + numberOfFloors +
                ", doorOpen=" + doorOpen +
                '}';
    }
} // end of class
