
// package mini_projects;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Recharge {
    static final String red = "\u001b[00;1m";
    static Cvpay a1 = new Cvpay();
    static Recharge a2 = new Recharge();

    public static void main(String[] args) {
        System.out.println("     \u001b[00;1m-->  WELcome to Cv Pay <--      ");
        System.out.println("         -------------------");
        a2.Login();
    }

    void Login() {
        System.out.print("  1.Login\n  2.Close application");
        int n = a1.sc.nextInt();
        if (n == 1) {
            a2.Display();
        } else if (n == 2) {
            a1.closeAppli();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
            Login();
        }
    }

    void Display() {
        System.out.println("\n  Enter Your 4 Digits Mpin to continue\n");
        int mpin = Cvpay.sc.nextInt();
        a1.Cvpay(mpin);
    }
}

class Cvpay {
    static Scanner sc = new Scanner(System.in);
    private int mpin = 1234;
    static double Balance = 500;

    void Cvpay(int mpin) {
        if (mpin == this.mpin) {
            home();
        } else {
            System.out.println("\n  \u001b[31;1mIncorrect MPIN\u001b[00;1m\n");
            eMpin();
        }
    }

    void eMpin() {
        System.out.println("  1.Try Again\n  2.Forgot Mpin");
        int n = sc.nextInt();
        if (n == 1) {
            new Recharge().Display();
        } else if (n == 2) {
            forgot();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\n\u001b[00;1m");
            eMpin();
        }
    }

    void forgot() {

        System.out.println("  \nEnter Mobile number\n");
        String ph = sc.next();
        if (ph.equalsIgnoreCase("8186899829")) {
            System.out.println("  \nEnter new Mpin\n");
            int mpin = sc.nextInt();
            if (mpin <= 9999 && mpin > 999) {
                setMpin(mpin);
            } else {
                System.out.println("\n  \u001b[31;1mMPIN must be 4 DIGITS \n\u001b[00;1m");
                forgot();
            }
        } else {
            System.out.println("  \u001b[91;1mInvalid Mobile number\u001b[00;1m\n");
            tryAgain();
        }
    }

    void tryAgain() {
        System.out.println("  1.Tryagain\n  2.Close Application");
        int n = sc.nextInt();
        if (n == 1) {
            forgot();
        } else if (n == 2) {
            closeAppli();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
            tryAgain();
        }
    }

    void closeAppli() {
        System.out.println("\n  \u001b[31;1mDo You really want to Exit\u001b[00;1m");
        System.out.println("  \n      \u001b[97;102;1m OK \u001b[00;1m      \u001b[97;101;1m CANCEL \u001b[00;1m\n   ");
        String n = sc.next();
        if (n.equalsIgnoreCase("ok")) {

        } else if (n.equalsIgnoreCase("cancel")) {
            Recharge.a2.Login();
        } else {
            System.out.println("\n  \u001b[31;1mChoose Correct\n");
            closeAppli();
        }
    }

    void setMpin(int mpin) {
        this.mpin = mpin;
        System.out.println("  \u001b[32;1m Your MPIN is Changed Succesfully \u001b[00;1m Redirected to log in page\n");
        Recharge.a2.Display();
    }

    void home() {
        System.out.println("\n  \u001b[37;40;1mYour current Wallet Balance is --> " + Balance + "\u001b[39;49;1m\n");
        System.out.println(
                "  Choose an Option\n\n  1.Recharge\n  2.Add Money\n  3.Home\n  4.Profile\n  5.More\n  6.Reports\n  7.Log Out");
        int n = sc.nextInt();
        if (n == 1) {
            new Rech().Recharge();
        } else if (n == 2) {
            new Addmoney().Wallet();
        } else if (n == 3) {
            home();
        } else if (n == 4) {
            Profile.Display();
        } else if (n == 5) {
            More.Mobile_Tollfree();
        } else if (n == 6) {
            new Reports().Display();
        } else if (n == 7) {
            System.out.println("\n  \u001b[32;1mSuccessfully Loged out \u001b[00;1m\n ");
            Recharge.a2.Login();
        } else {
            System.out.println("  \u001b[31;1m Select correct option \u001b[00;1m");
            home();
        }
    }
}

class Rech {

    void Recharge() {
        {
            System.out.println(
                    "\n  \u001b[31;1mNote: Mobile number should not start with 0 and it contain 10 digits\u001b[00;1m \n\n  Enter Mobile Number\n\n");
        }
        String ph = Cvpay.sc.next();
        if (ph.charAt(0) == '0') {
            Recharge();
        } else if (ph.length() == 10) {
            operator(ph);
        } else {
            Recharge();
        }
    }

