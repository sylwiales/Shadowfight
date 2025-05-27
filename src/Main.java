public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while(true) {
            Utility.displayHeader("MENU");
            System.out.println("1. Zbierz drużynę");
            System.out.println("2. Idź na polowanie");
            System.out.println("3. Zakończ grę");

            int option = Utility.getValidInput(3);
            Utility.clearScreen();

            switch(option) {
                case 1:
                    game.gatherTeam();
                    break;
                case 2:
                    game.startHunt();
                    break;
                case 3:
                    return;
            }
        }
    }
}