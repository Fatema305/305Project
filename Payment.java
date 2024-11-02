import java.util.Scanner;
//The class and methods of Presentation layer 
//Presentation layer (interation to user) To choose the method "Credit Card , Debit Card ,and Benefit Pay " to Payment 
class Hotel  {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Payment.PaymentService paymentService = new Payment.PaymentService();
        System.out.print("\nPlease enter the total amount to pay on (BD) = ");
        double Totalamount = kbd.nextDouble();
        System.out.println("Please choose you option to pay:");
        System.out.println("1. Credit Card ");
        System.out.println("2. Debit card ");
        System.out.println("3. Benefit Pay ");
        System.out.print("The option is : ");
        int option = kbd.nextInt();
        String Method;
        switch (option) {
            case 1:
                Method = " Credit Card ";
                break;
            case 2:
                Method = " Debit Card ";
                break;
            case 3:
                Method = " Benefit Pay ";
                break;
            default:
                System.out.println("Your choice not found , please try again ");
                kbd.close();
                return;
        }
     //The method to check payment process methods 
        boolean correct = paymentService.processPayment(Method, Totalamount);
        if (correct) {
            System.out.println("The process was successfull ! ");
        } else {
            System.out.println("The process not successfull , please try again ");
        } kbd.close();}}
//The class and methods of business layer
//The business layer calling methods here from data layer
public class Payment {
    static class PaymentService {
        private PaymentStore payment;
        //On the payment service method we are storing 
        public PaymentService() {
            this.payment = new PaymentStore();
        }
        //constructor with 2 parameter to keeping payment process 
        public boolean processPayment(String method, double Tamount) {
            return payment.keepPay(method, Tamount);}

//The class and methods of Data layer 
//The Data layer Store the payment data and check it if have any failure

        class PaymentStore {
            //Constructors with parameters 
            public boolean keepPay(String method, double Tamount) {
                System.out.println("Method of pay is "+ method +" and the total amount= "+Tamount+" BD");
                return true;
}}  }}
      
    

