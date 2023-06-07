package Encapsulatio_Ex.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea(){
        return 2*getLength()*getWidth() + 2*getLength()*getHeight() + 2*getWidth()*getHeight();
    }
    public double calculateLateralSurfaceArea(){
        return 2 * getHeight() * (getWidth() + getLength());
    }

    public double calculateVolume(){
    return getHeight() * getLength() * getWidth();
    }
}
