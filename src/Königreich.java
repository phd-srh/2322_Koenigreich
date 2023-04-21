import java.util.Objects;
import java.util.Scanner;

public class Königreich {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        while (true) {
            System.out.print("Bitte Namen eigeben: ");
            String name = eingabe.nextLine();
            if ( name.isEmpty() ) break;
            System.out.print("Bitte Einkommen eingeben: ");
            int einkommen = eingabe.nextInt();

            System.out.print("Welche Bevölkerungsgruppe (K, A, B, L): ");
            char bevölkerungsgruppe = eingabe.next().toUpperCase().charAt(0);
            eingabe.nextLine(); // rest der Zeile auffangen

            Einwohner einwohner;
            switch (bevölkerungsgruppe) {
                case 'K':
                    einwohner = new König(name, einkommen);
                    break;
                case 'A':
                    einwohner = new Adel(name, einkommen);
                    break;
                case 'B':
                    einwohner = new Bauer(name, einkommen);
                    break;
                case 'L':
                    einwohner = new Leibeigen(name, einkommen);
                    break;
                default:
                    einwohner = new Einwohner(name, einkommen);
            }

            System.out.println("Der Einwohner " + name + " muss " + einwohner.steuer() +
                    " Taler Steuern zahlen!");
        }
        System.out.println("Vielen Dank und auf Wiedersehen!");
    }
}
