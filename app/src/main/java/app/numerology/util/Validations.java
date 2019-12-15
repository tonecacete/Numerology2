package app.numerology.util;

public class Validations {

    public static boolean isValidDay(String day, String month){
        int dayValue = Integer.valueOf(day);
        int monthValue = Integer.valueOf(month);

        if(dayValue > 29 && monthValue == 2){
            return false;
        }else if(dayValue <= 31 && month.equalsIgnoreCase("")){
            return false;
        }if(dayValue == 31 && (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12)){
            return true;
        }else if(dayValue == 30 && (monthValue == 4 || monthValue == 6 || monthValue == 9 || monthValue == 11)){
            return true;
        }else if(month.equalsIgnoreCase("")){
            return false;
        }else if(dayValue <= 31){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isValidDay(String day){
        int dayValue = Integer.valueOf(day);

        if(dayValue <= 31 && dayValue > 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isValidMonth(String day, String month){
        int dayValue = Integer.valueOf(day);
        int monthValue = Integer.valueOf(month);

        if(dayValue == 31 && (monthValue == 4 || monthValue == 6 || monthValue == 9 || monthValue == 11)){
            return false;
        }else if(monthValue <= 12 && monthValue > 0){
            return true;
        }else if(month.equalsIgnoreCase("") || month == null){
            return false;
        }else{
            return false;
        }
    }

    public static boolean isValidMonth(String month){

        if(month.equalsIgnoreCase("") ){
            return false;
        }else{
            int monthValue = Integer.valueOf(month);
            if(monthValue <= 12 ){
                return true;
            }else{
                return false;
            }
        }
    }
}
