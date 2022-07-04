package com.company;

import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class Bank {

        public static void ManuDrive(){
        System.out.println("\n");
        System.out.println("\tPLEASE SELECT AN OPTION BELEOW :: ");
        System.out.println("\tPRESS 1 TO DEPOSIT AMOUNT.");
        System.out.println("\tPRESS 2 TO WITHDRAW AMOUNT.");
        System.out.println("\tPRESS 3 TO Exit");
        System.out.println(" ");
    }

    public static int key(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\tENTER KEY FOR SELECT AN OPTION :");
        int selectedOption = sc.nextInt();
        return selectedOption;
    }


    public static void main(String[] args) throws ClassNotFoundException {

//        System.out.println("\n\n Hello Amdocs \n\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("\n******************************************************************************* WELLCOME TO ATM ********************************************************************************");

        try {
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "admin");

// Check DATABASE Conneted OR NOT
            if (con != null) {
//                System.out.println("Connetd To Database");
            } else {
                System.out.println("Not Conneted To Database");
            }

//step3 create the statement object
            Statement stmt=con.createStatement();
            PreparedStatement p = null;
            ResultSet rs = null;

//step4 execute query
            String sql1 = "select * from bankaccountholder";
            p = con.prepareStatement(sql1);
            rs = p.executeQuery();

//CHECKING ALL RECORD IN DATABASE
//            while(rs.next()) {
//                System.out.println(rs.getString("acc_id") + " \t " +rs.getString("acc_no") +"  \t" +rs.getString("acc_name")+"  \t"+rs.getString("acc_balance") +"  \t");
//                System.out.println(rs.getInt("acc_id") + " \t " +rs.getInt("acc_no") +"  \t" +rs.getString("acc_name")+"  \t"+rs.getInt("acc_balance") +"  \t");
//            }
            System.out.print("\n\t ENTER YOU ACCOUNT NUMBER : ");
             int User_Account_Number = sc.nextInt();
              boolean user = false;

            while(rs.next()) {
                //CONVERTING INT ACCOUNT NUMBER TO STRING
                String User_Account_Number_String = String.valueOf(User_Account_Number);
                String compareTo = rs.getString("acc_no") ;
                if (User_Account_Number_String.equals(compareTo)) {
                    System.out.println("\n\t ACCOUNT LOGIN SUCCESFULLY!! ");
//                  SHOWING RECORD OF USER LOGIN ACCOUNT
                    System.out.println("\n\t AccountID : "+rs.getInt("acc_id") + "\n\t AccountNumber : " +rs.getInt("acc_no") +"\n\t AccountName : " +rs.getString("acc_name")+"\n\t AccountBalance : "+rs.getInt("acc_balance") +"\t");
                    user =true;
                    break;
                }
            }
            if (user==false){
                System.out.println("\n\t ACCOUNT NOT FOUND, PLEASE ENTER VALID ACCOUNT NUMBER ");
            }
            else {
                ManuDrive();
                switch (key()) {
                    case 1:
                        System.out.print("\n\t ENTER THE AMOUNT YOU WANT DEPOSITE : ");
                        int amt = sc.nextInt();
                         amt = amt + rs.getInt("acc_balance");
                         System.out.println("\n\t BALANCE AFTER DEPOSITE AMOUNT : "+amt);

                         String SQL_UPDATE = "UPDATE bankaccountholder SET acc_balance = ?  WHERE acc_no = ? ";
                         PreparedStatement preparedStatement = con.prepareStatement(SQL_UPDATE);
                        preparedStatement.setInt(1, amt);
                        preparedStatement.setInt(2, User_Account_Number);
                       preparedStatement.executeUpdate();

//                        System.out.println("\n\t AccountID : "+rs.getInt("acc_id") + "\n\t AccountNumber : " +rs.getInt("acc_no") +"\n\t AccountNAme : " +rs.getString("acc_name")+"\n\t AccountBalance : "+rs.getInt("acc_balance") +"  \t");

                        System.out.println("\n");
                        System.out.println("SUCCESFULLY EXIT, THANK YOU FOR USING");
                        break;

                    case 2:
                        System.out.print("\n\t ENTER THE AMOUNT YOU WANT WITHDRAW : ");
                        int withdrawamt = sc.nextInt();

                        if (rs.getInt("acc_balance")<=withdrawamt){
                            System.out.println("\n\t YOUR ACCOUNT BALANCE IS LOW THAN YOUR WITHDRAW AMOUNT ");
                        }
                        else {
                            withdrawamt = rs.getInt("acc_balance") - withdrawamt;
                            System.out.println("BALANCE AFTER WITHDRAW  AMOUNT : " + withdrawamt);

                            String SQL_UPDATE1 = "UPDATE bankaccountholder SET acc_balance = ?  WHERE acc_no = ? ";
                            PreparedStatement preparedStatement1 = con.prepareStatement(SQL_UPDATE1);
                            preparedStatement1.setInt(1, withdrawamt);
                            preparedStatement1.setInt(2, User_Account_Number);
                            preparedStatement1.executeUpdate();

//                        System.out.println("\n\t AccountID : "+rs.getInt("acc_id") + "\n\t AccountNumber : " +rs.getInt("acc_no") +"\n\t AccountNAme : " +rs.getString("acc_name")+"\n\t AccountBalance : "+rs.getInt("acc_balance") +"  \t");

                            System.out.println("\n");
                            System.out.println("SUCCESFULLY EXIT, THANK YOU FOR USING");
                            break;
                        }
                    case 3:
                        System.out.println("SUCCESFULLY EXIT, THANK YOU FOR USING");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\n\t TRANSACTION ENDED");
                        System.exit(0);
                }
//                System.out.println("\n\t AccountID : "+rs.getInt("acc_id") + "\n\t AccountNumber : " +rs.getInt("acc_no") +"\n\t AccountNAme : " +rs.getString("acc_name")+"\n\t AccountBalance : "+rs.getInt("acc_balance") +"  \t");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
