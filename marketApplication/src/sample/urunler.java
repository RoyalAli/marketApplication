package sample;

public class urunler {
    private int urunID;
    private String urunAdi;
    private String urunTuru;
    private double alimFiyati;
    private double satisFiyati;

    private void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    private void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    private void setUrunTuru(String urunTuru) {
        this.urunTuru = urunTuru;
    }

    private void setAlimFiyati(double alimFiyati) {
        this.alimFiyati = alimFiyati;
    }

    private void setSatisFiyati(double satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public urunler(int urunID, String urunAdi, String urunTuru, double alimFiyati, double satisFiyati) {
        setUrunID(urunID);
        setUrunAdi(urunAdi);
        setUrunTuru(urunTuru);
        setAlimFiyati(alimFiyati);
        setSatisFiyati(satisFiyati);
    }

    public int getUrunID() {
        return urunID;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public String getUrunTuru() {
        return urunTuru;
    }

    public double getAlimFiyati() {
        return alimFiyati;
    }

    public double getSatisFiyati() {
        return satisFiyati;
    }
}