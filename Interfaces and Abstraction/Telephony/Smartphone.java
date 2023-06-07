package InterfacesAndAbstraction_Ex.Telephony;


import java.util.List;

public class Smartphone implements Browsable,Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            if (isValidUrl(url)) {
                builder.append(String.format("Browsing: %s!", url));
            } else {
                builder.append("Invalid URL!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }


    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            if (isValidNumber(number)) {
                builder.append(String.format("Calling... %s", number));
            } else {
                builder.append("Invalid number!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public boolean isValidNumber (String number){
        for(char symbol : number.toCharArray()){
            if(!Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }
    public boolean isValidUrl(String url){
        for(char symbol : url.toCharArray()){
            if(Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }
}
