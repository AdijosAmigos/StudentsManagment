public enum GradeValue {
    ONE(1), TWO(2), THREE(3), THREE_PLUS(3.5f), FOUR(4), FOUR_PLUS(4.5f), FIVE(5);

    private final float value;

    GradeValue(float value) {
        this.value = value;
    }


    public float getValue() {
        return value;
    }
}
