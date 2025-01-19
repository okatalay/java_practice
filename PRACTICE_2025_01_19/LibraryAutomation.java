package PRACTICE_2025_01_19;


import java.util.ArrayList;
import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean isBorrowed;
    String personName;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        isBorrowed = false;
        personName = "";
    }
}


public class LibraryAutomation {

    static ArrayList<Book> books = new ArrayList<Book>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook(){
        System.out.print("Kitap adını giriniz: ");
        String title = sc.nextLine();
        System.out.println("Yazar adını giriniz: ");
        String author = sc.nextLine();

        books.add(new Book(title, author));
        System.out.println("Kitap başarıyla listeye eklendi.");
    }


    public static void listBook(){

        if (books.isEmpty()){
            System.out.println("Aktif kitap bulunamadı !");
            return;
        }

        System.out.println("Mevcut kitap listesi:\n");
        int number = 1;
        for (Book book : books){

            System.out.println(number + "- Kitap Adı: " + book.title + " | Yazar: " + book.author
            + " | Ödünç Durumu: " + (book.isBorrowed ? "Ödünç Verildi" : "Mevcut"));

            number +=1;
        }
    }

    public static void barrowBook(){

        listBook();

        System.out.println("Ödünç vermek istediğiniz kitabın numarasını giriniz: ");
        int number = sc.nextInt();
        sc.nextLine();

    }


    public static void main(String[] args) {

        while(true){

            System.out.println("\n >>> KÜTÜPHANE OTOMASYONU <<<");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Kitap Ödünç Ver");
            System.out.println("4. Kitap İade Et");
            System.out.println("5. Çıkış Yap");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> addBook();
                case 2 -> listBook();
                case 3 -> barrowBook();
//                case 4 -> returnBook();
                case 5 -> System.out.println("Sistem sonlandırıldı");

            }
        }
    }
}
