package com.smart.game.models;

public class Player {
    private float maxHealth;
    private float maxMana;
    private float speed;
    private int defense;
    private int magicAttack;
    private float health;

    public Player(float maxHealth, float maxMana, float speed, int defense, int magicAttack) {
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.health = 90;
        this.speed = speed;
        this.defense = defense;
        this.magicAttack = magicAttack;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public float getMaxMana() {
        return maxMana;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public float getHealth() {
        return health;
    }
}
