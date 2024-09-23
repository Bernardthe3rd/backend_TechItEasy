package nl.novi.techiteasy;

public enum availableSize {
    SMAL("40 inch"), MEDIUM("45 inch"), LARGE("55 inch"), EXTRA_LARGE("65 inch");

    public final String size;

    availableSize(String size) {
        this.size = size;
    }
}
