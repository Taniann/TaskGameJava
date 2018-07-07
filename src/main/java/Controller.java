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
        System.out.println(model.getRequestedNumber());
        System.out.println(View.INPUT_INT_DATA);
        model.setUserNumber(inputData());
        while (!model.isGuessed()) {
                checkIfUserNumberIsSuitable();
            }
        System.out.println(View.CONGRATULATION);
        System.out.println(model.getPreviousNumbers().toString());
    }

    public void checkIfUserNumberIsSuitable () {
        while ((model.getUserNumber() < model.getUserMinLimit()) || (model.getUserNumber() > model.getUserMaxLimit())) {
            System.out.println(View.WRONG_INPUT_DATA);
            model.setUserNumber(inputData());
        }
        if (model.isRequestedNumberGreaterThanUserNumber()) {
                System.out.println(View.GRATER);
                model.changeUserMinLimit();
                model.getPreviousNumbers().add(model.getUserNumber());
                model.setUserNumber(inputData());
            }
        else if (!model.isRequestedNumberGreaterThanUserNumber()) {
                System.out.println(View.SMALLER);
                model.changeUserMaxLimit();
                model.getPreviousNumbers().add(model.getUserNumber());
                model.setUserNumber(inputData());
            }
    }

    private int inputData(){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
}
