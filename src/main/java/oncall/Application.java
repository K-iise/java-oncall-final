package oncall;

import oncall.controller.Controller;
import oncall.service.WorkService;
import oncall.util.Parser;
import oncall.util.Validator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        Parser parser = new Parser();
        WorkService workService = new WorkService();

        Controller controller = new Controller(inputView,outputView,validator,parser, workService);
        controller.run();
    }
}
