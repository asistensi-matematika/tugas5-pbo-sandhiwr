/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas5pbo;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class Tugas5PBO {

    /**
     * @param args the command line arguments
     */public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Buku [] perpus = new Buku[10000];
        
        int n = 3; 
       
        int fiksi = 0;
        int halamanfiksi = 0;
        int nonfiksi = 0;
        int halamannonfiksi = 0;
        double ragamfiksi = 0;
        double ragamnonfiksi = 0;
              
        Random rd =  new Random();
       
    
        for(int i = 0; i<n; i++){
            int random = rd.nextInt(2)+1;
            
            if(random==1){
                perpus[i] = new Fiksi("Harry Potter", "J.K. Rowling", 250, "Fiksi");
                fiksi+=1;
                halamanfiksi+=perpus[i].getHalaman();
                ragamfiksi = Math.pow(perpus[i].getHalaman()-ratarata(halamanfiksi,fiksi), 2);
            }
            else{
                perpus[i] = new NonFiksi("Belajar PBO", "Sandhi", 100, "NonFiksi");
                nonfiksi+=1;
                halamannonfiksi+=perpus[i].getHalaman();
                ragamnonfiksi = Math.pow(perpus[i].getHalaman()-ratarata(halamannonfiksi,nonfiksi), 2);
            }
        }
        
        double ratarata = (halamanfiksi+halamannonfiksi)/n;
        double sumragamfiksi = Math.sqrt(ragamfiksi/fiksi);
        double sumragamnonfiksi = Math.sqrt(ragamnonfiksi/nonfiksi);
        int sumhalamanbuku = fiksi+nonfiksi;
        double sumragambuku = Math.pow(sumhalamanbuku-ratarata,2);
        
        double z=0;
                for(int i=0; i<n; i++){
                    System.out.println("");
                    z += Math.pow((perpus[i].getHalaman()-ratarata(sumhalamanbuku,n)),2);
                }
                double ragambuku = Math.sqrt(z/n);
        
        double ratafiksi = halamanfiksi/fiksi;
        double ratanonfiksi = halamannonfiksi/nonfiksi;
        for(int i = 0; i<n; i++){
            if(perpus[i].getJenis()=="Fiksi"){
                ragamfiksi = Math.pow(perpus[i].getHalaman()-ratafiksi, 2);
            }
            
            else{
                ragamnonfiksi = Math.pow(perpus[i].getHalaman()-ratanonfiksi, 2);
            }
        }
        
        for(int c = 0; c<n; c++){
        header("1.txt");
        System.out.println("[1]. input buku baru\n" + "[2]. modifikisi detail buku\n" + "[3]. hapus buku\n" + "[0]. EXIT");
        System.out.println("=====================================================================");
        System.out.println("Jumlah buku di dalam perpustakaan: "+n+ "\nRata-rata halaman buku dalam perpustakaan: "+ratarata +"\nStandar deviasi halaman buku dalam perpustakaan: "+ragambuku);
        System.out.println("=====================================================================");
        System.out.println("Jumlah Buku Fiksi dalam perpustakaan: "+fiksi + "\nRata-rata halaman Buku Fiksi dalam perpustakaan: "+ratafiksi + "\nStandar deviasi halaman Buku Fiksi dalam perpustakaan: "+sumragamfiksi);
        System.out.println("=====================================================================");
        System.out.println("Jumlah Buku Non Fiksi dalam perpustakaan : "+nonfiksi + "\nRata-rata halaman Buku Non Fiksi dalam perpustakaan: "+ratanonfiksi +"\nStandar deviasi halaman Buku Non Fiksi dalam perpustakaan: "+sumragamnonfiksi);
        System.out.println("=====================================================================");
        System.out.print("\nMasukkan Pilihan : ");
        int pilihan = input.nextInt();
        
        switch(pilihan){
            case 1:
                header("2.txt");
                System.out.println("Input Judul Buku : \n>");
                String A = input.next();
                perpus[n].setJudul(A);
                System.out.println("Input Pengarang : \n>");
                String B = input.next();
                perpus[n].setPengarang(B);
                System.out.println("Input Jumlah Halaman : \n>");
                int C = input.nextInt();
                perpus[n].setHalaman(C);
               
                int random = rd.nextInt(2)+1;
                if(random == 1){
                    perpus[n-1] = new Buku(A, B, C, "Fiksi");
                    fiksi+=1;
                    halamanfiksi+=C;
                }
                else if (random==2){
                    perpus[n-1] = new Buku(A, B, C, "Fiksi");
                    nonfiksi+=1;
                    halamannonfiksi+=C;
                }
                n++;
                break;
                        
            case 2:
                header("3.txt");
                for(int i = 0; i < n; i++){
                    System.out.println((i+1)+". "+perpus[i].getJudul()+" | "+perpus[i].getPengarang());
                }
                System.out.print("Pilih Buku yang Akan Diubah: ");
            int x = input.nextInt();
            
            switch(x){
                case 1:
                System.out.println("Input Judul Buku : \n>");
                String AA = input.next();
                perpus[n].setJudul(AA);
                System.out.println("Input Pengarang : \n>");
                String BB = input.next();
                perpus[n].setPengarang(BB);
                System.out.println("Input Jumlah Halaman : \n>");
                int CC = input.nextInt();
                perpus[n].setHalaman(CC);
               
                if(perpus[0].getJenis()=="Fiksi"){
                    perpus[0] = new Fiksi(AA, BB, CC, "Fiksi");
                    perpus[0].setHalaman(CC);
                }
                if(perpus[0].getJenis()=="NonFiksi"){
                    perpus[0] = new Fiksi(AA, BB, CC, "NonFiksi");
                    perpus[0].setHalaman(CC);
                }
                break;
                    
                case 2:
                System.out.println("Input Judul Buku : \n>");
                String AAA = input.next();
                perpus[n].setJudul(AAA);
                System.out.println("Input Pengarang : \n>");
                String BBB = input.next();
                perpus[n].setPengarang(BBB);
                System.out.println("Input Jumlah Halaman : \n>");
                int CCC = input.nextInt();
                perpus[n].setHalaman(CCC);
               
                if(perpus[1].getJenis()=="Fiksi"){
                    perpus[1] = new Fiksi(AAA, BBB, CCC, "Fiksi");
                    perpus[1].setHalaman(CCC);
                }
                if(perpus[1].getJenis()=="NonFiksi"){
                    perpus[1] = new Fiksi(AAA, BBB, CCC, "NonFiksi");
                    perpus[1].setHalaman(CCC);
                }
                break;
                
                case 3:
                System.out.println("Input Judul Buku : \n>");
                String AAAA = input.next();
                perpus[n].setJudul(AAAA);
                System.out.println("Input Pengarang : \n>");
                String BBBB = input.next();
                perpus[n].setPengarang(BBBB);
                System.out.println("Input Jumlah Halaman : \n>");
                int CCCC = input.nextInt();
                perpus[n].setHalaman(CCCC);
               
                if(perpus[2].getJenis()=="Fiksi"){
                    perpus[2] = new Fiksi(AAAA, BBBB, CCCC, "Fiksi");
                    perpus[2].setHalaman(CCCC);
                }
                if(perpus[2].getJenis()=="NonFiksi"){
                    perpus[2] = new Fiksi(AAAA, BBBB, CCCC, "NonFiksi");
                    perpus[2].setHalaman(CCCC);
                }    
                break;
            }
            break;
                
            case 3:
                System.out.println("Pilih Buku yang Akan Dihapus : ");
                for(int i = 0; i < n; i++){
                System.out.println((1+n)+". "+perpus[n].getJudul()+" | "+perpus[n].getPengarang());
            }
                System.out.println("Pilihan : ");
                int y = input.nextInt();
                switch(y){
                    case 1:
                        try{
                        for(int i=1; i<n; i++){
                            perpus[i-1]=perpus[i];
                            System.out.println("");
                        }
                        if(perpus[0].getJenis()=="Fiksi"){
                            fiksi-=1;
                            perpus[0].setHalaman(0);
                        }else{
                            nonfiksi-=1;
                            perpus[0].setHalaman(0);
                        }
                        n-=1;
                        }
                        catch(Exception e){
                            System.out.println("salah");
                        }
                        break;
                    case 2:
                        try{
                        for(int i=2; i<n; i++){
                            perpus[i-1]=perpus[i];
                            System.out.println("");
                        }
                        if(perpus[1].getJenis()=="Fiksi"){
                            fiksi-=1;
                            perpus[1].setHalaman(0);
                        }else{
                            nonfiksi-=1;
                            perpus[1].setHalaman(0);
                        }
                        n-=1;
                        }
                        catch(Exception e){
                            
                        }
                        break;
                    case 3:
                        try{
                        for(int i=0; i<n-1; i++){
                            System.out.println("");
                            
                        }
                        if(perpus[2].getJenis()=="Fiksi"){
                            fiksi -=1;
                            perpus[2].setHalaman(0);
                        }else{
                            nonfiksi-=1;
                            perpus[2].setHalaman(0);
                        }
                        n-=1;
                        }
                        catch(Exception e){
                            
                        }
                        break;
                }
            break;
                
            case 0:
                header("1.txt");
                System.exit(0);
        }
    }
    }
        public static void header(String nama_file_txt){
        File file = new File(nama_file_txt);
        String encoding = "utf-8";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)) {
            int data = isr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = isr.read();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }

