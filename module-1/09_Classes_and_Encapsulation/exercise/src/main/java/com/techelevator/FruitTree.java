package com.techelevator;


public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;



    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {

        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }


    public boolean pickFruit(int numberOfPiecesToRemove) {

        if(this.piecesOfFruitLeft>=numberOfPiecesToRemove)
        {this.piecesOfFruitLeft-=numberOfPiecesToRemove;
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return "FruitTree{" +
                "typeOfFruit='" + typeOfFruit + '\'' +
                ", piecesOfFruitLeft=" + piecesOfFruitLeft +
                '}';
    }
}
