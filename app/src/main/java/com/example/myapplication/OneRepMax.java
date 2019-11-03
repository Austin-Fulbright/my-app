package com.example.myapplication;
/*
 * OneRepMax calculator
 * not the best since its case by case for
 * reps I couldnt find an algorithm for 1rm calc
 * given weight and reps. Probably something
 * you would know more about.
 */
public class OneRepMax {
    int reps = 1;
    double weight = 1.0;
    double max;
    OneRepMax(int r, double w){
        reps = r;
        weight = w;
    }
    /*
     * calculates one rep max based of precentage
     * of ORM
     */
    double getMax() {
        double xl = (1-getPercent(reps))*weight;
        max = weight+xl;
        return max;
    }
    /*
     * gives you percentage base on how many
     * reps int r.
     */
    private double getPercent(int r) {
        double xl = 0;
        if (r == 1) {
            xl = 1;
        } else if (r == 2) {
            xl = .97;
        } else if (r == 3) {
            xl = .94;
        } else if (r == 4) {
            xl = .92;
        } else if (r == 5) {
            xl = .89;
        } else if (r == 6) {
            xl = .86;
        } else if (r == 7) {
            xl = .83;
        } else if (r == 8) {
            xl = .81;
        } else if (r == 9) {
            xl = .78;
        } else {
            xl = .75;
        }
        return xl;
    }
}