public static double ratarata(int sum, int banyak){
        double ratarata=0;
        if(banyak == 0){
            System.out.print("");
        }else{
            ratarata = sum/banyak;
        }
        return ratarata;
    }
}

class Buku{
    private String judul, pengarang, jenis;
    private int halaman;
    
    public Buku(){
        judul = " ";
        pengarang = " ";
        jenis = " ";
        halaman = 0;
    }
    
    public Buku(String judul, String pengarang, int halaman, String jenis){
        this.judul = judul;
        this.pengarang = pengarang; 
        this.halaman = halaman;
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }
        
    public void info(){
        System.out.println("Judul : "+getJudul());
        System.out.println("Pengarang : "+getPengarang());
        System.out.println("Jumlah Halaman : "+getHalaman());
    }
}

class Fiksi extends Buku {
    private String jenisA;
    public Fiksi(){
        super();
        jenisA = "Fiksi";
    }
    
    public Fiksi(String judul, String pengarang, int halaman, String jenisA){
        super();
        this.jenisA = jenisA;
    }
        public void setJenis(String jenisA){
        this.jenisA = jenisA;
    }
    
    public String getJenis(){
        return jenisA;
    }

}

class NonFiksi extends Buku {
    private String jenisB;
    
    public NonFiksi(){
        super();
        jenisB = "NonFiksi";
    }
    
    public NonFiksi(String judul, String pengarang, int halaman, String jenisB){
        super();
        this.jenisB = jenisB;
    }
    
    public void setJenis(String jenis){
        this.jenisB = jenisB;
    }
    
    public String getJenis(){
        return jenisB;
    }
}
