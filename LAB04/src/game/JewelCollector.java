package game;

import java.util.Scanner;

import game.infrastructure.Map;

public class JewelCollector {
	
	int quantidadeJewels;
	
	public static void main(String[] args) {				
		
		Map map = new Map(10, 10);
		
		map.insertJewels();
		map.insertObstacles();
		map.createRobot();
		
		
		
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			map.printMap();
			String command = keyboard.nextLine();
			
			if (command.compareTo("quit") == 0) {
				running = false;
			} else if (command.compareTo("d") == 0) {
				map.moveRobotToEast();
			} else if (command.compareTo("s") == 0) {
				map.moveRobotToSouth();
			} else if (command.compareTo("a") == 0) {
				map.moveRobotToWest();
			} else if (command.compareTo("w") == 0) {
				map.moveRobotToNorth();
			} else if (command.compareTo("g") == 0) {
				map.collectJewel();
			}
		}
		
		
		keyboard.close();
		
	}
}
