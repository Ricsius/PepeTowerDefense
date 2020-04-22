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
        this.tickTime -= this.decreaseSpeed;

        if(tickTime <= 0){
            tickTime = maxTickTime;
        }
    }

    public void reset(){
        this.currentDuration = this.maxDuration;
        this.tickTime = this.maxTickTime;
    }

    public ElementalType getType(){
        return this.type;
    }

    public int getCurrentDuration(){
        return this.currentDuration;
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
