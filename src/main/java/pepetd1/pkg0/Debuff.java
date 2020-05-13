package pepetd1.pkg0;

public class Debuff{
    private ElementalType type;
    private int maxDuration;
    private int currentDuration;
    private int decreaseSpeed = 5;
    private int maxTickTime;
    private int currentTickTime;
    
    public Debuff(ElementalType type){
        this.type = type;

        switch (this.type){
            case FIRE:
                this.maxDuration = 30;
                this.maxTickTime = 3;
                break;
            case ICE:
                this.maxDuration = 30;
                this.maxTickTime = this.maxDuration;
                break;
            case ELECTRIC:
                this.maxDuration = 30;
                this.maxTickTime = this.maxDuration;
                break;
        }

        this.currentDuration = this.maxDuration;
        this.currentTickTime = this.maxTickTime;
    }

    public void update(){
        this.currentDuration -= this.decreaseSpeed;
        this.currentTickTime -= this.decreaseSpeed;

        if(this.currentTickTime <= 0){
            this.currentTickTime = maxTickTime;
        }
    }

    public void resetCurrentTickTime(){
        this.currentTickTime = this.maxTickTime;
    }

    public void reset(){
        this.currentDuration = this.maxDuration;
        this.resetCurrentTickTime();
    }

    public ElementalType getType(){
        return this.type;
    }

    public int getCurrentDuration(){
        return this.currentDuration;
    }

    public int getCurrentTickTime(){
        return this.currentTickTime;
    }

    @Override
    public boolean equals(Object obj) {
        return this.type == ((Debuff)obj).getType();
    }

    @Override
    public int hashCode(){
        return this.type.hashCode();
    }
}
