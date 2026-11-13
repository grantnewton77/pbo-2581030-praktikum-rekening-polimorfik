
public class Tabungan extends Rekening implements BerBunga {

    private double persentaseBunga;

    public Tabungan(String nomor, String pemilik,
                    int saldo, double persentaseBunga) {

        super(nomor, pemilik, saldo);
        this.persentaseBunga = persentaseBunga;
    }

    @Override
    public int biayaAdminBulanan() {
        if (saldo >= 1000000) {
            return 0;
        }

        return 5000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(
                saldo * persentaseBunga / 100
        );

        saldo += bunga;

        return bunga;
    }

    @Override
    public String getKeterangan() {
        return "Tabungan, bunga "
                + persentaseBunga
                + "% per bulan";
    }
}

