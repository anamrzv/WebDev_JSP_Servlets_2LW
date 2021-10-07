package other;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Context {
    private static Context contextInstance = new Context();
    private List<ResultEntity> resultsInContext;

    private Context() {
        resultsInContext = new ArrayList<>();
    }

    public static Context getInstance(){
        return contextInstance;
    }

    public void addResult(ResultEntity newResult) {
        resultsInContext.add(newResult);
    }
}
