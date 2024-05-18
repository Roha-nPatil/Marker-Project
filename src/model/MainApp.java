package model;

import dto.MarkerDTO;
import dao.MarkerDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static MarkerDAO dao = new MarkerDAO();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        while (status) {
            System.out.println("*** MARKER PROJECT ***");
            System.out.println("1. ADD MARKER\n2. DISPLAY DETAILS\n3. REMOVE MARKER\n4. UPDATE DETAILS\n5.EXIT");
            System.out.println("-------------------------------");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    addMarker(sc);
                    break;
                case 2:
                    displayDetails();
                    break;
                case 3:
                    removeMarker(sc);
                    break;
                case 4:
                    updateDetails(sc);
                    break;
                case 5:
                    status = false;
                    break;
                default:
                    System.err.println("Invalid Choice...Please select correct option");
            }
        }

    }

    private static void updateDetails(Scanner sc) {
        int mId = 0;
        boolean input = false;

        do {
            try {
                System.out.println("ENTER MARKER ID");
                mId = sc.nextInt();
                input = true;
            }catch (InputMismatchException i){
                System.err.println("Input Mismatch...Please Enter Correct Input.");
                sc.next();
            }
        }while (!input);

        System.out.println("ENTER MARKER COMPANY NAME");
        String mComp = sc.next();

        System.out.println("ENTER MARKER COLOR");
        String mColor = sc.next();

        System.out.println("ENTER MARKER PRICE");
        double mPrice = sc.nextDouble();

        MarkerDTO updateMarker = new MarkerDTO();
        updateMarker.setMarkerCompany(mComp);
        updateMarker.setMarkerColor(mColor);
        updateMarker.setMarkerPrice(mPrice);

        boolean update = dao.updateMarkerById(mId, updateMarker);
        if(update){
            System.out.println("Marker updated SuccessFully...");
        }else{
            System.err.println("Marker "+mId+" is not found...");
        }
    }

    private static void removeMarker(Scanner sc) {
        int mId = 0;
        boolean input = false;

        do {
            try {
                System.out.println("ENTER MARKER ID");
                mId = sc.nextInt();
                input = true;
            }catch (InputMismatchException i){
                System.err.println("Input Mismatch...Please Enter Correct Input.");
                sc.next();
            }
        }while (!input);

        boolean remove = dao.removeMarkerById(mId);
        if(remove){
            System.out.println("Marker Removed SuccessFully...");
        }else{
            System.err.println("Marker "+mId+" is not found...");
        }
    }

    private static void displayDetails() {
        System.out.println("ID\tMarker Company\tColor\tPrice");
        List<MarkerDTO> list = dao.displayMarkerList();
        if(!list.isEmpty()){
            for(MarkerDTO marker : list){
                System.out.println(marker.getMarkerId() + "\t" + marker.getMarkerCompany() + "\t" + marker.getMarkerColor() + "\t" + marker.getMarkerPrice());
            }
        } else {
            System.err.println("NO DATA FOUND...");
        }
    }

    private static void addMarker(Scanner sc) {
        int mId = 0;
        boolean input = false;

        do {
            try {
                System.out.println("ENTER MARKER ID");
                mId = sc.nextInt();
                input = true;
            }catch (InputMismatchException i){
                System.err.println("Input Mismatch...Please Enter Correct Input.");
                sc.next();
            }
        }while (!input);

        System.out.println("ENTER MARKER COMPANY NAME");
        String mComp = sc.next();

        System.out.println("ENTER MARKER COLOR");
        String mColor = sc.next();

        System.out.println("ENTER MARKER PRICE");
        double mPrice = sc.nextDouble();

        MarkerDTO dto = new MarkerDTO();
        dto.setMarkerId(mId);
        dto.setMarkerCompany(mComp);
        dto.setMarkerColor(mColor);
        dto.setMarkerPrice(mPrice);

        int count = dao.addMarkerDetails(dto);
        if(count != 0){
            System.out.println("MARKER ADDED SUCCESSFULLY..."+count);
        } else {
            System.err.println("MARKER IS NOT ADDED..."+count);
        }
    }

}
