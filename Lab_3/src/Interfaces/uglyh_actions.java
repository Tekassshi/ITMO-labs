package Interfaces;

public interface uglyh_actions{
    default public void appear(){
        System.out.print("появились ");
    }
    default public void press(){
        System.out.print("теснили ");
    }
    default public void hit(){
        System.out.print("колотя их дубинками");
    }
    default public void move(){
        System.out.print("загоняли ");
    }
}
