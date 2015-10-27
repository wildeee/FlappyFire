package flappyfirebird.wilde.com.br.flappyfire;

public class Structure {
    private Obstacle up;
    private Obstacle down;
    private Gap gap;
    private boolean valid;

    public Structure() {
        valid = true;
        up = new Obstacle();
        up.setX(GameParameterSingleton.SCREEN_WIDTH);
        int y = (int) (Math.random() % 1000) % up.getHeight();
        y = y > 0 ? y * -1 : y;
        up.setY(y);

        up.updateDistortion();
        gap = new Gap(up.getX(), up.getHeight(), 40, 60);
        gap.updateDistortion();

        down = new Obstacle();
        down.setX(up.getX());
        down.setY(gap.getY() + gap.getHeight());
        down.updateDistortion();
    }

    public void update(){
        up.update();
        gap.update();
        down.update();
    }
}
