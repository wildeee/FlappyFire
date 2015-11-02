package flappyfirebird.wilde.com.br.flappyfire;

public enum EMovementType {

    SOBE(3),
    DESCE(6);

    private final int step;

    private EMovementType(int step){
        this.step = step;
    }

    public int getStep(){
        return this.step;
    }

}
