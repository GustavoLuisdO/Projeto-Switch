package Services;

import java.util.Scanner;

public class ScanServices
{
    private static Scanner scan;

    public void openScan(){
        scan = new Scanner(System.in);
    }

    public void closeScan(){
        scan.close();
    }

    public static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static Scanner getScan() {
        return scan;
    }
}
