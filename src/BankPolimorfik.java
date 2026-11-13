
public class BankPolimorfik {

    public static void main(String[] args) {

        // Membuat tiga objek rekening
        Tabungan ani = new Tabungan(
                "101", "Ani", 1000000, 2.5
        );

        Tabungan citra = new Tabungan(
                "102", "Citra", 300000, 2.0
        );

        Giro budi = new Giro(
                "201", "Budi", 200000, 500000
        );

        // Array semua jenis rekening
        Rekening[] semua = {
                ani, citra, budi
        };

        // Array khusus rekening berbunga
        BerBunga[] berbunga = {
                ani, citra
        };

        // Menampilkan rekening awal
        System.out.println("========== REKENING AWAL ==========");

        for (Rekening r : semua) {

            System.out.printf(
                    "%-4s | %-8s | %s%n",
                    r.getNomor(),
                    r.getPemilik(),
                    Rekening.formatRupiah(r.getSaldo())
            );

            System.out.println("     " + r.getKeterangan());
        }

        // Memproses biaya admin semua rekening
        System.out.println("\n========== AKHIR BULAN ==========");

        for (Rekening r : semua) {

            int biaya = r.potongBiayaAdmin();

            System.out.println(
                    r.getNomor() + " biaya admin : "
                            + Rekening.formatRupiah(biaya)
            );
        }

        // Memproses bunga rekening yang berbunga
        for (BerBunga b : berbunga) {

            int bunga = b.tambahBunga();

            System.out.println(
                    b.getNomor() + " bunga       : "
                            + Rekening.formatRupiah(bunga)
            );
        }

        // Menampilkan rekening akhir
        System.out.println("\n========== REKENING AKHIR ==========");

        int totalDana = 0;

        for (Rekening r : semua) {

            System.out.printf(
                    "%-4s | %-8s | %s%n",
                    r.getNomor(),
                    r.getPemilik(),
                    Rekening.formatRupiah(r.getSaldo())
            );

            System.out.println("     " + r.getKeterangan());

            totalDana += r.getSaldo();
        }

        System.out.println("------------------------------------");

        System.out.println(
                "Total dana bank : "
                        + Rekening.formatRupiah(totalDana)
        );

        // Pengujian abstract class
        // Rekening r = new Rekening("999", "Eko", 0);
    }
}

