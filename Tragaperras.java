import java.util.Random;

class SlotMachine {
    private static final String[] SYMBOLS = {"C", "L", "P", "7", "M"}; // Emojis en lugar de letras
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static final Random random = new Random();
    private static final int BET_COST = 10;
    
    public String[][] spinSlots() {
        String[][] slots = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                slots[i][j] = SYMBOLS[random.nextInt(SYMBOLS.length)];
            } 
        }
        return slots;
    }
    
    public void printSlots(String[][] slots) {
        System.out.println("+----+----+----+");
        for (String[] row : slots) {
            System.out.print("| ");
            for (String symbol : row) {
                System.out.print(symbol + " | ");
            }
            System.out.println("\n+----+----+----+");
        }
    }
    
    public int checkWin(String[][] slots) {
        for (String[] row : slots) {
            if (row[0].equals(row[1]) && row[1].equals(row[2])) {
                if (row[0].equals("7")) { // Jackpot si son tres sietes
                    int jackpot = random.nextInt(500) + 100; // Jackpot aleatorio entre 100 y 600 fichas
                    System.out.println(" ¡JACKPOT! Ganaste " + jackpot + " fichas! ");
                    return jackpot;
                }
                System.out.println(" ¡Ganaste con " + row[0] + "! +50 fichas! ");
                return 50;
            }
        }
        System.out.println(" No ganaste esta vez. ¡Inténtalo de nuevo!");
        return 0;
    }
    
    public int getBetCost() {
        return BET_COST;
    }
}