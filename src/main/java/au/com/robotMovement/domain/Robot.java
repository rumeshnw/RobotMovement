package au.com.robotMovement.domain;

/**
 * @author rnadeera
 */
public class Robot {

    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isRobotPlacedOnTable(){
        return coordinates != null && coordinates.getDirection() != null;
    }

    /**
     * Method create new {@link Coordinates} instance if not exists
     *
     * @return {@link Coordinates} instance
     */
    public Coordinates getCoordinatesInstance(){
        if(coordinates == null){
            coordinates = new Coordinates();
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return coordinates.toString();
    }
}