    void operator(String ph) {
        System.out.println("  1.Airtel\n  2.Jio\n  3.Vi\n  4.Home");
        int a = Cvpay.sc.nextInt();
        switch (a) {
            case 1:
                new Airtel().airtel(ph);
                break;
            case 2:
                new Jio().jio(ph);
                break;
            case 3:
                new Vi().vi(ph);
                break;
            case 4:
                Recharge.a1.home();
                break;
            default:
                System.out.println("  \u001b[31;1mChoose correct option\u001b[00;1m \n");
                operator(ph);
        }
    }
}

class Airtel {
    void airtel(String ph) {
        System.out.println("  1.View Offers\n  2.Browse Plans \n  3.change number\n  4.Change Operator");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            offers(ph);
        } else if (n == 2) {
            plans(ph);
        } else if (n == 3) {
            new Rech().Recharge();
        } else if (n == 4) {
            new Rech().operator(ph);
        } else {
            System.out.println("  \u001b[31;1mInvalid Inputs Please try agian\n\n\u001b[00;1m");
            airtel(ph);
        }
    }

    void offers(String ph) {
        if (ph.equalsIgnoreCase("8186899829")) {
            select(ph);
        } else {
            System.out.println("  Do not have any offers on this number\n\n  Press 1 to go back");
            int n = Cvpay.sc.nextInt();
            if (n == 1) {
                airtel(ph);
            } else {
                System.out.println("  \u001b[31;1mEnter Valid Input \n\u001b[00;1m");
                offers(ph);
            }
        }

    }

