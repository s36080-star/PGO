/**
 * Klasa pomocnicza wyświetlająca informacje o aplikacji.
 * Dodana w gałęzi feature/info.
 */
public class AppInfo {

    private static final String APP_NAME    = "pgo-git-start";
    private static final String VERSION     = "1.0.0";
    private static final String SUBJECT     = "PGO – Programowanie Grupowe i Obiektowe";
    private static final String UNIVERSITY  = "PJATK";

    public void printInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Aplikacja : " + APP_NAME);
        System.out.println("Wersja    : " + VERSION);
        System.out.println("Przedmiot : " + SUBJECT);
        System.out.println("Uczelnia  : " + UNIVERSITY);
        System.out.println("----------------------------------------");
    }
}
