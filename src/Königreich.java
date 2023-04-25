import java.util.Scanner;

public class Königreich {

    private static boolean enthältUngültigeSonderzeichen(String name) {
        for (int i=0; i < name.length(); i++) {
            char zeichen = name.charAt(i);
            if ("0123456789-+/*!§$%&()[]{}^°~#€@<>|'\"\\".indexOf(zeichen) >= 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        while (true) {
            String name;
            do {
                System.out.print("Bitte Namen (ohne Sonderzeichen) eingeben: ");
                name = eingabe.nextLine();
            } while ( enthältUngültigeSonderzeichen(name) );

            if ( name.isEmpty() ) break;

            int einkommen;
            do {
                System.out.print("Bitte Einkommen (>0) eingeben: ");
                einkommen = eingabe.nextInt();
            } while ( einkommen < 0 );

            char bevölkerungsgruppe;
            do {
                System.out.print("Welche Bevölkerungsgruppe (K, A, B, L): ");
                bevölkerungsgruppe = eingabe.next().toUpperCase().charAt(0);
                eingabe.nextLine(); // rest der Zeile auffangen
            } while ("KABL".indexOf(bevölkerungsgruppe) < 0);

            Einwohner einwohner = null;
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
                    System.out.println("Ungültige Eingabe");
            }

            System.out.println("Der Einwohner " + name + " muss " +
                    einwohner.steuer() + " Taler Steuern zahlen!");
        }
        System.out.println("Vielen Dank und auf Wiedersehen!");
    }
}
