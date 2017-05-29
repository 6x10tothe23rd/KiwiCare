package org.conner4real.kiwicare;

public class ExerciseRatings {
    private double m_strength;
    private double m_cardio;
    private double m_endurance;

    public ExerciseRatings(double strength, double cardio, double endurance){
        this.m_strength = strength;
        this.m_cardio = cardio;
        this.m_endurance = endurance;
    }

    public double get_strength() {
        return m_strength;
    }

    public double get_cardio() {
        return m_cardio;
    }

    public double get_endurance() { return m_endurance; }
}
