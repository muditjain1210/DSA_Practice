package algosec;

public class Segment {
    private float left;
    private float right;

    public Segment(float left, float right) {
        this.left = left;
        this.right = right;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getRight() {
        return right;
    }

    public void setRight(float right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
