package au.com.robotMovement.domain;

/**
 * @author rnadeera
 */
public class Table {

    private int rows;
    private int columns;

    private Robot robot;

    private Table(){
    }

    public static Table buildSquareTableTop(int units){
        Table squareTable = new Table();
        squareTable.setRows(units);
        squareTable.setColumns(units);
        return squareTable;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * This method create new {@link Robot} instance if no {@link Robot} is exists is the table,
     * else return already assigned {@link Robot}
     *
     * @return {@link Robot} instance
     */
    public Robot getRobotInstance(){
        if(robot != null){
            return robot;
        }

        robot = new Robot(this);
        return robot;
    }

    /**
     * Check given x and y coordinates are valid for the table
     *
     * @param cordinatesX new x-coordinate
     * @param cordinatesY new y-coordinate
     * @return boolean value stating validity
     */
    public boolean isValidPosition(int cordinatesX, int cordinatesY){
        return cordinatesX >= 0 && cordinatesX <= rows && cordinatesY >= 0 && cordinatesY <= columns;
    }
}
