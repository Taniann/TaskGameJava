import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 07.07.2018.
 */
public class Model {
    public static final int MIN_LIMIT = 1;
    public static final int MAX_LIMIT = 99;

    private int userMinLimit = MIN_LIMIT;
    private int userMaxLimit = MAX_LIMIT;

    private int requestedNumber;
    private int userNumber;

    List<Integer> previousNumbers = new ArrayList<>();

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getUserMinLimit() {
        return userMinLimit;
    }

    public int getUserMaxLimit() {
        return userMaxLimit;
    }

    public List<Integer> getPreviousNumbers() {
        return previousNumbers;
    }

    public void toRequestNumber () {
        requestedNumber = MIN_LIMIT + (int)(Math.random()* (MAX_LIMIT - MIN_LIMIT));
    }

    public boolean isGuessed() {
        if (userNumber == requestedNumber) return true;
                else return false;
    }

    public boolean isRequestedNumberGreaterThanUserNumber () {
        return requestedNumber > userNumber;
    }

    public void changeUserMinLimit () {
        userMinLimit = userNumber;
    }

    public void changeUserMaxLimit () {
        userMaxLimit = userNumber;
    }

    public int getRequestedNumber() {
        return requestedNumber;
    }
}
