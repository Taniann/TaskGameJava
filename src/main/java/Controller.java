import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Таня on 07.07.2018.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        model.toRequestNumber();
        view.printMessage(String.valueOf(model.getRequestedNumber()));
        view.printMessage(View.INPUT_INT_DATA);
        model.setUserNumber(inputUserNumber());
        while (!model.isGuessed()) {
                if (isLimitsCorrect()) {
                    checkIfUserNumberIsSuitable();
                    model.setUserNumber(inputUserNumber());
                }
                else {
                    view.printMessage(View.WRONG_INPUT_DATA);
                    model.setUserNumber(inputUserNumber());
                }
            }
        view.printMessage(View.CONGRATULATION);
        view.printMessage(model.getPreviousNumbers().toString());
    }

    public boolean isLimitsCorrect () {
        if ((model.getUserNumber() >= model.getUserMinLimit()) && (model.getUserNumber() <= model.getUserMaxLimit()))
            return true;
        else return  false;
    }

    public void checkIfUserNumberIsSuitable () {
         if (model.isRequestedNumberGreaterThanUserNumber()) {
                view.printMessage(View.GRATER);
                model.changeUserMinLimit();
                model.getPreviousNumbers().add(model.getUserNumber());
               // model.setUserNumber(inputUserNumber());
            }
         if (model.isRequestedNumberSmallerThanUserNumber()) {
                view.printMessage(View.SMALLER);
                model.changeUserMaxLimit();
                model.getPreviousNumbers().add(model.getUserNumber());
               // model.setUserNumber(inputUserNumber());
            }
    }

    private int inputUserNumber(){
        Scanner sc = new Scanner(System.in);
        int number =  sc.nextInt();
        return number;
    }
}
