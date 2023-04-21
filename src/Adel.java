public class Adel extends Einwohner {
    public Adel(String name, int einkommen) {
        super(name, einkommen);
    }

    @Override
    public int steuer() {
        int abgaben = super.steuer();
        if (abgaben < 20) abgaben = 20;
        return abgaben;
    }
}
