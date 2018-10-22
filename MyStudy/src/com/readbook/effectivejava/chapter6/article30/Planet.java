package com.readbook.effectivejava.chapter6.article30;

/**
 * @ClassName: Planet.java
 * @Description: Enum type with data and behavior 太阳系中的8颗行星，质量和半径
 * @author: gxc
 * @date: 2018年10月12日上午10:32:30
 */
public enum Planet {
	MERCURY(3.302e+23, 2.439e6);
	private final double mass;
	private final double radius;
	private final double surfaceGrvaity;
	private static final double G = 6.67300E-11;

	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGrvaity = G * mass / (radius * radius);
	}

	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public double surfaceGrvaity() {
		return surfaceGrvaity;
	}

	public double surfaceWeight(double mass) {
		return mass * surfaceGrvaity;
	}
}
