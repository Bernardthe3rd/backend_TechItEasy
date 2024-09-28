package nl.novi.techiteasy;

public enum AvailableSize {
    SMAL("40 inch"), MEDIUM("45 inch"), LARGE("55 inch"), EXTRA_LARGE("65 inch");

    public final String size;

    AvailableSize(String size) {
        this.size = size;
    }
}
