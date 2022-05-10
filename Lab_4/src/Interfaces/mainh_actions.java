package Interfaces;

public interface mainh_actions{
    default public void fill(){
        System.out.print("заполнили ");
    }
    default public void seems(){
        System.out.print("казалось");
    }
    default public void saw(){
        System.out.print("видел");
    }
}