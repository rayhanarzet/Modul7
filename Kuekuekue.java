abstract class Kue { //inii adalah abstract class kue
    private String nama;
    private double harga;
    public Kue(String nama, double harga) { //buat constructor
        this.nama = nama;
        this.harga = harga;
}

    public String getNama() { //getter nama
    return nama;
}
    public double getHarga() {  //getter harga satuan
    return harga;
}
    public abstract double hitungHarga();  //method abstract buat menghitung harga total

@Override //menampilkan nama dan harga satuan kue
    public String toString() {
    return "Nama: " + nama + ", Harga satuan: Rp" + harga;
 }
}

class KuePesanan extends Kue {  //buat subclass KuePesanan
    private double berat; 
    public KuePesanan(String nama, double harga, double berat) {  //buat constructor
        super(nama, harga);
        this.berat = berat;
    }
    public double getBerat() {   //getter berat
    return berat;
    }
@Override   //implementasi hitungHarga untuk KuePesanan
    public double hitungHarga() {
    return getHarga() * berat;
    }
@Override  //override toString menampilkan info tambahan
    public String toString() {
    return "Kue Pesanan - " + super.toString() + ", Berat: " + berat + " kg, Harga total: Rp" + hitungHarga();
 }
}

class KueJadi extends Kue { //subclass KueJadi
    private double jumlah; //jumlah item
    public KueJadi(String nama, double harga, double jumlah) {  //seperti biasa, constructor
        super(nama, harga);
        this.jumlah = jumlah;
    }
    public double getJumlah() { //getter jumlah
    return jumlah;
    }
@Override  //implementasi hitungHarga untuk KueJadi
    public double hitungHarga() {
    return getHarga() * jumlah * 2;
    }

@Override  // Override toString untuk menampilkan tambahan info
    public String toString() {
    return "Kue Jadi - " + super.toString() + ", Jumlah: " + jumlah + ", Harga total: Rp" + hitungHarga();
 }
}

public class Kuekuekue { // Main Classs
    public static void main(String[] args) {
        Kue[] kueArray = new Kue[20];  //buat array Kue dengan 20 elemen
 //buat array dengan gabungan objek KuePesanan dan KueJadi
        kueArray[0] = new KuePesanan("Brownies", 50000, 1.2);
        kueArray[1] = new KueJadi("Donat", 5000, 10);
        kueArray[2] = new KuePesanan("Bolu", 45000, 0.8);
        kueArray[3] = new KueJadi("Kue Cubit", 3000, 20);
        kueArray[4] = new KuePesanan("Kastengel", 60000, 1.0);
        kueArray[5] = new KueJadi("Pastel", 4000, 15);
        kueArray[6] = new KuePesanan("Lapis Legit", 80000, 0.5);
        kueArray[7] = new KueJadi("Risoles", 3500, 12);
        kueArray[8] = new KuePesanan("Kue Lumpur", 55000, 0.7);
        kueArray[9] = new KueJadi("Pie Buah", 7000, 8);
        kueArray[10] = new KuePesanan("Puding", 30000, 1.5);
        kueArray[11] = new KueJadi("Cupcake", 8000, 6);
        kueArray[12] = new KuePesanan("Tart", 100000, 0.9);
        kueArray[13] = new KueJadi("Serabi", 2500, 18);
        kueArray[14] = new KuePesanan("Kue Nastar", 75000, 1.1);
        kueArray[15] = new KueJadi("Lemper", 4000, 10);
        kueArray[16] = new KuePesanan("Onde-onde", 35000, 2.0);
        kueArray[17] = new KueJadi("Sosis Solo", 5000, 7);
        kueArray[18] = new KuePesanan("Roti Manis", 20000, 2.5);
        kueArray[19] = new KueJadi("Kue Pepe", 3000, 15);

//variabel untuk menghitung total
    double totalHargaSemua = 0;
    double totalHargaPesanan = 0;
    double totalBeratPesanan = 0;
    double totalHargaJadi = 0;
    double totalJumlahJadi = 0;
    Kue kueTermahal = kueArray[0];

//menampilkan semua kue dan totalnya
    for (Kue kue : kueArray) {
        System.out.println(kue); // Pemanggilan toString secara polimorfis
            totalHargaSemua += kue.hitungHarga(); // Hitung total harga semua kue

//meengecek jenis kue menggunakan instanceof
    if (kue instanceof KuePesanan) {
        totalHargaPesanan += kue.hitungHarga();
            totalBeratPesanan += ((KuePesanan) kue).getBerat();
    } else if (kue instanceof KueJadi) {
        totalHargaJadi += kue.hitungHarga();
                totalJumlahJadi += ((KueJadi) kue).getJumlah();
     }
//cari kue dengan harga total terbesar
    if (kue.hitungHarga() > kueTermahal.hitungHarga()) {
        kueTermahal = kue;
     }
    }

    //hasil perhitungan
    System.out.println("\nTotal harga semua kue: Rp" + totalHargaSemua);
    System.out.println("Total harga KuePesanan: Rp" + totalHargaPesanan);
    System.out.println("Total berat KuePesanan: " + totalBeratPesanan + " kg");
    System.out.println("Total harga KueJadi: Rp" + totalHargaJadi);
    System.out.println("Total jumlah KueJadi: " + totalJumlahJadi);
    //kue dengan harga terbesar
        System.out.println("\nKue dengan harga terbesar:");
        System.out.println(kueTermahal);
 }
}

