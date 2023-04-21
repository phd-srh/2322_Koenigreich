public class Einwohner {
    private String name;
    private int einkommen;

    public Einwohner(String name, int einkommen) {
        this.name = name;
        this.einkommen = einkommen;
    }

    public int zuVersteuern() {
        return einkommen;
    }

    public int steuer() {
        int gesamtesEinkommen = zuVersteuern();
        int abgaben = gesamtesEinkommen * 10 / 100;
        if (abgaben < 1) abgaben = 1;
        return abgaben;
    }
}
