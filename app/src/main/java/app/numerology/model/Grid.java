package app.numerology.model;

public class Grid {

    private String[][] tabela;

    public Grid(){
        tabela = new String[3][3];
    }

    public String[][] allocateAllNumbers(String date){
        for(int i=0 ; i< date.length(); i++){
            allocateNumber(String.valueOf(date.charAt(i)));
        }
        System.out.println("CENAS" + tabela);
        return tabela;
    }

    private void allocateNumber(String s){
    String previousStr="";
        switch(s){
            case "1":
                if(tabela[2][0] == null){
                    tabela[2][0] = previousStr;
                }
                tabela[2][0] = tabela[2][0] + s ;
                break;
            case "2":
                if(tabela[1][0] == null){
                    tabela[1][0] = previousStr;
                }
                tabela[1][0] = tabela[1][0] + s ;
                break;
            case "3":
                if(tabela[0][0] == null){
                    tabela[0][0] = previousStr;
                }
                tabela[0][0] = tabela[0][0] + s ;
                break;
            case "4":
                if(tabela[2][1] == null){
                    tabela[2][1] = previousStr;
                }
                tabela[2][1] = tabela[2][1] + s ;
                break;
            case "5":
                if(tabela[1][1] == null){
                    tabela[1][1] = previousStr;
                }
                tabela[1][1] = tabela[1][1] + s ;
                break;
            case "6":
                if(tabela[0][1] == null){
                    tabela[0][1] = previousStr;
                }
                tabela[0][1] = tabela[0][1] + s ;
                break;
            case "7":
                if(tabela[2][2] == null){
                    tabela[2][2] = previousStr;
                }
                tabela[2][2] = tabela[2][2] + s ;
                break;
            case "8":
                if(tabela[1][2] == null){
                    tabela[1][2] = previousStr;
                }
                tabela[1][2] = tabela[1][2] + s ;
                break;
            case "9":
                if(tabela[0][2] == null){
                    tabela[0][2] = previousStr;
                }
                tabela[0][2] = tabela[0][2] + s ;
                break;
            default:
                System.out.println("NOTHING");
        }

    }
    public String[][] getTabela() {
        return tabela;
    }

    public void setTabela(String[][] tabela) {
        this.tabela = tabela;
    }


}
