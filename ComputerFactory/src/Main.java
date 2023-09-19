public class Main {
    public static void main(String[] args) {

        ComputerCase computerCase = new ComputerCase("NZXT H510", "NZXT");
        Motherboard motherboard = new Motherboard("ROG Strix Z490-E Gaming", "ASUS", 4, 3, "UEFI AMI BIOS");
        Monitor monitor = new Monitor("VG248QE", "ASUS", 24, "1920x1080");
        PersonalComputer personalComputer= new PersonalComputer("ROG Strix G15DH", "ASUS", monitor, motherboard, computerCase);



//        personalComputer.getMonitor().drawPixelAt(1920, 1080, "red");
//        personalComputer.getMotherboard().loadProgram("Windows 10");
//        personalComputer.getComputerCase().pressPowerButton();

        personalComputer.powerUp();
    }
}