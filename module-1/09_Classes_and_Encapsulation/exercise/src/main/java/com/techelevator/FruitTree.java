package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;



    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {

        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit - piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    @Override
    public String toString() {
        return "FruitTree{" +
                "typeOfFruit='" + typeOfFruit + '\'' +
                ", piecesOfFruitLeft=" + piecesOfFruitLeft +
                '}';
    }

    boolean pickFruit(int numberOfPiecesToRemove, String typeOfFruit) {

        if(piecesOfFruitLeft>=numberOfPiecesToRemove)
        {
            return true;
        }
        return false;
    }
}
