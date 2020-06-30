package game;

import java.util.Scanner;

import game.map.Map;

public class JewelCollector {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        Map map = new Map(10, 10);

        map.createDefaultJewels();
        map.createDefaultObstacles();
        map.createDefaultRobot();

        while (running) {
            map.print();

            System.out.print("Enter the comand: ");
            String command = keyboard.nextLine();

            if (command.compareTo("quit") == 0) {
                running = false;
            } else if (command.compareTo("w") == 0) {
                map.moveRobotToNorth();
            } else if (command.compareTo("a") == 0) {
                map.moveRobotToWest();
            } else if (command.compareTo("s") == 0) {
                map.moveRobotToSouth();
            } else if (command.compareTo("d") == 0) {
                map.moveRobotToEast();
            } else if (command.compareTo("u") == 0) {
                map.recharge();
                map.collect();
                
            }
        }

        keyboard.close();
    }
}