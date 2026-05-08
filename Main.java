import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int[][] peta = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, 
            {1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1}  
        };

        
        int baris = 5; 
        int kolom = 11; 
        int tenaga = 100; 

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("---Riyani Mendaki Semeru ---");
            System.out.println("Mulai dari P1. Tenaga: " + tenaga);

            
            while (tenaga > 0) {
                System.out.print("Masukkan langkah (L/R/U/D) atau 'S' untuk Istirahat: ");
                char langkah = input.next().toUpperCase().charAt(0);

                if (langkah == 'S') {
                    if(kolom == 11 && baris == 5 || kolom == 0 && baris == 5 || kolom == 6 && baris == 4 || kolom == 2 && baris == 3 || kolom == 5 && baris== 2 || kolom == 7 && baris== 1 || kolom == 0 && baris== 0){
                    tenaga += 10;
                    System.out.println("Istirahat sejenak... Tenaga bertambah jadi: " + tenaga);
                    continue; 
                    }else{
                        System.out.println("Mohon maaf, istirahat hanya diperbolehkan di pos-pos yang tersedia");
                    }
                }

                
                if (langkah == 'U') baris--;
                else if (langkah == 'D') baris++;
                else if (langkah == 'L') kolom--;
                else if (langkah == 'R') kolom++;

                
                if (baris < 0 || baris >= 6 || kolom < 0 || kolom >= 11 || peta[baris][kolom] == 0) {
                    System.out.println("Jalur anda salah, anda masuk ke jurang/blank [" + baris + "][" + kolom + "]");
                    break;
                }

                tenaga -= 1; 
                System.out.println("Posisi sekarang: [" + baris + "][" + kolom + "] | Tenaga: " + tenaga);

                
                if (baris == 0 && kolom == 0) {
                    System.out.println("Selamat Pendakian anda berhasil mencapai Puncak Mahameru, sisa tenaga anda [" + tenaga +"]");
                    break;
                }
            }
        }
    }
}