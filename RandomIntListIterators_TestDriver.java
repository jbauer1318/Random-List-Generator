import java.util.Scanner;

public class RandomIntListIterators_TestDriver {

    public static void main(String[] args) {
        int list_size, range, which;
        IntListItrInterface itr = null;
        Scanner input = new Scanner(System.in);
        
        // -- prompt user for size, value range, and type of list
        System.out.println("Enter number of random ints to generate: ");
        list_size = input.nextInt();
        
        System.out.println("Enter upper limit of numbers: ");
        range = input.nextInt();
        
        System.out.println("<1> All values, <2> Even values: ");
        which = input.nextInt();
        
        // -- create list of random values
        RandomIntList nums = new RandomIntList(list_size,range+1);
        
        // -- get appropriate iterator object
        switch(which) {
            case 1: itr = nums.getAllValuesIterator(); 
                    break;
            case 2: itr = nums.getEvenValuesIterator();
                    break;
        }
        
        // -- display appropriate values in list
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}