package robotsWar;

import java.util.Scanner;

public class Menu {
    public static String getStringFromConsole(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.next();
        }catch (Exception e){
            return "L";
        }
    }

    public static void printRobotHealth(Robot firstRobot, Robot secondRobot){
        System.out.println("Health: ");
        System.out.println(firstRobot.getRobotName() + " - " + firstRobot.getRobotHealth() + ";");
        System.out.println(secondRobot.getRobotName() + " - " + secondRobot.getRobotHealth() + ";");
    }

    public static Robot changeCurrentRobot(Robot currentRobot, Robot firstRobot, Robot secondRobot){
        if (currentRobot == firstRobot){
            currentRobot = secondRobot;
        }else {currentRobot = firstRobot;}
        return currentRobot;
    }

    public static void printWinnersRobotName(Robot currentRobot){
            System.out.println(currentRobot.getRobotName() + " wins!!!");
    }

    public static void makeChangesWithSuccessfulHit(Robot currentRobot, Robot firstRobot, Robot secondRobot, String incomButton){
        System.out.println("You have hit your opponent");
        currentRobot.deleteButtonFromActualActionButtons(incomButton);
        if (currentRobot == firstRobot) {
            secondRobot.reduceRobotHealth();
        } else {
            firstRobot.reduceRobotHealth();
        }
    }

    public static void PrintWelcomeMessage(Robot currentRobot) {
        System.out.println("Shooting " + currentRobot.getRobotName() + ". Press button please: "
                + currentRobot.validButtons);
    }

    public static String checkInputString(String inputString) {
        if (inputString.length() > 1){
            System.out.println("You have press more than one button. Only first symbol will be used");
            inputString = inputString.substring(0,1);
        }
        return inputString;
    }
}
