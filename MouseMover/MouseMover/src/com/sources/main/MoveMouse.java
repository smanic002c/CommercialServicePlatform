package com.sources.main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Date;

import com.sources.constants.Constants;

public class MoveMouse {
	public static void main(String[] args) throws Exception {
		final String methodName = "main";
		System.out.println("START: " + methodName );
		Date st = new Date();
		Date et = null;
		System.out.println("statTime: " + st );
		long time = Constants.SECONDS * 1000;
		int programmedY = 400;
		int programmedX = 300;
		int count = 0;
		
		findCurrentPosition();
		
		while (true) {
			Robot robot = new Robot();
			robot.mouseMove(programmedX, programmedY);
			Thread.sleep(time);
			Point point = findCurrentPosition();
			if (point.x == programmedX && point.y == programmedY) {
				if (programmedY >= 490) {
					et = new Date();
					System.out.println("Reset happens at: " + et);
					count = 0;
					programmedY = 400;
					programmedX = 300;
					System.out.println("Total Time in minutes: " + ((et.getTime() - st.getTime()) / 1000) / 60);
				} else {
					count++;
					et = new Date();
					System.out.println("general increment(" + count + ") at: " + et);
					programmedY = programmedY + 15;
					programmedX = programmedX + 15;
				}
			} else {
				System.out.println("location manually modified. Thus quitting");
				System.exit(0);
			}
		}
	}

	private static Point findCurrentPosition() {
		Point  point = MouseInfo.getPointerInfo().getLocation();
		int currentX = point.x;
		int currentY = point.y;
		System.out.println("Current X is: " + currentX + " and Y is: " + currentY );
		return point;
	}
}