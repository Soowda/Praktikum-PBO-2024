import java.util.ArrayList;
import java.util.Scanner;

// Interface Weaponizable
interface Weaponizable {
    void attack();

    static void showWeaponType() {
        System.out.println("Entitas ini dapat digunakan sebagai senjata.");
    }
}

// Abstract class Entitas - Superclass
abstract class Entitas {
    protected final String nama; // Keyword final untuk variabel

    public Entitas(String nama) {
        this.nama = nama;
    }

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void suara();
}

// Kelas Tanaman - Subclass
final class Tanaman extends Entitas { // Keyword final untuk class
    private int kekuatan;
    private String habitat;

    public Tanaman(String nama, String habitat, int kekuatan) {
        super(nama);
        this.habitat = habitat;
        this.kekuatan = kekuatan;
    }

    // Metode Getter dan Setter
    public int getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Tanaman " + getNama() + " mengeluarkan suara: ~~~ Ssshhh... Ssshhh... ~~~");
    }

    // Implementasi abstract method
    @Override
    public void setNama(String nama) {
        // Tidak perlu mengubah nilai variabel nama karena sudah final
    }

    @Override
    public String getNama() {
        return nama;
    }

    public static final void attackSound(String namaEntitas) { // Keyword final untuk method
        System.out.println("!!!AWAS, TANAMAN " + namaEntitas + " MENYERANG!!!");
    }

    // Method attack ditambahkan di sini
    public void attack() {
        System.out.println("Tanaman menyerang zombie!"); // Implementasi logika serangan tanaman
    }
}

// Kelas Zombie - Subclass
final class Zombie extends Entitas implements Weaponizable { // Keyword final untuk class
    private int kekuatan;

    public Zombie(String nama, int kekuatan) {
        super(nama);
        this.kekuatan = kekuatan;
    }

    // Metode Getter dan Setter
    public int getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Zombie " + getNama() + " mengeluarkan suara: ~~~ Arrrggghh... Arrrggghh... ~~~");
    }

    // Implementasi abstract method
    @Override
    public void setNama(String nama) {
        // Tidak perlu mengubah nilai variabel nama karena sudah final
    }

    @Override
    public String getNama() {
        return nama;
    }

    public static final void attackSound(String namaEntitas) { // Keyword final untuk method
        System.out.println("!!!AWAS, ZOMBIE " + namaEntitas + " MENYERANG!!!");
    }

    // Implementasi method dari interface Weaponizable
    @Override
    public void attack() {
        System.out.println("Zombie " + getNama() + " is attacking!");
    }
}

// Kelas Senjata - Subclass
final class Senjata extends Entitas implements Weaponizable { // Keyword final untuk class
    private int kekuatan;

    public Senjata(String nama, int kekuatan) {
        super(nama);
        this.kekuatan = kekuatan;
    }

    // Metode Getter dan Setter
    public int getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Senjata " + getNama() + " mengeluarkan suara: ~~~ Pew! Pew! Pew! ~~~");
    }

    // Implementasi abstract method
    @Override
    public void setNama(String nama) {
        // Tidak perlu mengubah nilai variabel nama karena sudah final
    }

    @Override
    public String getNama() {
        return nama;
    }

    public static final void attackSound(String namaEntitas) { // Keyword final untuk method
        System.out.println("!!!AWAS, SENJATA " + namaEntitas + " DIGUNAKAN!!!");
    }

    // Implementasi method dari interface Weaponizable
    @Override
    public void attack() {
        System.out.println("Menggunakan " + getNama() + " Untuk Menyerang!");
    }
}

// Kelas Utama
public final class App { // Keyword final untuk class
    public static void main(String[] args) {
        PlantsVsZombies game = new PlantsVsZombies();
        game.start();
    }
}

// Kelas Menu
final class PlantsVsZombies { // Keyword final untuk class
    private final ArrayList<Tanaman> tanamanList = new ArrayList<>(); // Keyword final untuk variabel
    private final ArrayList<Zombie> zombieList = new ArrayList<>();
    private final ArrayList<Senjata> senjataList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int pilihan;

