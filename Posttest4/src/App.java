import java.util.ArrayList;
import java.util.Scanner;

// Kelas Entitas - Superclass 
class Entitas {
    protected String nama;

    public Entitas(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Fungsi suara()
    public void suara() {
        System.out.println("Entitas " + nama + " mengeluarkan suara.");
    }

    // Static method overloading
    public static void suara(String namaEntitas) {
        System.out.println("Entitas " + namaEntitas + " mengeluarkan suara.");
    }

    // Static method overloading attack
    public static void attackSound(String namaEntitas) {
        System.out.println("!!!AWAS, ENTITAS " + namaEntitas + " MENYERANG!!!");
    }
}

// Kelas Tanaman - Subclass
class Tanaman extends Entitas {
    private int kekuatan;
    private String habitat;

    public Tanaman(String nama, String habitat, int kekuatan) {
        super(nama);
        this.habitat = habitat;
        this.kekuatan = kekuatan;
    }

    // Metode Getter
    public int getKekuatan() {
        return kekuatan;
    }

    // Metode Setter
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // Metode Getter untuk habitat
    public String getHabitat() {
        return habitat;
    }

    // Metode Setter untuk habitat
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Tanaman " + getNama() + " mengeluarkan suara: ~~~ Ssshhh... Ssshhh... ~~~");
    }
}

// Kelas Zombie - Subclass
class Zombie extends Entitas {
    private int kekuatan;

    public Zombie(String nama, int kekuatan) {
        super(nama);
        this.kekuatan = kekuatan;
    }

    // Metode Getter
    public int getKekuatan() {
        return kekuatan;
    }

    // Metode Setter
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Zombie " + getNama() + " mengeluarkan suara: ~~~ Arrrggghh... Arrrggghh... ~~~");
    }
}

// Kelas Senjata - Subclass
class Senjata extends Entitas {
    private int kekuatan;

    public Senjata(String nama, int kekuatan) {
        super(nama);
        this.kekuatan = kekuatan;
    }

    // Metode Getter
    public int getKekuatan() {
        return kekuatan;
    }

    // Metode Setter
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    // Override method suara
    @Override
    public void suara() {
        System.out.println("Senjata " + getNama() + " mengeluarkan suara: ~~~ Pew! Pew! Pew! ~~~");
    }

}

// Kelas Utama
public class App {
    public static void main(String[] args) {
        PlantsVsZombies game = new PlantsVsZombies();
        game.start();
    }
}

