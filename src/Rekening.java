
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Rekening {

    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public String getKeterangan() {
        return "Rekening";
    }

    protected static String formatRupiah(int jumlah) {
        DecimalFormatSymbols simbol =
                new DecimalFormatSymbols();

        simbol.setGroupingSeparator('.');
        simbol.setDecimalSeparator(',');

        DecimalFormat format =
                new DecimalFormat("#,##0", simbol);

        return "Rp" + format.format(jumlah);
    }
}
