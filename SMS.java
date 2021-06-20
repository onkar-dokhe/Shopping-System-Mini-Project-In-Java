package company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class SMS {

    public static void ShoppingBill(Map<Integer,String> total, Map<Integer,String> to_take, Scanner k) {
        System.out.println("\nHow Many products you want to buy ? :");
        int n = k.nextInt();
        System.out.printf("\nGot %d purchases. Choose your product now by entering 1, 2, 3...:\n", n);
        List<Integer> to_take_values = new ArrayList<Integer>();
        for(int j=0;j<n;j++)
	 {
	int r = k.nextInt();to_take_values.add(r);
	}

        for(Entry<Integer,String> jl:total.entrySet()) {
            String prt = jl.getValue().split("")[0];
            for(int r=0;r<to_take_values.size();r++) {
                if(Integer.parseInt(prt) == to_take_values.get(r)) {
                    to_take.put(jl.getKey(), jl.getValue());
                }
            }
        }

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(String.format(
                "------------------------------------------------------------------\n"
                        + "|\t\t JK Mart Private Limited     |\n"+
                        "| Add: Main Market Pimpri, Pimpri Chinchwad|\n|\t  Contact No. 9876543210\t\t\t  |\n"+
                        "-------------------------------------------------------------------\n"));
        System.out.println("\t\t Bill to Pay *");
        Random rand = new Random();
        System.out.println(String.format(
                "To. Cash\t\t"+"\t\t\tBill No: "+rand.nextInt(10000)+"\n\t\t Date & Time: "+f.format(date)+"\n"+
                        "---------------------------------------------------------------------"));
        for(Entry<Integer,String> fa:to_take.entrySet()) {
            System.out.printf("Item => %d, Amount(in Rs) => %s\n", fa.getKey(), fa.getValue());
        }

        to_take.clear();
    }

    public static List<String> Products() {
        List<String> product = new ArrayList<String>(List.of(
                "1.Whole Grain Breads Rs.40","2.Brown Rice Wrape Rs.69/Kg","3.Oats Rs.20","4.Bulgur Rs.100",
                "5.Baking Soda Rs.50/kg","6.Sea Sat Rs.10","7.Natural Oil Rs.140/lit","8.Catalyst Rs.55",
                "9.Green Tea Rs.69", "10.Coffee Rs.28"
        ));
        return product;
    }

    public static void main(String[] args) {
        List<String> products = new ArrayList<String>(Products());
        List<Integer> prices = new ArrayList<Integer>(List.of(40, 69, 20, 100, 50, 10, 140, 55, 69, 28));
        Map<Integer,String> products_to_take = new HashMap<Integer,String>();
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(int j=0;j<prices.size();j++)
	{
	map.put(prices.get(j), products.get(j));
	}
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.println(String.format(
                    "\nPlease Enter your choice\n1.Product List\n2.Generate Shopping Bill\n3.Exit"
            ));
            int choice = kb.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Product List is as follows:");
                    for(int i=0;i<products.size();i++) 
	{
	System.out.println(products.get(i));
	}
                    System.out.println("\n\n");
                    break;
                case 2:
                    ShoppingBill(map, products_to_take, kb);
                    System.out.println("\n\n");
                    break;
                case 3:
                    System.out.println("Existing");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not found");
                    System.out.println("\n\n");
                    break;
            }
        }
    }

}