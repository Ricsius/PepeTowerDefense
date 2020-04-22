public class Debuff{
    private ElementalType type;
    private int maxDuration;
    private int currentDuration;
    private int decreaseSpeed = 5;
    private int tickTime;
    
    public Debuff(ElementalType type){
        this.type = type;

        switch (this.type){
            case FIRE:
                break;
            case ICE:
                break;
            case ELECTRIC:
                break;
        }
    }

    public void update(){
        this.currentDuration -= this.decreaseSpeed;
        this.tickTime -= this.decreaseSpeed;

        if(tickTime <= 0){
        }
    }

    public void reset(){
        this.currentDuration = this.maxDuration;
        this.tickTime = this.maxDuration;
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
