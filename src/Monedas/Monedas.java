
package Monedas;

import java.util.Map;

public class Monedas {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Monedas(String base_code, Map<String, Double> conversion_rates) {
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}


