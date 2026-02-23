package hospitalsys;

import java.util.Scanner;

public class Hospitalsys {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 4) {
            System.out.println("====== Laboratory System ======\n");
            System.out.println("Please select the test category:");
            System.out.println("1- Blood Test");
            System.out.println("2- General Test");
            System.out.println("3- suger Test");
            System.out.println("4- Exit");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();

            if (choice == 4) {
                System.out.println("GoodBye!");
                break;
            }

            if (choice >= 1 && choice <= 3) {
                String testName = "None";
                int finalPrice = 0;
                double discount = 0;

                input.nextLine();
                System.out.println("=== Patient Personal Information ===");

                String Pname;
                System.out.print("Patient's name: ");
                Pname = input.nextLine();
                while (!Pname.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid input!, Letters only.");
                    System.out.print("Patient's name: ");
                    Pname = input.nextLine();
                }

                int age = -1;
                while (age < 0) {
                    System.out.print("Patient's age: ");
                    age = input.nextInt();
                }

                char gender = ' ';
                while (gender != 'a' && gender != 'b' && gender != 'A' && gender != 'B') {
                    System.out.println("Patient's Gender:\nA. Male \nB. Female");
                    gender = input.next().charAt(0);
                }

                long phone = -1;
                while (phone < 0) {
                    System.out.print("Patient's phone number: ");
                    phone = input.nextLong();
                }

                String blood = "";
                while (true) {
                    System.out.print("Blood Type: ");
                    blood = input.next();

                    if (blood.equals("A+") || blood.equals("A-") || blood.equals("B+") || blood.equals("B-")
                            || blood.equals("AB+") || blood.equals("AB-") || blood.equals("O+") || blood.equals("O-")
                            || blood.equals("a+") || blood.equals("a-") || blood.equals("b+") || blood.equals("b-")
                            || blood.equals("ab+") || blood.equals("ab-") || blood.equals("o+") || blood.equals("o-")) {
                        break;
                    }
                    System.out.println("Invalid Blood Type! Please try again.");
                }

                switch (choice) {
                    case 1: //blood test
                        System.out.println("\n--- Blood Test Menu ---");
                        System.out.println("1- CBC (Complete Blood Count)");
                        System.out.println("2- Cholesterol Test");
                        System.out.print("Select test type: ");
                        int bloodSub = input.nextInt();

                        if (bloodSub == 1) {
                            testName = "CBC (Complete Blood Count)";
                            finalPrice = 15000;
                        } else if (bloodSub == 2) {
                            testName = "Cholesterol Test";
                            finalPrice = 10000;
                        }
                        break;

                    case 2://General test
                        System.out.println("\n--- General Test Menu ---");
                        System.out.println("1- KFT (Kidney Function Test)");
                        System.out.println("2- LFT (Liver Function Test)");
                        System.out.print("Select test type: ");
                        int generalSub = input.nextInt();

                        if (generalSub == 1) {
                            testName = "KFT (Kidney Function Test)";
                            finalPrice = 20000;
                        } else if (generalSub == 2) {
                            testName = "LFT (Liver Function Test)";
                            finalPrice = 25000;
                        }
                        break;

                    case 3:// suger test
                        System.out.println("\n---Suger test ---");
                        System.out.println("1-FBS (Fasting Blood Suger)");
                        System.out.println("2- RBS (Random Blood Suger)");
                        System.out.print("Select test type: ");
                        int otherSub = input.nextInt();

                        if (otherSub == 1) {
                            testName = "FBS (Fasting Blood Suger)";
                            finalPrice = 4000;
                        } else if (otherSub == 2) {
                            testName = " RBS (Random Blood Suger)";
                            finalPrice = 8000;
                        }
                        break;
                }

                if (age >= 60) {
                    discount = finalPrice * 0.20;
                } else if (age <= 10) {
                    discount = finalPrice * 0.15;
                }

                double totalPrice = finalPrice - discount;

                System.out.println("\n========================================");
                System.out.println("            OFFICIAL RECEIPT            ");
                System.out.println("========================================");
                System.out.println("Patient Name : " + Pname);
                System.out.println("Patient Age  : " + age);
                System.out.println("Blood Type   : " + blood);
                System.out.println("----------------------------------------");
                System.out.println("Selected Test: " + testName);
                System.out.println("Original Price: " + finalPrice + " IQD");
                System.out.println("Discount     : " + discount + " IQD");
                System.out.println("Total Price  : " + totalPrice + " IQD");
                System.out.println("----------------------------------------");
            }
        }
    }
}
