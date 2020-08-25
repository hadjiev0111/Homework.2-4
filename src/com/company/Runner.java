package com.company;

public class Runner extends Thread {
    private volatile Runner runnerC;
    private volatile Runner runnerD;
    private boolean reverse = false;
    private volatile int i = 4;

    public Runner(String name) {
        super(name);
    }

    public synchronized void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public void setRunnerCD(Runner runnerC, Runner runnerD) {
        this.runnerC = runnerC;
        this.runnerD = runnerD;
    }

    @Override
    public synchronized void run() {
        rice();
    }

    public synchronized void rice() {
        System.out.println(getName() + " Взял палку");
        try {
            sleep(500);
        } catch (InterruptedException ignored) {
        }

        if (!reverse) {
            if (getName().equals("runner5")) {
                reverse = true;
                System.out.println("Бежит к финишу");
                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }

                System.out.println("Бежит к " + runnerD.getName());

                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }
            } else {
                System.out.println(getName() + " побежал к " + runnerC.getName());
                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }
                runnerC.start();
                try {
                    runnerC.join();
                } catch (InterruptedException ignored) {
                }
            }
        }
        if (getName().equals("runner5"))
            return;

        System.out.println(getName() + " взял палку");
        try {
            sleep(5000);
        } catch (InterruptedException ignored) {
        }
        if (!(getName().equals("runner1")))
            System.out.println(getName() + " побежал передавать палку " + runnerD.getName());
        else
            System.out.println("забег окончен");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
