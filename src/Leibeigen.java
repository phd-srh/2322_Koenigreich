public class Leibeigen extends Bauer {
    public Leibeigen(String name, int einkommen) {
        super(name, einkommen);
    }

    public int zuVersteuern() {
        int gesamtesEinkommen = super.zuVersteuern() - 12;
        if (gesamtesEinkommen < 0) gesamtesEinkommen = 0;
        return gesamtesEinkommen;
    }
}
