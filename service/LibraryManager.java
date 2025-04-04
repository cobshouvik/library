package service;

import model.*;

public class LibraryManager{
    static LibraryManager instance;
    Library library;

    private LibraryManager() {
    }

    public static synchronized LibraryManager getLibraryManager() {
        if(instance == null) {
            instance = new LibraryManager(); 
        }
        return instance;
    }

    public void createLibrary(String id, int racks) {
        this.library = new Library(id, racks);
        System.out.println(String.format("Created library with %s racks", racks));
    }

    // public void createLibrary(String id, int racks) {
    //     this.library = new Library(id, racks);
    //     System.out.println(String.format("Created library with %s racks", racks));
    // }

    // public void createLibrary(String id, int racks) {
    //     this.library = new Library(id, racks);
    //     System.out.println(String.format("Created library with %s racks", racks));
    // }

}