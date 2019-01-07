package Geometry;

/**
 * Enum que representa el sentido de giro
 */
public enum SENSE {

    NEGATIVE(-1),
    POSITIVE(1);

    private int sign;

    SENSE(int sign) {
        this.sign = sign;
    }

}
