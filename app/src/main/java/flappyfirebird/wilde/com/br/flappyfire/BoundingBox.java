package flappyfirebird.wilde.com.br.flappyfire;

public class BoundingBox {
    int x;
    int y;
    int height;
    int width;


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }


    public String toString(){
        return ("BoundingBox:" + x + "," + y + "," + width + "," + height);
    }





}
