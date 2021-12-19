package robotsWar;

public class War {
    public static void main(String[] args) {
        final String EXIT_BUTTON = "L";
        String currentButton;
        String tempSecondRobotName;
        String inputString;

        System.out.println("Insert first robot name:");
        Robot firstRobot = new Robot(Menu.getStringFromConsole());

        do {
            System.out.println("Second robot name should not be equals first robot name." +
                    " \nInsert unique second robot name:");
           tempSecondRobotName = Menu.getStringFromConsole();
        } while (firstRobot.getRobotName().equalsIgnoreCase(tempSecondRobotName));

        Robot secondRobot = new Robot(tempSecondRobotName);

        Robot currentRobot = firstRobot;
        do {
            Menu.PrintWelcomeMessage(currentRobot);

            inputString = Menu.getStringFromConsole().toUpperCase();
            currentButton = Menu.checkInputString(inputString);

            if (currentRobot.isInvalidButton(currentButton)
                    && !(currentButton.equals(EXIT_BUTTON))){
                System.out.println("It is incorrect symbol. Please retry.");
            }
            else if (currentButton.equals(EXIT_BUTTON)) {
                System.out.println("Bye!!!");
            }
            else {
                if (currentRobot.isActionButton(currentButton)){
                    if (currentRobot.isActualActionButton(currentButton)){
                        Menu.makeChangesWithSuccessfulHit(currentRobot, firstRobot, secondRobot, currentButton);

                        if(firstRobot.getRobotHealth() <= 0 || secondRobot.getRobotHealth() <= 0){
                            Menu.printWinnersRobotName(currentRobot);
                            currentButton = EXIT_BUTTON;
                            continue;
                        }
                    }
                }
                Menu.printRobotHealth(firstRobot, secondRobot);
                currentRobot = Menu.changeCurrentRobot(currentRobot,firstRobot,secondRobot);
            }

        }while(!(currentButton.equals(EXIT_BUTTON)));
    }
}
