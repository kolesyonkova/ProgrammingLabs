package util;

public class Exchanger {
    public static ExchangeClass exchangeClass = new ExchangeClass();

    public static ExchangeClass getExchangeClass() {
        return exchangeClass;
    }

    public static void setExchangeClass(ExchangeClass exchangeClass) {
        Exchanger.exchangeClass = exchangeClass;
    }
}
