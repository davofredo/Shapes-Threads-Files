package config;

public class UnitSetting {
    // TODO: Unit literals should be stored into constants

    private String unit = "m";

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValueWithUnit (double value, String unit) {
        double newValue = 0;
        switch (unit) {
            case "mm":
                newValue = value / 1000;
                break;
            case "cm":
                newValue = value / 100;
                break;
            case "m":
                // TODO: Avoid unnecessary arithmetic operations
                newValue = value / 1;
                break;
        }
        return newValue;
    }

    public void unit(String unit) {
        // TODO: Instead of switch it could be a validation if. IE [ if ("mm".equals(unit) || "cm".equals(unit) || "m".equals(unit) setUnit(unit) ]
        switch (unit) {
            case "mm":
                setUnit("mm");
                break;
            case "cm":
                setUnit("cm");
                break;
            case "m":
                setUnit("m");
                break;
        }
    }
}
