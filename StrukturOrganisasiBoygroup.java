import java.util.ArrayList;
import java.util.List;

// Kelas utama
public class StrukturOrganisasiBoygroup {
    public static void main(String[] args) {
        // Membuat objek boygroup dan menambahkan anggota
        Boygroup boygroup = new Boygroup("Treasure");
        boygroup.tambahAnggota(new Member("Hyunsuk", "Leader", 1999, "Korea"));
        boygroup.tambahAnggota(new Member("Jihoon", "Main Dancer", 2000, "Korea"));
        boygroup.tambahAnggota(new Member("Yoshi", "Main Rapper", 2000, "Jepang"));
        boygroup.tambahAnggota(new Member("Junkyu", "Lead Vocalist", 2001, "Korea"));
        boygroup.tambahAnggota(new Member("Mashiho", "Visual", 2001, "Jepang"));
        boygroup.tambahAnggota(new Member("Jaehyuk", "Lead Dancer", 1999, "Korea"));
        boygroup.tambahAnggota(new Member("Asahi", "Lead Vocalist", 2001, "Jepang"));
        boygroup.tambahAnggota(new Member("Yedam", "Main Vocalist", 2002, "Korea"));
        boygroup.tambahAnggota(new Member("Haruto", "Lead Rapper", 2004, "Jepang"));
        boygroup.tambahAnggota(new Member("Doyoung", "Main VOcalist", 2003, "Korea"));
        boygroup.tambahAnggota(new Member("Jeongwoo", "Main Vocalist", 2004, "Korea"));
        boygroup.tambahAnggota(new Member("Junghwan", "Main Dancer", 2005, "Korea"));

        // Menampilkan struktur organisasi boygroup
        boygroup.tampilkanStruktur();
        boygroup.tampilkanJumlahAnggota();
        boygroup.tampilkanInformasiAnggota();
    }
}

// Kelas abstrak untuk mewakili entitas dalam struktur organisasi
abstract class Entitas {
    protected String nama;

    public Entitas(String nama) {
        this.nama = nama;
    }

    public abstract void tampilkanInformasi();
}

// Kelas boygroup yang merupakan turunan dari Entitas
class Boygroup extends Entitas {
    private List<Entitas> anggota;

    public Boygroup(String nama) {
        super(nama);
        anggota = new ArrayList<>();
    }

    public void tambahAnggota(Entitas entitas) {
        anggota.add(entitas);
    }

    public void tampilkanStruktur() {
        System.out.println("=== Struktur Organisasi Boygroup ===");
        tampilkanInformasi();
        for (Entitas entitas : anggota) {
            entitas.tampilkanInformasi();
        }
    }

    public void tampilkanJumlahAnggota() {
        int jumlahAnggota = anggota.size();
        System.out.println("Jumlah anggota: " + jumlahAnggota);
    }

    public void tampilkanInformasiAnggota() {
        System.out.println("=== Informasi Anggota Boygroup ===");
        for (Entitas entitas : anggota) {
            if (entitas instanceof Member) {
                Member member = (Member) entitas;
                member.tampilkanInformasi();
            }
        }
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("Boygroup: " + nama);
    }
}

// Kelas member yang merupakan turunan dari Entitas
class Member extends Entitas {
    private String posisi;
    private int tahunKelahiran;
    private String asal;

    public Member(String nama, String posisi, int tahunKelahiran, String asal) {
        super(nama);
        this.posisi = posisi;
        this.tahunKelahiran = tahunKelahiran;
        this.asal = asal;
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("Member: " + nama);
        System.out.println("Posisi: " + posisi);
        System.out.println("Tahun Kelahiran: " + tahunKelahiran);
        System.out.println("Asal: " + asal);
        System.out.println();
    }
}