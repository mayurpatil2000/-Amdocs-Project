//package com.company;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void ManuDrive(){
//
//        System.out.println("\n");
//        System.out.println("\tPLEASE SELECT AN OPTION BELEOW:");
//        System.out.println("\tPRESS 1 TO DEPOSIT AMOUNT.");
//        System.out.println("\tPRESS 2 TO WITHDRAW AMOUNT.");
//        System.out.println("\tPRESS 3 TO Exit");
//        System.out.println(" ");
//    }
//
//    public static int key(){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println ("ENTER KEY:");
//        int selectedOption = sc.nextInt();
//        return selectedOption;
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println("\n\n Hello Amdocs \n\n");
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("************************************************************** WELLCOME TO ATM ************************************************************");
//
//
//
//        try {
////step1 load the driver class
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
////step2 create  the connection object
//            Connection con = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "admin");
//
//// Check DATABASE Conneted OR NOT
//            if(con != null){
//                System.out.println("Connetd To Database");
//            }else {
//                System.out.println("Not Conneted To Database");
//            }
//
////step3 create the statement object
//            Statement stmt = con.createStatement();
//
//
//            PreparedStatement p = null;
//            ResultSet rs = null;
//
////step4 execute query
//
////            String sql = "select * from  bankaccountholder";
////            p = con.prepareStatement(sql);
////            rs = p.executeQuery();
//
//
////check DataBase values
//            // Condition check
////            while (rs.next()) {
////
////                System.out.println(rs.getInt("acc_id")+" "+rs.getInt("acc_no")+ " " +rs.getString("acc_name")+" "+ rs.getInt("acc_balance"));
////
////            }
////            while(rs.next()) {
////                System.out.println(rs.getString("accno") + "  " + rs.getString("balance") + "  ");
////                System.out.println(rs.getInt("acc_id")+" "+rs.getInt("acc_no")+ " " +rs.getString("acc_name")+" "+ rs.getInt("acc_balance"));
////            }
//
////            System.out.print("\n\t ENTER YOU ACCOUNT NUMBER : ");
////            String str = sc.next();
////            boolean user = false;
//
//            while (rs.next()) {
//                String str = "10008";
//                String compareTo = rs.getString(1);
//                if (str.equals(compareTo)) {
//                    System.out.println("\n\tSUCCESSFULLY LOGIN\n");
//                    System.out.println("\tACCOUNT NUMBER :" + rs.getInt("acc_id") + "\n" + "\tACCOUNT BALANCE :" + rs.getInt("acc_balance") + "  ");
////                    user = true;
//                    break;
//                }
//            }
//
////            if (user == false) {
////                System.out.println("\n \t ACCOUNT NOT FOUND, TRY AGAIN \n");
////            }
////            else {
//
//                ManuDrive();
////            System.out.println ("ENTER KEY:");
////            int selectedOption = sc.nextInt();
//
////                int i=Integer.parseInt(str);
//
//
//                System.out.println(rs.getString("balance").getClass().getSimpleName());
//               int bal = Integer.parseInt(rs.getString("balance"));
//                System.out.println(rs.getString("balance").getClass().getSimpleName());
//                System.out.println(((Object)bal).getClass().getSimpleName());
//
//
//
//                switch (key()) {
//                    case 1:
//                        System.out.print("\n\tENTER THE AMOUNT YOU WANT DEPOSITE : ");
//                        int addamount = sc.nextInt();
//
//                        Statement stmt1 = con.createStatement();
//                        String sql1 = "UPDATE accountholder SET balance = bal+200 WHERE accno = 10002";
//                        stmt1.executeUpdate(sql);
//                        ResultSet Rs = stmt1.executeQuery(sql);
//                        System.out.println("succss");
//
//
//                        System.out.println("\n");
//                        ManuDrive();
//                        key();
//                    case 2:
//                        System.out.print("\n\tENTER THE AMOUNT YOU WANT WITHDRAW : ");
//
//                        System.out.println("\n");
//                        ManuDrive();
//                        key();
//
//
//                    case 3:
//                        System.out.println("SUCCESFULLY EXIT, THANK YOU FOR USING");
//                        System.exit(0);
//
//
//                    default:
//                        System.out.println("Transaction Ended");
//                        System.exit(0);
//
//                }
//
//
////            }
//
////step5 close the connection object
//            con.close();
//
//        }
//        catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
//    }
//}
//
