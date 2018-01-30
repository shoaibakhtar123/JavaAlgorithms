import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestIcecream {

    public static void main(String[] args) {

        TenderStatus s = TenderStatus.valueOf("RETRY");

        if (TenderStatus.RETRY == s){
            System.out.println("success");
        }
//        int i = 2/2;
//        int j = 3/2;
////        System.out.println(i + " " + j);
//        int[] a = {1,2,3,4};
//        String str = " ";
//        int index = str.indexOf(String.valueOf(a[i]),str.indexOf(a[i]) + 1);

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr).length());
    }


//    private static boolean isValidateCheckDigitForBankTransfer(String iban) {
//
//        boolean valid=false;
//
//        String result=null;
//        String chkDigit = iban.substring(2, 4);
//        BigDecimal data = new BigDecimal(0.0);
//        String countryCode= iban.substring(0,2);
//        String countryCodeNumeric="";
//        for(int i =0; i < countryCode.length() ;i++)
//        {
//
//            if(IbanConstants.mapForBankTransfer.get(String.valueOf(countryCode.charAt(i))) != null)
//            {
//                countryCodeNumeric = countryCodeNumeric + IbanConstants.mapForBankTransfer.get(String.valueOf(countryCode.charAt(i)));
//            }
//        }
//
//        try
//        {
//            String accountNumber=iban.substring(15,27);
//            String checkChar=iban.substring(4,5);
//            String bankCode=iban.substring(5,15);
//
//
//
//            String acntNumber="", charCode="";
//            for(int i=0; i < accountNumber.length(); i++)
//            {
//                charCode = IbanConstants.mapForBankTransfer.get(String.valueOf(accountNumber.charAt(i)));
//                if(charCode!=null)
//                {
//                    acntNumber = acntNumber +  charCode;
//                }
//                else
//                {
//                    acntNumber = acntNumber + String.valueOf(accountNumber.charAt(i));
//                }
//            }
//
//            String checkCharNumeric = IbanConstants.mapForBankTransfer.get(checkChar);
//
//            if(acntNumber!=null && acntNumber.length() > ((27)-1))
//            {
//                result=checkCharNumeric+bankCode+acntNumber+countryCodeNumeric+chkDigit;
//
//                data = new BigDecimal(result).remainder(new BigDecimal(97.0));
//                result=(String.valueOf(data));
//            }
//
//            if(result.equals("1"))
//            {
//                System.out.println("Check Digit is valid.");
//                valid = true;
//            }
//            else{
//                System.out.println("Check Digit is invalid.");
//            }
//        }
//        catch(IndexOutOfBoundsException e)
//        {
//            System.out.println("IBAN for Bank Transfer Tender not in proper format ");
//        }
//        return valid;
//    }

    public static void showFlavors(HashMap<String, Integer> iceCreamFlavors, int amount){

        String firstFlavor = null;
        String secondFlavor = null;
        int firstFlavorPrice = 0;
        int secondFlavorPrice = 0;
        boolean firstFlavorBought = false;
        boolean secondFlavorBought = false;
        int index = 0;
        int originalAmount = amount;
        List<String> firstFlavorChoosed = new ArrayList<String>();

        while (!secondFlavorBought){
            firstFlavor = null;
            secondFlavor = null;
            firstFlavorPrice = 0;
            secondFlavorPrice = 0;
            firstFlavorBought = false;
            secondFlavorBought = false;
            amount = originalAmount;
            index++;

            if (index == iceCreamFlavors.size()){
                System.out.println("Cannot buy any flavor");
                break;
            }

            for (String flavor : iceCreamFlavors.keySet()){
                int price = iceCreamFlavors.get(flavor);

                System.out.println("Index = " + index + " flavor=" + flavor + " price = " + price);

                if (price < amount){
                    if (!firstFlavorBought && !firstFlavorChoosed.contains(flavor)){
                        System.out.println("purchasing the first one " + flavor);
                        firstFlavorBought = true;
                        firstFlavor = flavor;
                        firstFlavorPrice = price;
                        amount = amount - price;
                        firstFlavorChoosed.add(flavor);
                    }
                } else if (price == amount){
                    if (firstFlavorBought){
                        System.out.println("purchasing the second one " + flavor);
                        secondFlavor = flavor;
                        secondFlavorPrice = price;
                        secondFlavorBought = true;
                        break;
                    }
                }

            }

        }

        System.out.println("First Flavor = " + firstFlavor);
        System.out.println("First Flavor price = " + firstFlavorPrice);
        System.out.println("Second Flavor = " + secondFlavor);
        System.out.println("Second Flavor price = " + secondFlavorPrice);
    }

    public static enum TenderStatus {

        STARTED(true),
        BEFORESWIPE(true),
        AFTERSWIPE(true),
        AUTHORIZING(false),
        APPROVED(false),
        AUTH_APPROVED(false),
        DECLINED(true),
        REFERRAL(true),
        TIMEOUT(true),
        CANCELLED(true),
        SUSPENDED(true),
        ERROR(true),
        INVALID_SECURITY(true),
        INVALID_PIN(true),
        POSITIVEID(true),
        REVERSAL_APPROVED(true),
        REVERSAL_DECLINED(true),
        REVERSAL_REQUIRED(true),
        REVERSAL_IN_PROGRESS (true),
        PENDING_LOGON(true),
        PENDING_SETTLEMENT(true),
        REV_REF_REQUIRED(true),
        RESPONSE_TIMEOUT(true),
        RT_RECOVRED(true),
        RT_VOIDED(true),
        CHECK_DATA_READ(true),
        CHECK_READ_FAILED(true),
        RT_NOT_AN_ISSUE(true),
        RT_CUP_VOID_NOT_SUPP(true),
        GC_PURCHASE_EXCEEDED(true),
        ENQUIRE_ACK_TIMEOUT(true),
        DEVICE_ACK_TIMEOUT(true),
        UNKNOWN(true),
        RETRY(true),
        REFUND_APPROVED(true),
        PROMPT_LAST_FOUR(true),
        TIMEOUT_REFERRAL(true),
        DECLINED_RETRY_CARD(true),
        DECLINED_RETRY_ADDR(true),
        MULTIPLE_CARDS_DETECTED(true),
        DECLINED_TEMPORARY(true);


        private final boolean cancelAllowed;

        TenderStatus(boolean cancelAllowed) {
            this.cancelAllowed = cancelAllowed;
        }

        public boolean isCancelAllowed() {
            return cancelAllowed;
        }

        public static TenderStatus getStatus(String statusStr) {
            return TenderStatus.valueOf(statusStr);
        }

    }
}