// Kelas Menu
class PlantsVsZombies {
    private ArrayList<Tanaman> tanamanList = new ArrayList<>();
    private ArrayList<Zombie> zombieList = new ArrayList<>();
    private ArrayList<Senjata> senjataList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
                Entitas.attackSound("Tanaman");
                if (tanamanList.isEmpty()) {
                    System.out.println("Tidak ada tanaman yang tersedia.");
                } else {
                    for (int i = 0; i < tanamanList.size(); i++) {
                        Tanaman tanaman = tanamanList.get(i);
                        System.out.println((i + 1) + ". " + tanaman.getNama() + " | Habitat: "
                                + tanaman.getHabitat() + " | Kekuatan : " + tanaman.getKekuatan() + " CP ");
                        tanaman.suara();
                    }
                }
                break;
            case 2:
                Entitas.attackSound("Zombie");
                if (zombieList.isEmpty()) {
                    System.out.println("Tidak ada zombie yang tersedia.");
                } else {
                    for (int i = 0; i < zombieList.size(); i++) {
                        Zombie zombie = zombieList.get(i);
                        System.out
                                .println((i + 1) + ". " + zombie.getNama() + " | Kekuatan : " + zombie.getKekuatan()
                                        + " CP ");
                        zombie.suara();
                    }
                }
                break;
            case 3:
                Entitas.attackSound("Senjata");
                for (int i = 0; i < senjataList.size(); i++) {
                    Senjata senjata = senjataList.get(i);
                    System.out.println(
                            (i + 1) + ". " + senjata.getNama() + " | Kekuatan : " + senjata.getKekuatan() + " CP ");
                    senjata.suara();
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
                System.out.println((i + 1) + ". " + tanaman.getNama() + " | Habitat: "
                        + tanaman.getHabitat() + " | Kekuatan : " + tanaman.getKekuatan() + " CP ");

            }
        }
    }

    private void lihatZombie() {
        System.out.println("\n===== Daftar Zombie =====");
        if (zombieList.isEmpty()) {
            System.out.println("Tidak ada zombie yang tersedia.");
        } else {
            for (int i = 0; i < zombieList.size(); i++) {
                Zombie zombie = zombieList.get(i);
                System.out
                        .println((i + 1) + ". " + zombie.getNama() + " | Kekuatan : " + zombie.getKekuatan() + " CP ");
            }
        }
    }

    private void lihatSenjata() {
        System.out.println("\n===== Daftar Senjata =====");
        if (senjataList.isEmpty()) {
            System.out.println("Tidak ada senjata yang tersedia.");
        } else {
            for (int i = 0; i < senjataList.size(); i++) {
                Senjata senjata = senjataList.get(i);
                System.out.println(
                        (i + 1) + ". " + senjata.getNama() + " | Kekuatan : " + senjata.getKekuatan() + " CP ");

            }
        }
    }

    private void perbaruiEntitas() {
        System.out.println("\n===== Perbarui Entitas =====");
        System.out.println("Pilih jenis entitas yang akan diperbarui:");
        System.out.println("1. Tanaman");
        System.out.println("2. Zombie");
        System.out.println("3. Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Buang newline

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
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void perbaruiTanaman() {
        lihatTanaman();
        if (tanamanList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks tanaman yang ingin diperbarui: ");
        int indeks = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        if (indeks < 1 || indeks > tanamanList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
        System.out.print("Masukkan habitat baru: ");
        String habitatBaru = scanner.nextLine();

        int kekuatanBaru = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan baru (Combat Power): ");
                kekuatanBaru = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next(); // membersihkan buffer
            }
        } while (!validInput);

        tanamanList.get(indeks - 1).setNama(namaBaru);
        tanamanList.get(indeks - 1).setHabitat(habitatBaru);
        tanamanList.get(indeks - 1).setKekuatan(kekuatanBaru);
        System.out.println("Tanaman berhasil diperbarui.");
    }

    private void perbaruiZombie() {
        lihatZombie();
        if (zombieList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks zombie yang ingin diperbarui: ");
        int indeks = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        if (indeks < 1 || indeks > zombieList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();

        int kekuatanBaru = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan baru (Combat Power): ");
                kekuatanBaru = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next();
            }
        } while (!validInput);

        zombieList.get(indeks - 1).setNama(namaBaru);
        zombieList.get(indeks - 1).setKekuatan(kekuatanBaru);
        System.out.println("Zombie berhasil diperbarui.");
    }

    private void perbaruiSenjata() {
        lihatSenjata();
        if (senjataList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks senjata yang ingin diperbarui: ");
        int indeks = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        if (indeks < 1 || indeks > senjataList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();

        int kekuatanBaru = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Masukkan Jumlah kekuatan baru (Combat Power): ");
                kekuatanBaru = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Mohon Masukkan Input tersebut berupa angka.");
                scanner.next();
            }
        } while (!validInput);

        senjataList.get(indeks - 1).setNama(namaBaru);
        senjataList.get(indeks - 1).setKekuatan(kekuatanBaru);
        System.out.println("Senjata berhasil diperbarui.");
    }

    private void hapusEntitas() {
        System.out.println("\n===== Hapus Entitas =====");
        System.out.println("Pilih jenis entitas yang akan dihapus:");
        System.out.println("1. Tanaman");
        System.out.println("2. Zombie");
        System.out.println("3. Senjata");
        System.out.println("4. Kembali ke Menu Utama");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Buang newline

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
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void hapusTanaman() {
        lihatTanaman();
        if (tanamanList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks tanaman yang ingin dihapus: ");
        int indeks = scanner.nextInt();
        if (indeks < 1 || indeks > tanamanList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        tanamanList.remove(indeks - 1);
        System.out.println("Tanaman berhasil dihapus.");
    }

    private void hapusZombie() {
        lihatZombie();
        if (zombieList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks zombie yang ingin dihapus: ");
        int indeks = scanner.nextInt();

        if (indeks < 1 || indeks > zombieList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        zombieList.remove(indeks - 1);
        System.out.println("Zombie berhasil dihapus.");
    }

    private void hapusSenjata() {
        lihatSenjata();
        if (senjataList.isEmpty()) {
            return;
        }

        System.out.print("Masukkan indeks senjata yang ingin dihapus: ");
        int indeks = scanner.nextInt();

        if (indeks < 1 || indeks > senjataList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        senjataList.remove(indeks - 1);
        System.out.println("Senjata berhasil dihapus.");
    }
}
