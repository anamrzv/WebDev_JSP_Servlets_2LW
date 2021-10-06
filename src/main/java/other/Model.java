package other;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model modelInstance = new Model();
    private List<ResultEntity> results;

    private Model(){
        results = new ArrayList<>();
    }

    public static Model getInstance(){
        return modelInstance;
    }
}
