package com.company;

public class Main {

    public static void main(String[] args) {
	Runner runner5 = new Runner("runner5");
	Runner runner4 = new Runner("runner4");
	Runner runner3 = new Runner("runner3");
	Runner runner2 = new Runner("runner2");
	Runner runner1 = new Runner("runner1");

	runner5.setRunnerCD(runner1,runner4);
	runner4.setRunnerCD(runner5,runner3);
	runner3.setRunnerCD(runner4,runner2);
	runner2.setRunnerCD(runner3,runner1);
	runner1.setRunnerCD(runner2,runner5);

	runner1.start();
    }
}
