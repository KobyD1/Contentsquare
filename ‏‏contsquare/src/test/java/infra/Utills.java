package infra;

import java.util.Random;

public class Utills {

    public Integer getRandomInteger(Integer min, Integer max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;

    }
}
