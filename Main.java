
public class Main {
    public static void main(String[] args) throws Exception {
        SlotMachine slotMachine = new SlotMachine();
        int fichas = 100;
        
        System.out.println(" Bienvenido a la Máquina Tragaperras ");
        
        while (fichas >= slotMachine.getBetCost()) {
            System.out.println("Tienes " + fichas + " fichas.");
            System.out.println("Presiona ENTER para girar o 'q' para salir.");
            
            int key = System.in.read();
            if (key == 'q' || key == 'Q') {
                System.out.println("Gracias por jugar. Te vas con " + fichas + " fichas. ¡Vuelve pronto!");
                break;
            }
            while (System.in.available() > 0) { // Limpia el buffer de entrada
                System.in.read();
            }  
            
            fichas -= slotMachine.getBetCost();
            System.out.println("\n Tirando... \n");
            String[][] slots = slotMachine.spinSlots();
            slotMachine.printSlots(slots);
            fichas += slotMachine.checkWin(slots);
            System.out.println();
        }
        
        if (fichas < slotMachine.getBetCost()) {
            System.out.println("Te has quedado sin fichas. ¡Más suerte la próxima vez!");
        }
    }
}