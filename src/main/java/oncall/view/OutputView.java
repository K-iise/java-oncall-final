package oncall.view;

import java.util.Map;
import oncall.model.Month;
import oncall.model.WorkResult;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWorkResult(WorkResult workResult) {
        Map<Integer, String> map = workResult.getWorkSchedule();
        Month month = workResult.getMonth();
        System.out.println();
        for (Integer key : map.keySet()) {
            System.out.println(month.getMonth() + "월 " + key  + "일 " + map.get(key));
        }
    }
}
