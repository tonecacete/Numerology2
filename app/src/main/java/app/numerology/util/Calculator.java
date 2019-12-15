package app.numerology.util;

import java.util.ArrayList;

import app.numerology.model.Matriz;

public class Calculator {
    Matriz matriz = new Matriz();

    public Calculator(){
        matriz.getMap();
    }

    public int getNrLicaoDeVida(String day, String month ,String year){
        int total=0;
        int yearAux =0;
        String str;

        if(day.length() == 2){
            total += (Integer.valueOf(day.substring(0,1)) + Integer.valueOf(day.substring(1)));
        }else if(day.length() == 1){
            total += Integer.valueOf(day);
        }

        if(month.length() == 2){
            total += (Integer.valueOf(month.substring(0,1)) + Integer.valueOf(month.substring(1)));
        }else if(day.length() == 1){
            total += Integer.valueOf(month);
        }

        yearAux += (Integer.valueOf(year.substring(0,1)) + Integer.valueOf(year.substring(1,2)) + Integer.valueOf(year.substring(2,3)) + Integer.valueOf(year.substring(3)));

        year = String.valueOf(yearAux) ;
        total += calcRecursive(year);

        str = String.valueOf(total);
        total = calcRecursive(str);

        return total;
    }

    private int calcRecursive(String value){
        int res = 0;
        String str;
        str = value;
        res = Integer.valueOf(value);

        while(str.length() > 1){
            res=0;
            for(int i = 0; i < str.length() ; i++){
                res += Integer.valueOf(String.valueOf(str.charAt(i)));
            }
            str = String.valueOf(res);
            calcRecursive(str);
        }
        return res;
    }

    private int getNrValue(int num){
        int result = 0;
        String nr = String.valueOf(num);
        char[] chars = new char[nr.length()];

        for(int i=0; i <nr.length(); i++){
            result = nr.charAt(i);
            System.out.println("valor: "+chars[i]);
        }

        return result;
    }

    public Integer getNameValue(String name){
        Integer total=0;
        Integer totalParcial=0;
        ArrayList<Integer> arr = new ArrayList();
        name = name.toUpperCase();
        char[] chars = new char[name.length()];

        for(int z=0; z < name.length() ;z++){
            chars[z] = name.charAt(z);
            if(chars[z]==' ' || z == ((name.length()) - 1) ){
                if(z == ((name.length()) - 1)){
                    totalParcial+=matriz.getLetterValue(chars[z]);
                }
                arr.add(calcRecursive(String.valueOf(totalParcial)));
                totalParcial=0;
                continue;
            }
            totalParcial+=matriz.getLetterValue(chars[z]);
        }


        for(int h = 0 ; h < arr.size();h++){
            total += arr.get(h);
        }
        total = calcRecursive(total.toString());
        return total;
    }
}