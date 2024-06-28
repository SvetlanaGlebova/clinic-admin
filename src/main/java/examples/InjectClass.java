package examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectClass {
    private Runnable runnable;

    public InjectClass(Runnable runnable) {
        this.runnable = runnable;
    }
@Autowired
    public void inject01(Runnable runnable){}

    @Autowired
    public void inject02(@Qualifier("rBean")
                         Runnable runnable){};
    @Autowired
        public void inject03(Runnable runnable02){};

}
