package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int RIFLE_BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS_RIFLE = 500;
    private static final int BULLETS_SHOT_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, RIFLE_BULLETS_PER_BARREL, TOTAL_BULLETS_RIFLE);
    }

    @Override
    public int fire() {
        if(getBulletsPerBarrel() == 0 && getTotalBullets() > 0){
            reload();

        }
        if(getBulletsPerBarrel() > 0){
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_SHOT_PER_SHOT);
        }
        return BULLETS_SHOT_PER_SHOT;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - RIFLE_BULLETS_PER_BARREL);
        setBulletsPerBarrel(RIFLE_BULLETS_PER_BARREL);
    }
}
