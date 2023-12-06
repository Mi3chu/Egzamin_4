package zadanie2.exceptions;

public class CurrencyWithThisNameDoNotExist extends IllegalArgumentException{
    public CurrencyWithThisNameDoNotExist(String message){super(message);}
}
