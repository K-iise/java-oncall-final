package oncall.controller;

import java.util.List;
import oncall.model.WorkInfo;
import oncall.model.WorkTemple;
import oncall.util.Parser;
import oncall.util.Validator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final Parser parser;

    public Controller(InputView inputView, OutputView outputView, Validator validator, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.parser = parser;
    }

    public void run(){
        WorkInfo workInfo = loopWorkInfo();

        WorkTemple workTemple = loopWorkTemple();
    }

    public WorkInfo loopWorkInfo(){
        while (true) {
            try {
                String input = inputView.readWorkInfo();
                validator.validateFormat(input);
                return WorkInfo.FromList(parser.separateWorkInfo(input));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public WorkTemple loopWorkTemple(){
        while (true) {
            try {
                String weekdayTemple = inputView.readWeekdayTemple();
                String weekendTemple = inputView.readWeekendTemple();
                List<String> weekdayList = parser.parseWokdTempleList(weekdayTemple);
                List<String> weekendList = parser.parseWokdTempleList(weekendTemple);
                return new WorkTemple(weekdayList, weekendList);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
