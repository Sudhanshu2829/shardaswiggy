package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class App {
    User user;
    Dish[] dishList=new Dish[15];
    Restro[] restroList=new Restro[5];

    Location[] locationList=new Location[15];

    //Constructor for defining the name of the User and its geographical Location
    App()
    {
        Location userLocation = new Location("000",50,67);
        this.user = new User("Sudhanshu Kumar",userLocation);
    }

    public User getUser() {
        return user;
    }

    public void parseRestroData() throws IOException{
        BufferedReader restroData=Files.newBufferedReader(Paths.get("C:\\Users\\sudhanshu\\IdeaProjects\\shardaswiggy\\data\\restro.csv"));
        String lines=null;
        for(int restcnt=0;(lines=restroData.readLine())!=null;restcnt++){
            String[] data=lines.split(",");
            restroList[restcnt]=new Restro(data[0],data[1],data[2]);
            Dish[] tempMenu=new Dish[3];
            Location tempLocation=null;
            for(int menucnt=0,localcnt=0;(menucnt< dishList.length)&&(dishList[menucnt]!=null);menucnt++){
                if(dishList[menucnt].getRestroID().equals(data[0])) {
                    tempMenu[localcnt] = dishList[menucnt];
                    localcnt++;
                }
            }
            restroList[restcnt].setMenu(tempMenu);

            for(int locationcnt=0;(locationcnt<locationList.length)&&(locationList[locationcnt]!=null);locationcnt++){
                if(locationList[locationcnt].getRestroID().equals(data[0])){
                    tempLocation=locationList[locationcnt];
                }
            }
            restroList[restcnt].setLocation(tempLocation);
        }

    }
    public void parseDishData() throws IOException{
        BufferedReader dishData=Files.newBufferedReader(Paths.get("C:\\Users\\sudhanshu\\IdeaProjects\\shardaswiggy\\data\\dish.csv"));
        String lines=null;
        for(int dishcnt=0;(lines=dishData.readLine())!=null;dishcnt++){
            String[] data = lines.split(",");
            dishList[dishcnt]=new Dish(data[0],data[1],data[2],Integer.valueOf(data[3]));
        }

    }
    public void parseLocationData() throws IOException{
        BufferedReader locationData=Files.newBufferedReader(Paths.get("C:\\Users\\sudhanshu\\IdeaProjects\\shardaswiggy\\data\\location.csv"));
        String lines=null;
        for(int locationcnt=0;(lines=locationData.readLine())!=null;locationcnt++){
            String[] data = lines.split(",");
            locationList[locationcnt]=new Location(data[0],Float.valueOf(data[1]),Float.valueOf(data[2]));
        }
    }

    public double deliveryTime(Location userLocation, Location restroLocation){
        final double speed=10;
        double diff=Math.abs(Math.pow((restroLocation.getLatitude()-userLocation.getLatitude()),2))+Math.abs(Math.pow((restroLocation.getLongitude()-userLocation.getLongitude()),2));
        double ans=Math.sqrt(diff);
        return ans;
    }

//    public void createOrder(Restro[] restroList){
//        if(restroList==null){
//            restroList=this.restroList;
//        }
//
//        System.out.println("******************************************");
//        System.out.println("Select your Restaurant and order dishes from it in the format | RestroID, DishID1, Qty1, DishID2, Qty2.....");
//        Scanner sc=new Scanner(System.in);
//        String orderInput=sc.next();
//        String[] orderInputData=orderInput.split(",");
//        String restroID=orderInputData[0];
//        int orderListlength=(orderInputData.length-1)/2;
//        Invoice[] orderList=new Invoice[orderListlength];
//        int bill=0;
//
//
//
//
//        for(int ordercnt=1,orderlistcnt=0;ordercnt<orderInputData.length;ordercnt++){
//            Dish[] temp=res
//        }
//
//    }

//    if(restroList == null)
//    {
//        restroList = this.restroList;
//    }
//
//
//        System.out.println("****************************************");
//        System.out.println("Please choose the Restro and Dishes in this format | RestroId,DishId1,Qty1,DishId2,Qty2...");
//
//    Scanner orderInput = new Scanner(System.in);
//    String orderInputString = orderInput.next();
//
//    String[] orderInputData = orderInputString.split(",");
//    String restroId = orderInputData[0];
//    List<OrderElement> orderList = new ArrayList<>();
//    int orderAmnt = 0;
//
//        System.out.println(restroList.get((Integer.valueOf(restroId)-1)).getRestroname());
//
//        if(Integer.valueOf(restroId) > 9)
//    {
//        throw new RuntimeException();
//    }
//
//        try
//    {
//        for (int orderCntr = 1, ordrListCntr = 0; orderCntr < orderInputData.length; orderCntr++)
//        {
//            String dishId = restroList.get((Integer.valueOf(restroId) - 1)).getMenu().get((Integer.valueOf(orderInputData[orderCntr]) - 1)).getDishId();
//            String dishName = restroList.get((Integer.valueOf(restroId) - 1)).getMenu().get((Integer.valueOf(orderInputData[orderCntr]) - 1)).getDishName();
//            Dish tempDish = restroList.get((Integer.valueOf(restroId) - 1)).getMenu().get((Integer.valueOf(orderInputData[orderCntr]) - 1));
//            int dishPrice = restroList.get((Integer.valueOf(restroId) - 1)).getMenu().get((Integer.valueOf(orderInputData[orderCntr]) - 1)).getPrice();
//            int dishQty = Integer.valueOf(orderInputData[++orderCntr]);
//
//            orderAmnt += dishPrice*dishQty;
//
//            System.out.println((ordrListCntr+1)+". "+dishName+" Qty: "+dishQty);
//
//            orderList.add(ordrListCntr,new OrderElement(tempDish, dishQty));
//            ordrListCntr++;
//        }
//
//
//    }catch(RuntimeException e)
//    {
//        System.out.println("An exception Occurred :"+e.getMessage()+" "+e.getStackTrace());
//        System.out.println("Do you want to send an error report to our developers on Moon");
//    }
//
//    Order order = new Order("001",this.customer.getUsername(),restroId);
//        orderList.forEach(order::setOrderElement);
//
//
//        System.out.println("****************************************");
//        System.out.println("Make the Payment of INR "+orderAmnt+"? 1 - YES | 2 - NO");
//    Scanner pymntInput = new Scanner(System.in);
//    int pymntInputInt =  pymntInput.nextInt();
//
//        if( pymntInputInt == 1)
//    {
//        while(!makePayment(orderAmnt))
//        {
//            rechargeWallet(orderAmnt);
//        }
//
//        deliverOrder(order);
//    }
//        else
//    {
//        throw new AbortOrderException("payment");
//    }
//}

    public void browse() throws NullPointerException {
        System.out.println("**********************************************************************");
        System.out.println("Please choose Dishes from the Following Menu");

        int restrocount=1;
        int dishcount=1;

        for(Restro r:restroList){
            System.out.println("**********************************************************************");
            Dish[] tempMenu=r.getMenu();
            System.out.println(restrocount + ": "+ r.getRestroName() + "Location: "+ r.getRestroAddress()+"\tExpected Delivery Time: " + (int)deliveryTime(this.user.getLocation(),r.getLocation())+" mins");
            for(Dish d:tempMenu){
                System.out.println("\t" + restrocount + "." + dishcount + " " + d.getDishName()+ " "+d.getPrice());
                dishcount++;
            }
            dishcount=1;
            restrocount++;
        }

        //createOrder(null);

    }

    public static void main(String []args) throws IOException, InvalidPathException {
        App swiggyApp=new App();
        swiggyApp.parseLocationData();
        swiggyApp.parseDishData();
        swiggyApp.parseRestroData();
        System.out.println("**********************************************************************");
        System.out.println("Hey " +swiggyApp.getUser().getUserName()+" Welcome to our Swiggy App ");
        System.out.println("How would you like to Order ? 1 - From the Menu "); //| 2 - Search for Dish"
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if(choice==1){
            swiggyApp.browse();
        }
        else if(choice==2){

        }
        else{
            System.out.println("Invalid Input");
        }

    }
}

