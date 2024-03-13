package punto5;

import javax.swing.JOptionPane;

import punto01_02_03_04_13.Lista;

public class main {
    public static void main(String[] args) {
        SimpleList<Integer> lista2 = new SimpleList();
        lista2.add(2);
        lista2.add(3);
        lista2.add(3);
        lista2.add(6);
        lista2.add(2);
        System.out.println(lista2.calculateNumberofTimesThatAnItemRepeats(3));
    }
}