    void select(String ph) {
        System.out.println(
                "  1.U/L calls and 1.5gb per/day data one month with hotstar subscription 3month at       399 rs \n");
        System.out.println(
                "  2.U/L calls and 1.5gb per/day data two months with hotstar subscription 3month at      499 rs \n");
        System.out.println(
                "  3.U/L calls and 1.5gb per/day data tree months with hotstar subscription 3month at     599 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 399, "Airtel");
        } else if (n == 2) {
            Conform.confirmation(ph, 499, "Airtel");
        } else if (n == 3) {
            Conform.confirmation(ph, 599, "Airtel");
        } else if (n == 4) {
            airtel(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            select(ph);
        }
    }

    void plans(String ph) {
        System.out.println("  1.U/L calls and 1.5gb per/day data 1month at     199 rs \n");
        System.out.println("  2.U/L calls and 2gb per/day data 2months at      399 rs \n");
        System.out.println("  3.U/L calls and 3gb per/day data  3months at     666 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 199, "Airtel");
        } else if (n == 2) {
            Conform.confirmation(ph, 399, "Airtel");
        } else if (n == 3) {
            Conform.confirmation(ph, 666, "Airtel");
        } else if (n == 4) {
            airtel(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            plans(ph);
        }

    }
}

class Vi {
    void vi(String ph) {
        System.out.println("  1.View Offers\n  2.Browse Plans \n  3.to change number");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            offers(ph);
        } else if (n == 2) {
            plans(ph);
        } else if (n == 3) {
            new Rech().Recharge();
        } else {
            System.out.println("  \u001b[31;1mInvalid Inputs Please try agian\n\n\u001b[00;1m");
            vi(ph);
        }

    }

    void offers(String ph) {
        if (ph.equalsIgnoreCase("6303441694")) {
            select(ph);
        } else {
            System.out.println("  Do not have any offers on this number\n\n  Press 1 to go back");
            int n = Cvpay.sc.nextInt();
            if (n == 1) {
                vi(ph);
            } else {
                System.out.println("  \u001b[31;1mEnter Valid Input \n\u001b[00;1m");
                offers(ph);
            }
        }

    }

    void select(String ph) {
        System.out.println(
                "  1.U/L calls and 1.5gb per/day data one month with vi movies and TV subscription 3month at       319 rs \n");
        System.out.println(
                "  2.U/L calls and 3gb per/day data two months with disney+hotstar subscription 1months at      499 rs \n");
        System.out.println(
                "  3.U/L calls and 1.5gb per/day data tree months with disney+hotstar subscription 3months at     1099 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 319, "VI");
        } else if (n == 2) {
            Conform.confirmation(ph, 499, "VI");
        } else if (n == 3) {
            Conform.confirmation(ph, 1099, "VI");
        } else if (n == 4) {
            vi(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            select(ph);
        }

    }

    void plans(String ph) {
        System.out.println("  1.U/L calls and 1.5gb per/day data 1month at     129 rs \n");
        System.out.println("  2.U/L calls and 2gb per/day data 2months at      299 rs \n");
        System.out.println("  3.U/L calls and 3gb per/day data  3months at     599 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 129, "VI");
        } else if (n == 2) {
            Conform.confirmation(ph, 299, "VI");
        } else if (n == 3) {
            Conform.confirmation(ph, 599, "VI");
        } else if (n == 4) {
            vi(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            plans(ph);
        }
    }
}

class Jio {
    void jio(String ph) {
        System.out.println("  1.View Offers\n  2.Browse Plans \n  3.to change number");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            offers(ph);
        } else if (n == 2) {
            plans(ph);
        } else if (n == 3) {
            new Rech().Recharge();
        } else {
            System.out.println("  \u001b[31;1mInvalid Inputs Please try agian\n\n\u001b[00;1m");
            jio(ph);
        }
    }

    void offers(String ph) {
        if (ph.equalsIgnoreCase("7780508582")) {
            select(ph);
        } else {
            System.out.println("  Do not have any offers on this number\n\n  Press 1 to go back");
            int n = Cvpay.sc.nextInt();
            if (n == 1) {
                jio(ph);
            } else {
                System.out.println("  \u001b[31;1mEnter Valid Input \n\u001b[00;1m");
                offers(ph);
            }
        }

    }

    void select(String ph) {
        System.out.println(
                "  1.U/L calls and 2.5gb per/day data two months with amazon subscription 3month at       499 rs \n");
        System.out.println(
                "  2.U/L calls and 2.0gb per/day data three months with starsports subscription 3month at      399 rs \n");
        System.out.println(
                "  3.U/L calls and 2.25gb per/day data tree months with hotstar subscription 3month at     599 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 499, "JIO");
        } else if (n == 2) {
            Conform.confirmation(ph, 399, "JIO");
        } else if (n == 3) {
            Conform.confirmation(ph, 599, "JIO");
        } else if (n == 4) {
            jio(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            select(ph);
        }

    }

    void plans(String ph) {
        System.out.println("  1.U/L calls and 1.5gb data  at 25 rs \n");
        System.out.println("  2.U/L calls and 2.5gb data at 35rs \n");
        System.out.println("  3.U/L calls and 3.5gb data at 45 rs \n");
        System.out.println("  4.Go Back");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Conform.confirmation(ph, 25, "JIO");
        } else if (n == 2) {
            Conform.confirmation(ph, 35, "JIO");
        } else if (n == 3) {
            Conform.confirmation(ph, 45, "JIO");
        } else if (n == 4) {
            jio(ph);
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
            select(ph);
        }
    }
}

class More {
    static void Mobile_Tollfree() {
        System.out.println("      _______________________________");
        System.out.println("      | \u001b[31;1mMobile_TollFree Numbers \u001b[00;1m    |");
        System.out.println("      |                             |");
        System.out.println("      |      Airtel   - 198         |");
        System.out.println("      |      BSNL     - 1503        |");
        System.out.println("      |      Docomo   - 121         |");
        System.out.println("      |      Idea     - 122         |");
        System.out.println("      |      Jio      - 1991        |");
        System.out.println("      |      Vodafone - 1992        |");
        System.out.println("      |_____________________________|");
        new More().next();
    }

    void next() {
        System.out.println("  1.Home");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Recharge.a1.home();
        } else {
            System.out.println("  \u001b[31;1mInvalid Input\u001b[00;1m");
            Mobile_Tollfree();
        }

    }
}

class Profile {
    static void Display() {
        System.out.println("          ____________________________________________");
        System.out.println("          |User Name    : Cv_Pay                    |");
        System.out.println("          |Outlet Name  : Shop Name                  |");
        System.out.println("          |Mobile No    : 6303441694                 |");
        System.out.println("          |Email id     : Cv_pay@gmail.com          |");
        System.out.println("          |Role         : Retailer                   |");
        System.out.println("          |Address      : Indira nagar,Hyderabad     |");
        System.out.println("          |Pincode      : 500055                     |");
        System.out.println("          |State        : Telangana                  |");
        System.out.println("          |City         : Hyderabad                  |");
        System.out.println("          |__________________________________________|");
        new Profile().next();
    }