        do {
            System.out.println("\n===== Welcome to Plants vs Zombies =====");
            System.out.println("1. Tambah Entitas");
            System.out.println("2. Lihat Entitas");
            System.out.println("3. Perbarui Entitas");
            System.out.println("4. Hapus Entitas");
            System.out.println("5. Attack/Menyerang");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahEntitas();
                    break;
                case 2:
                    lihatEntitas();
                    break;
                case 3:
                    perbaruiEntitas();
                    break;
                case 4:
                    hapusEntitas();
                    break;
                case 5:
                    attack();
                    break;
                case 6:
                    System.out.println("Byeeeeeee, See you again :D");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Mohon masukkan angka dari 1 hingga 6.");
            }
        } while (pilihan != 6);
    }

    private void attack() {
        System.out.println("\n===== Attack/Menyerang =====");
        System.out.println("Pilih entitas untuk menyerang:");
        System.out.println("1. Serang Zombies");
        System.out.println("2. Serang Plants");
        System.out.println("3. Senjata");
        System.out.print("Masukkan pilihan Anda: ");

        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                Zombie.attackSound("Zombie");
                if (zombieList.isEmpty()) {
                    System.out.println("Tidak ada zombie yang tersedia.");
                } else {
                    for (int i = 0; i < zombieList.size(); i++) {
                        Zombie zombie = zombieList.get(i);
                        System.out.println(
                                (i + 1) + ". " + zombie.getNama() + " | Kekuatan : " + zombie.getKekuatan() + " CP ");
                        zombie.attack();
                    }
                }
                break;
            case 2:
                Tanaman.attackSound("Tanaman");
                if (tanamanList.isEmpty()) {
                    System.out.println("Tidak ada tanaman yang tersedia.");
                } else {
                    for (int i = 0; i < tanamanList.size(); i++) {
                        Tanaman tanaman = tanamanList.get(i);
                        System.out.println((i + 1) + ". " + tanaman.getNama() + " | Habitat: "
                                + tanaman.getHabitat() + " | Kekuatan : " + tanaman.getKekuatan() + " CP ");
                        tanaman.attack();
                    }
                }
                break;
            case 3:
                Senjata.attackSound("Senjata");
                if (senjataList.isEmpty()) {
                    System.out.println("Tidak ada senjata yang tersedia.");
                } else {
                    for (int i = 0; i < senjataList.size(); i++) {
                        Senjata senjata = senjataList.get(i);
                        System.out.println(
                                (i + 1) + ". " + senjata.getNama() + " | Kekuatan : " + senjata.getKekuatan() + " CP ");
                        senjata.attack();
                    }
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void tambahEntitas() {
        int pilihan;
        System.out.println("\n===== Tambah Entitas =====");
        System.out.println("1. Tambah Tanaman");
        System.out.println("2. Tambah Zombie");
        System.out.println("3. Tambah Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");

        pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                tambahTanaman();
                break;
            case 2:
                tambahZombie();
                break;
            case 3:
                tambahSenjata();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. Mohon masukkan angka dari 1 hingga 4.");
        }
    }

    private void tambahTanaman() {
        System.out.println("\n===== Tambah Tanaman =====");
        System.out.print("Masukkan nama tanaman: ");
        String nama = scanner.next();
        System.out.print("Masukkan habitat tanaman: ");
        String habitat = scanner.next();

        int kekuatan = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan Tanaman (Combat Power): ");
                kekuatan = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next(); // membersihkan buffer
            }
        } while (!validInput);

        tanamanList.add(new Tanaman(nama, habitat, kekuatan));
        System.out
                .println("Tanaman \"" + nama + "\" dengan kekuatan \"" + kekuatan + " CP" + "\" berhasil ditambahkan.");
        tambahEntitas();
    }

    private void tambahZombie() {
        System.out.println("\n===== Tambah Zombie =====");
        System.out.print("Masukkan nama zombie: ");
        String nama = scanner.next();

        int kekuatan = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan zombie (Combat Power): ");
                kekuatan = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next();
            }
        } while (!validInput);

        zombieList.add(new Zombie(nama, kekuatan));
        System.out
                .println("Zombie \"" + nama + "\" dengan kekuatan \"" + kekuatan + " CP" + "\" berhasil ditambahkan.");
        tambahEntitas();
    }

    private void tambahSenjata() {
        System.out.println("\n===== Tambah Senjata =====");
        System.out.print("Masukkan nama senjata: ");
        String nama = scanner.next();

        int kekuatan = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan senjata (Combat Power): ");
                kekuatan = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next();
            }
        } while (!validInput);

        senjataList.add(new Senjata(nama, kekuatan));
        System.out
                .println("Senjata \"" + nama + "\" dengan kekuatan \"" + kekuatan + " CP" + "\" berhasil ditambahkan.");
        tambahEntitas();
    }

    private void lihatEntitas() {
        int pilihan;
        System.out.println("\n===== Lihat Entitas =====");
        System.out.println("1. Lihat Tanaman");
        System.out.println("2. Lihat Zombie");
        System.out.println("3. Lihat Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");

        pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                lihatTanaman();
                break;
            case 2:
                lihatZombie();
                break;
            case 3:
                lihatSenjata();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. Mohon masukkan angka dari 1 hingga 4.");
        }
    }

    private void lihatTanaman() {
        System.out.println("\n===== Daftar Tanaman =====");
        if (tanamanList.isEmpty()) {
            System.out.println("Tidak ada tanaman yang tersedia.");
        } else {
            for (int i = 0; i < tanamanList.size(); i++) {
                Tanaman tanaman = tanamanList.get(i);
                System.out.println((i + 1) + ". " + tanaman.getNama() + " | Habitat: " + tanaman.getHabitat()
                        + " | Kekuatan : " + tanaman.getKekuatan() + " CP ");
            }
        }
        lihatEntitas();
    }

    private void lihatZombie() {
        System.out.println("\n===== Daftar Zombie =====");
        if (zombieList.isEmpty()) {
            System.out.println("Tidak ada zombie yang tersedia.");
        } else {
            for (int i = 0; i < zombieList.size(); i++) {
                Zombie zombie = zombieList.get(i);
                System.out.println((i + 1) + ". " + zombie.getNama() + " | Kekuatan : " + zombie.getKekuatan()
                        + " CP ");
            }
        }
        lihatEntitas();
    }

    private void lihatSenjata() {
        System.out.println("\n===== Daftar Senjata =====");
        if (senjataList.isEmpty()) {
            System.out.println("Tidak ada senjata yang tersedia.");
        } else {
            for (int i = 0; i < senjataList.size(); i++) {
                Senjata senjata = senjataList.get(i);
                System.out.println((i + 1) + ". " + senjata.getNama() + " | Kekuatan : " + senjata.getKekuatan()
                        + " CP ");
            }
        }
        lihatEntitas();
    }

    private void perbaruiEntitas() {
        int pilihan;
        System.out.println("\n===== Perbarui Entitas =====");
        System.out.println("1. Perbarui Tanaman");
        System.out.println("2. Perbarui Zombie");
        System.out.println("3. Perbarui Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");

        pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                perbaruiTanaman();
                break;
            case 2:
                perbaruiZombie();
                break;
            case 3:
                perbaruiSenjata();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. Mohon masukkan angka dari 1 hingga 4.");
        }
    }

    private void perbaruiTanaman() {
        System.out.println("\n===== Perbarui Tanaman =====");
        if (tanamanList.isEmpty()) {
            System.out.println("Tidak ada tanaman yang tersedia.");
            perbaruiEntitas();
            return;
        }

        System.out.println("Pilih tanaman yang ingin diperbarui:");

        for (int i = 0; i < tanamanList.size(); i++) {
            Tanaman tanaman = tanamanList.get(i);
            System.out.println((i + 1) + ". " + tanaman.getNama());
        }

        System.out.print("Masukkan nomor tanaman: ");
        int index = scanner.nextInt();
        if (index < 1 || index > tanamanList.size()) {
            System.out.println("Nomor tanaman tidak valid.");
            return;
        }

        Tanaman tanaman = tanamanList.get(index - 1);
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.next();
        tanaman.setNama(namaBaru);
        System.out.println("Nama tanaman berhasil diperbarui.");
    }

    private void perbaruiZombie() {
        System.out.println("\n===== Perbarui Zombie =====");
        if (zombieList.isEmpty()) {
            System.out.println("Tidak ada zombie yang tersedia.");
            perbaruiEntitas();
            return;
        }

        System.out.println("Pilih zombie yang ingin diperbarui:");

        for (int i = 0; i < zombieList.size(); i++) {
            Zombie zombie = zombieList.get(i);
            System.out.println((i + 1) + ". " + zombie.getNama());
        }

        System.out.print("Masukkan nomor zombie: ");
        int index = scanner.nextInt();
        if (index < 1 || index > zombieList.size()) {
            System.out.println("Nomor zombie tidak valid.");
            return;
        }

        Zombie zombie = zombieList.get(index - 1);
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.next();
        zombie.setNama(namaBaru);
        System.out.println("Nama zombie berhasil diperbarui.");
    }

    private void perbaruiSenjata() {
        System.out.println("\n===== Perbarui Senjata =====");
        if (senjataList.isEmpty()) {
            System.out.println("Tidak ada senjata yang tersedia.");
            perbaruiEntitas();
            return;
        }

        System.out.println("Pilih senjata yang ingin diperbarui:");

        for (int i = 0; i < senjataList.size(); i++) {
            Senjata senjata = senjataList.get(i);
            System.out.println((i + 1) + ". " + senjata.getNama());
        }

        System.out.print("Masukkan nomor senjata: ");
        int index = scanner.nextInt();
        if (index < 1 || index > senjataList.size()) {
            System.out.println("Nomor senjata tidak valid.");
            return;
        }

        Senjata senjata = senjataList.get(index - 1);
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.next();
        senjata.setNama(namaBaru);
        System.out.println("Nama senjata berhasil diperbarui.");
    }

    private void hapusEntitas() {
        int pilihan;
        System.out.println("\n===== Hapus Entitas =====");
        System.out.println("1. Hapus Tanaman");
        System.out.println("2. Hapus Zombie");
        System.out.println("3. Hapus Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");

        pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                hapusTanaman();
                break;
            case 2:
                hapusZombie();
                break;
            case 3:
                hapusSenjata();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. Mohon masukkan angka dari 1 hingga 4.");
        }
    }

    private void hapusTanaman() {
        System.out.println("\n===== Hapus Tanaman =====");
        if (tanamanList.isEmpty()) {
            System.out.println("Tidak ada tanaman yang tersedia.");
            hapusEntitas();
            return;
        }

        System.out.println("Pilih tanaman yang ingin dihapus:");

        for (int i = 0; i < tanamanList.size(); i++) {
            Tanaman tanaman = tanamanList.get(i);
            System.out.println((i + 1) + ". " + tanaman.getNama());
        }

        System.out.print("Masukkan nomor tanaman: ");
        int index = scanner.nextInt();
        if (index < 1 || index > tanamanList.size()) {
            System.out.println("Nomor tanaman tidak valid.");
            return;
        }

        Tanaman tanaman = tanamanList.remove(index - 1);
        System.out.println("Tanaman \"" + tanaman.getNama() + "\" berhasil dihapus.");
    }

    private void hapusZombie() {
        System.out.println("\n===== Hapus Zombie =====");
        if (zombieList.isEmpty()) {
            System.out.println("Tidak ada zombie yang tersedia.");
            hapusEntitas();
            return;
        }

        System.out.println("Pilih zombie yang ingin dihapus:");

        for (int i = 0; i < zombieList.size(); i++) {
            Zombie zombie = zombieList.get(i);
            System.out.println((i + 1) + ". " + zombie.getNama());
        }

        System.out.print("Masukkan nomor zombie: ");
        int index = scanner.nextInt();
        if (index < 1 || index > zombieList.size()) {
            System.out.println("Nomor zombie tidak valid.");
            return;
        }

        Zombie zombie = zombieList.remove(index - 1);
        System.out.println("Zombie \"" + zombie.getNama() + "\" berhasil dihapus.");
    }

    private void hapusSenjata() {
        System.out.println("\n===== Hapus Senjata =====");
        if (senjataList.isEmpty()) {
            System.out.println("Tidak ada senjata yang tersedia.");
            hapusEntitas();
            return;
        }

        System.out.println("Pilih senjata yang ingin dihapus:");

        for (int i = 0; i < senjataList.size(); i++) {
            Senjata senjata = senjataList.get(i);
            System.out.println((i + 1) + ". " + senjata.getNama());
        }

        System.out.print("Masukkan nomor senjata: ");
        int index = scanner.nextInt();
        if (index < 1 || index > senjataList.size()) {
            System.out.println("Nomor senjata tidak valid.");
            return;
        }

        Senjata senjata = senjataList.remove(index - 1);
        System.out.println("Senjata \"" + senjata.getNama() + "\" berhasil dihapus.");
    }
}