    void next() {
        System.out.println("\n\n  1.Home\n");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\n\n\u001b[00;1m");
            Display();
        }

    }
}

class Addmoney {

    static void Wallet() {
        System.out.println("   _________________________________________________");
        System.out.println("   |\u001b[37;40;1m                                                ");
        System.out.println("\u001b[00;1m   |   Your Prepaid Wallet Balance is --> " + Cvpay.Balance + "     ");
        System.out.println("   |\u001b[37;40;1m________________________________________________");
        System.out.println("\u001b[00;1m\n  1.Enter amount \n  2.Home");
        int n = Recharge.a1.sc.nextInt();
        if (n == 1) {
            Amount();
        } else if (n == 2) {
            Recharge.a1.home();
        } else {
            System.out.println("  \u001b[31;1mInvalid Input\n\u001b[00;1m");
            Wallet();
        }

    }

    static void Amount() {
        System.out.println("\n  \u001b[36;1mAdd Money Min:100 - Max: 10000\n\u001b[00;1m");

        System.out.println("\n      \u001b[31;1mEnter Amount\u001b[00;1m \n");
        double n = Recharge.a1.sc.nextInt();
        if (n <= 10000 && n >= 100) {
            payment(n);
        } else {
            System.out.println("\n  \u001b[31;1mAmount Range must be in 100 - 10000\n\u001b[00;1m\n");
            Amount();
        }
    }

    static void payment(double n) {
        System.out.println(
                "  Choose Payment option\n\n  1.\033[1;35mPhonepe\u001b[00;1m\n  2.\u001b[91;1mG\u001b[33;196mP\u001b[92;1mA\u001b[34;1mY\u001b[00;1m\n  3.\u001b[36;1mPaytm\u001b[00;1m\n  4.\u001b[31;1mCancel Payment\u001b[00;1m");
        int a = Recharge.a1.sc.nextInt();
        if (a == 1) {
            phonePe(n);
        } else if (a == 2) {
            gPay(n);
        } else if (a == 3) {
            payTm(n);
        } else if (a == 4) {
            System.out.println("\n  \u001b[31;1mYour Payment was cancelled\n\u001b[00;1m");
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input \u001b[00;1m");
            payment(n);
        }
    }

    static void payTm(double n) {
        System.out.println("\n     \u001b[36;1mPAYTM\u001b[00;1m\n");
        System.out.println(
                "\n   \u001b[91;1mCuurently We are facing an issue choose another Payment option\n\u001b[00;1m");
        payment(n);
    }

    static void gPay(double n) {
        System.out.println("\n     \u001b[91;1mG\u001b[33;196mP\u001b[92;1mA\u001b[34;1mY\u001b[90;1m");
        System.out.println(
                "\n   \u001b[91;1mCuurently We are facing an issue choose another Payment option\n\u001b[00;1m");
        payment(n);
    }

    static void phonePe(double n) {
        System.out.println("\n      \033[1;35mPHONEPE\033[1;00m\n");
        System.out.println("  Payment to Cv_pay is  " + n);
        System.out.println(
                "\n  Select Bank\n  1.\u001b[91;1munion \u001b[94;1mBank\n\u001b[00;1m  2.\u001b[94;1mSBI\u001b[00;1m \n  3.\u001b[31;1mCancel Payment\u001b[00;1m");
        int a = Recharge.a1.sc.nextInt();
        if (a == 1) {
            Union.unionBank(n);
        } else if (a == 2) {
            Sbi.sbi(n);
        } else if (a == 3) {
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\n\u001b[00;1m");
            phonePe(n);
        }
    }
}

class Union {
    static int c = 0, c1 = 3;
    static Union u1 = new Union();
    private int mpin = 123456;
    private int card = 9968;
    static double Balance = 12000;

    static void unionBank(double n) {
        if (c < c1) {
            System.out.println("\n  1.CheckBalance\n  2.go to payment\n  3.Go Back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                u1.checkBal(n);
            } else if (a == 2) {
                u1.payment(n);
            } else if (a == 3) {
                Addmoney.phonePe(n);
            } else {
                System.out.println("  \u001b[31;1mInvalid Input\u001b[00;1m");
                unionBank(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void payment(double n) {
        if (c < c1) {
            System.out.println("\n  Enter 6 Digit Mpin for \u001b[91;1munion \u001b[94;1mBank\u001b[00;1m \n");
            int mpin = Recharge.a1.sc.nextInt();
            if (mpin > 99999 && mpin < 999999) {
                if (mpin == this.mpin) {
                    Balance = Balance - n;
                    if (Balance >= 0) {
                        Cvpay.Balance = Cvpay.Balance + ((n * 3) / 100) + n;
                        System.out.println(
                                "\n  \u001b[32;1mYour transaction is Completed Successfully \u001b[00;1m\n\n  ");

                        Recharge.a1.home();
                    } else {
                        System.out.println(
                                "\n           \u001b[91;1mUnion \u001b[94;1mBank\n\n\u001b[31;1m  Insufficient Funds\n\n  The money in your account is not enough for this payment\n\u001b[00;1m");
                        Balance = Balance + n;
                        back(n);
                    }

                } else {
                    c++;
                    System.out.println("\n  \u001b[97;41;1mIncorrect mpin attempt " + c + " out of " + c1
                            + " , Try again\u001b[00;1m\n");
                    tryAgain1(n);
                }
            } else {
                System.out.println("\n  \u001b[31;1mMPIN must contain 6 digits\n\u001b[00;1m");
                tryAgain1(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    static void tryAgain1(double n) {
        if (c < c1) {
            System.out.println("\n  1.Try again\n  2.forgotMpin\n  3.go back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                u1.payment(n);
            } else if (a == 2) {
                u1.forgotMpin(n);
            } else if (a == 3) {
                u1.unionBank(n);
            } else {
                System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
                tryAgain1(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void checkBal(double n) {
        if (c < c1) {
            System.out.println("\n  Enter 6 Digit Mpin for \u001b[91;1munion \u001b[94;1mBank\u001b[00;1m \n");
            int mpin = Recharge.a1.sc.nextInt();
            if (mpin > 99999 && mpin < 999999) {
                if (mpin == this.mpin) {
                    System.out.println("\n  \u001b[32;1mAvailable Balance fetched successfully\u001b[00;1m\n\n      "
                            + Union.Balance + "\n");
                    back(n);
                } else {
                    c++;
                    System.out.println("\n  \u001b[97;41;1mIncorrect mpin attempt " + c + " out of " + c1
                            + " , Try again\u001b[00;1m\n");
                    tryAgain(n);
                }
            } else {
                System.out.println("\n  \u001b[31;1mMPIN must contain 6 digits\n\u001b[00;1m");
                tryAgain(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void back(double n) {
        if (c < c1) {
            System.out.println("  1.go Back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                unionBank(n);
            } else {
                System.out.println("\n  \u001b[31;1mEnter Valid input\u001b[00;1m");
                back(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    static void tryAgain(double n) {
        if (c < c1) {
            System.out.println("\n  1.Try again\n  2.forgotMpin\n  3.go back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                u1.checkBal(n);
            } else if (a == 2) {
                u1.forgotMpin(n);
            } else if (a == 3) {
                u1.unionBank(n);
            } else {
                System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
                tryAgain(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void forgotMpin(double n) {
        if (c < c1) {
            System.out.println("\n  Enter debit card number of last 4 digits");
            int card = Recharge.a1.sc.nextInt();
            if (card == this.card) {
                pinValid(n);
            } else {
                System.out.println("\n  \u001b[91;1mCard Details Mismatched ! Try Again \n\u001b[00;1m");
                forgotMpin(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void pinValid(double n) {
        System.out.println("\n  Enter new 6 digit mpin");
        int mpin = Recharge.a1.sc.nextInt();
        if (mpin > 99999 && mpin <= 999999) {
            setUmpin(mpin);
            u1.unionBank(n);
        } else {
            System.out.println("\n  \u001b[31;1mMpin must be 6 digits\u001b[00;1m\n");
            pinValid(n);
        }

    }

    void setUmpin(int mpin) {
        this.mpin = mpin;
        System.out.println("\n  \u001b[32;1mYour Mpin for union bank is Successfully Changed\u001b[00;1m");

    }
}

class Sbi {
    static int c = 0, c1 = 3;
    static Sbi s1 = new Sbi();
    private int mpin = 1234;
    private int scard = 9968;
    static double Balance = 2000;

    static void sbi(double n) {
        if (c < c1) {
            System.out.println("\n  1.CheckBalance\n  2.go to payment\n  3.Go Back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                s1.checkBal(n);
            } else if (a == 2) {
                s1.payment(n);
            } else if (a == 3) {
                Addmoney.phonePe(n);
            } else {
                System.out.println("  \u001b[31;1mInvalid Input\u001b[00;1m");
                sbi(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void payment(double n) {
        if (c < c1) {
            System.out.println("\n  Enter 4 Digit Mpin for \u001b[94;1mSBI\u001b[00;1m \n");
            int mpin = Recharge.a1.sc.nextInt();
            if (mpin > 999 && mpin <= 9999) {
                if (mpin == this.mpin) {
                    Balance = Balance - n;
                    if (Balance >= 0) {
                        Cvpay.Balance = Cvpay.Balance + ((n * 3) / 100) + n;
                        System.out.println(
                                "\n  \u001b[32;1mYour transaction is Completed Successfully \u001b[00;1m\n\n  ");

                        Recharge.a1.home();
                    } else {
                        System.out.println(
                                "\n           \u001b[94;1mSBI\n\n\u001b[31;1m  Insufficient Funds\n\n  The money in your account is not enough for this payment\n\u001b[00;1m");
                        Balance = Balance + n;
                        back(n);
                    }
                } else {
                    c++;
                    System.out.println("\n  \u001b[97;41;1mIncorrect mpin attempt " + c + " out of " + c1
                            + " , Try again\u001b[00;1m\n");
                    tryAgain1(n);
                }
            } else {
                System.out.println("\n  \u001b[31;1mMPIN must contain 4 digits\n\u001b[00;1m");
                tryAgain1(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    static void tryAgain1(double n) {
        if (c < c1) {
            System.out.println("\n  1.Try again\n  2.forgotMpin\n  3.go back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                s1.payment(n);
            } else if (a == 2) {
                s1.forgotMpin(n);
            } else if (a == 3) {
                s1.sbi(n);
            } else {
                System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
                tryAgain1(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void checkBal(double n) {
        if (c < c1) {
            System.out.println("\n  Enter 4 Digit Mpin for \u001b[94;1mSBI\u001b[00;1m \n");
            int mpin = Recharge.a1.sc.nextInt();
            if (mpin > 999 && mpin <= 9999) {
                if (mpin == this.mpin) {
                    System.out.println("\n  \u001b[32;1mAvailable Balance fetched successfully\u001b[00;1m\n\n      "
                            + Sbi.Balance + "\n");
                    back(n);
                } else {
                    c++;
                    System.out.println("\n  \u001b[97;41;1mIncorrect mpin attempt " + c + " out of " + c1
                            + " , Try again\u001b[00;1m\n");
                    tryAgain(n);
                }
            } else {
                System.out.println("\n  \u001b[31;1mMPIN must contain 4 digits\n\u001b[00;1m");
                tryAgain(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void back(double n) {
        if (c < c1) {
            System.out.println("  1.go Back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                sbi(n);
            } else {
                System.out.println("\n  \u001b[31;1mEnter Valid input\u001b[00;1m");
                back(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    static void tryAgain(double n) {
        if (c < c1) {
            System.out.println("\n  1.Try again\n  2.forgotMpin\n  3.go back");
            int a = Recharge.a1.sc.nextInt();
            if (a == 1) {
                s1.checkBal(n);
            } else if (a == 2) {
                s1.forgotMpin(n);
            } else if (a == 3) {
                s1.sbi(n);
            } else {
                System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m\n");
                tryAgain(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void forgotMpin(double n) {
        if (c < c1) {
            System.out.println("\n  Enter debit card number of last 4 digits");
            int scard = Recharge.a1.sc.nextInt();
            if (scard == this.scard) {
                pinValid(n);
            } else {
                System.out.println("\n  \u001b[91;1mCard Details Mismatched ! Try Again \n\u001b[00;1m");
                forgotMpin(n);
            }
        } else {
            System.out.println("\n  \u001b[31;1mToo Many incorrect attempts try after 24 hours ");
            Recharge.a1.home();
        }
    }

    void pinValid(double n) {
        System.out.println("\n  Enter new 4 digit mpin");
        int mpin = Recharge.a1.sc.nextInt();
        if (mpin > 999 && mpin <= 9999) {
            setSmpin(mpin);
            s1.sbi(n);
        } else {
            System.out.println("\n  \u001b[31;1mMpin must be 4 digits\u001b[00;1m\n");
            pinValid(n);
        }

    }

    void setSmpin(int mpin) {
        this.mpin = mpin;
        System.out.println("\n  \u001b[32;1mYour Mpin for SBI is Successfully Changed\u001b[00;1m");

    }
}

class Reports {
    Scanner sc = new Scanner(System.in);

    void Display() {
        System.out.println("  1.Recharge Report");
        System.out.println("  2.Commission slab");
        int n = sc.nextInt();
        if (n == 1) {
            Rechreports.Display();
        } else if (n == 2) {
            new Commission().Display();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid input try again\n\u001b[00;1m");
        }
    }
}

class Commission {
    static Scanner sc = new Scanner(System.in);

    static void Airtel() {
        System.out.println("          ____________________________");
        System.out.println("          | \u001b[31;1m     AIRTEL \u001b[00;1m             |");
        System.out.println("          |   Range:10-10000         |");
        System.out.println("          |Lapu Commission           |");
        System.out.println("          |   Retailer:3%(COMMISSION)|");
        System.out.println("          |Operator Commission       |");
        System.out.println("          |   Retailer:0%(COMMISSION)|");
        System.out.println("          |__________________________|");
    }

    static void Jio() {
        System.out.println("          ____________________________");
        System.out.println("          | \u001b[31;1m    JIO \u001b[00;1m                 |");
        System.out.println("          |   Range:10-10000         |");
        System.out.println("          |Lapu Commission           |");
        System.out.println("          |   Retailer:3%(COMMISSION)|");
        System.out.println("          |Operator Commission       |");
        System.out.println("          |   Retailer:0%(COMMISSION)|");
        System.out.println("          |__________________________|");
    }

    static void Vi() {
        System.out.println("          ____________________________");
        System.out.println("          |\u001b[31;1m    Vi - Vodafone Idea\u001b[00;1m    |");
        System.out.println("          |   Range:10-10000         |");
        System.out.println("          |Lapu Commission           |");
        System.out.println("          |   Retailer:3%(COMMISSION)|");
        System.out.println("          |Operator Commission       |");
        System.out.println("          |   Retailer:0%(COMMISSION)|");
        System.out.println("          |__________________________|");
    }

    static void Display() {
        Airtel();
        Jio();
        Vi();
        System.out.println("\n  1.Home");
        int n = sc.nextInt();
        if (n == 1) {
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\n\u001b[00;1m");
            Display();
        }
    }
}

class Rechreports {
    static int c = 0;
    static Rechreports r1 = new Rechreports();
    static Rechreports r2 = new Rechreports();
    static Rechreports r3 = new Rechreports();
    static Rechreports r4 = new Rechreports();
    static Rechreports r5 = new Rechreports();
    static Rechreports r6 = new Rechreports();
    String ph;
    int amt;
    String ope;
    long Tid;
    double OB;
    double CB;
    String DT;

    static void Display() {
        if (c != 0) {
            if (c >= 1) {
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r1.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r1.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r1.ph);
                System.out.println("\n    Operator         : " + r1.ope);
                System.out.println("\n    O/B              : " + r1.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r1.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r1.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
            }
            if (c >= 2) {
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r2.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r2.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r2.ph);
                System.out.println("\n    Operator         : " + r2.ope);
                System.out.println("\n    O/B              : " + r2.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r2.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r2.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
            }
            if (c >= 3) {
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r3.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r3.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r3.ph);
                System.out.println("\n    Operator         : " + r3.ope);
                System.out.println("\n    O/B              : " + r3.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r3.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r3.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
            }
            if (c >= 4) {
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r4.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r4.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r4.ph);
                System.out.println("\n    Operator         : " + r4.ope);
                System.out.println("\n    O/B              : " + r4.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r4.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r4.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
            }
            if (c >= 5) {
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r5.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r5.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r5.ph);
                System.out.println("\n    Operator         : " + r5.ope);
                System.out.println("\n    O/B              : " + r5.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r5.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r5.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");

            }
            if (c >= 6) {
                System.out.println("______________________________________\n");
                System.out.println("\n    \u001b[91;1mDate & Time      : " + r6.DT);
                System.out.println("\n    \u001b[31;1mTransaction Id   : " + r6.Tid + "\u001b[00;1m");
                System.out.println("\n    Mobile No        : " + r6.ph);
                System.out.println("\n    Operator         : " + r6.ope);
                System.out.println("\n    O/B              : " + r1.OB);
                System.out.println("\n    amount           : \u001b[31;1m" + r1.amt + "\u001b[00;1m");
                System.out.println("\n    C/B              : " + r1.CB + "\n");
                System.out.println("______________________________________\n");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("\n  \u001b[31;1mNo Records found !\u001b[00;1m");
            home();
        }
        home();
    }

    static void home() {
        System.out.println("\n  1.home");
        int n = Recharge.a1.sc.nextInt();
        if (n == 1) {
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mInvalid Input\u001b[00;1m");
            home();
        }
    }

    static void report(String ph, int amt, String ope, long Tid, String DT) {
        c++;
        if (c == 1) {
            r1.ph = ph;
            r1.amt = amt;
            r1.ope = ope;
            r1.Tid = Tid;
            r1.OB = Cvpay.Balance + amt;
            r1.CB = Cvpay.Balance;
            r1.DT = DT;
        } else if (c == 2) {
            r2.ph = ph;
            r2.amt = amt;
            r2.ope = ope;
            r2.Tid = Tid;
            r2.OB = Cvpay.Balance + amt;
            r2.CB = Cvpay.Balance;
            r2.DT = DT;
        } else if (c == 3) {
            r3.ph = ph;
            r3.amt = amt;
            r3.ope = ope;
            r3.Tid = Tid;
            r3.OB = Cvpay.Balance + amt;
            r3.CB = Cvpay.Balance;
            r3.DT = DT;
        } else if (c == 4) {
            r4.ph = ph;
            r4.amt = amt;
            r4.ope = ope;
            r4.Tid = Tid;
            r4.OB = Cvpay.Balance + amt;
            r4.CB = Cvpay.Balance;
            r4.DT = DT;
        } else if (c == 5) {
            r5.ph = ph;
            r5.amt = amt;
            r5.ope = ope;
            r5.Tid = Tid;
            r5.OB = Cvpay.Balance + amt;
            r5.CB = Cvpay.Balance;
            r5.DT = DT;
        } else if (c == 6) {
            r6.ph = ph;
            r6.amt = amt;
            r6.ope = ope;
            r6.Tid = Tid;
            r6.OB = Cvpay.Balance + amt;
            r6.CB = Cvpay.Balance;
            r6.DT = DT;
        }
    }
}

class Conform {
    static void confirmation(String ph, int amt, String ope) {
        System.out.println(
                "\n  \u001b[97;46;1m Note : Please verify all information before doing transaction, After transaction our company will not be responsible\u001b[00;1m");
        System.out.println("\n         \u001b[31;1mRecharge Alert !\u001b[00m\n\n      Mobile No : " + ph
                + "\n      Amount    : " + amt + "\n      Operator  : " + ope
                + " \n\n         \u001b[97;101;1m CANCEL \u001b[00;1m   \u001b[106;97;1m OK \u001b[00;1m\n");
        String n = Cvpay.sc.next();
        if (n.equalsIgnoreCase("ok")) {
            Cvpay.Balance = Cvpay.Balance - amt;
            if (Cvpay.Balance <= 0) {
                System.out.println("\n  \u001b[31;1mNot enough Balance please add money to wallet\n\u001b[00;1m\n");
                Cvpay.Balance = Cvpay.Balance + amt;
                System.out
                        .println("    \u001b[100;97;1mYour wallet balance is --> " + Cvpay.Balance + " \u001b[00;1m\n");
                Recharge.a1.home();
            } else {
                System.out.println("   \u001b[32;1mYour Recharge was Succesfully completed Mobile number \u001b[00;1m"
                        + ph + " \u001b[32;1mwith \u001b[00;1m" + amt + " \u001b[00;1mRs");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String DT = formatter.format(date);
                System.out.println("\n   Date and Time : " + DT);
                long transaction = Conform.random();
                System.out.println("\n   Transaction Id is  " + transaction + "\n\n   \u001b[100;97;1m"
                        + "  Your Wallet balance is " + Cvpay.Balance + " \u001b[00;1m\n");
                Rechreports.report(ph, amt, ope, transaction, DT);
                next();
            }
        } else if (n.equalsIgnoreCase("cancel")) {
            new Rech().operator(ph);
        } else {
            System.out.println("\n  \u001b[31;1mPlease choose correct Option\n\u001b[00;1m");
            confirmation(ph, amt, ope);
        }
    }

    static long random() {
        Random rand = new Random();
        long randomNum = (long) (rand.nextDouble() * 1_000_000_000L) + 1_000_000_000L;
        return randomNum;
    }

    static void next() {
        System.out.println("  Press 1 for Recharge another number \n  Press 2 for Goto home");
        int n = Cvpay.sc.nextInt();
        if (n == 1) {
            new Rech().Recharge();
        } else if (n == 2) {
            Recharge.a1.home();
        } else {
            System.out.println("\n  \u001b[31;1mWrong Input try again\n\u001b[00;1m");
            next();
        }
    }
}
